package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.generar_historial;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.buscar_por_id_agregado.BuscarEventoDominioPorIdQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.generar_historial.IGeneradorHistorialFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventsInformation;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;


import java.beans.FeatureDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public final class GeneradorHistorialFormularioImpl implements IGeneradorHistorialFormulario {
    private final FormularioRepository repository;
    private final QueryBus queryBus;
    private final FormularioValidador validador;
    private final DomainEventsInformation eventsInformation;

    public GeneradorHistorialFormularioImpl(FormularioRepository repository, QueryBus queryBus, FormularioValidador validador, DomainEventsInformation eventsInformation) {
        this.repository = repository;
        this.queryBus = queryBus;
        this.validador = validador;
        this.eventsInformation = eventsInformation;
    }

    @Override
    public FormulariosResponse generadorHistorial(FormularioId id) {
        Formulario formulario = repository.findById(id).orElseThrow(() -> new FormularioNotExist(id, validador.crearValidacionFormularioNoExistente()));
        FormularioResponseGenerico formularioOriginal = FormularioResponseGenerico.fromAggregate(formulario);
        List<DomainEvent> formularioResponseGenericoList = new ArrayList<>();
        List<FormularioResponseGenerico> formularioResponseGenericoList2 = new ArrayList<>();


        try {
            AnalyticsDomainEventsResponse responses = queryBus.ask(new BuscarEventoDominioPorIdQuery(id.value()));
            formularioResponseGenericoList.addAll(responses.response().stream()
                    .map(analyticsDomainEventResponse -> getCompraResponse(analyticsDomainEventResponse))
                    .collect(Collectors.toList()));
            List<DomainEvent> listOrdenada = formularioResponseGenericoList.stream().sorted(Comparator.comparing(DomainEvent::occurredOn).reversed()).collect(Collectors.toList());
            FormularioResponseGenerico formularioOriginalAux = null;
            FormularioResponseGenerico resultado=null;
            for( DomainEvent domainEvent : listOrdenada ){
                formularioOriginalAux  =  resultado == null ? (FormularioResponseGenerico)formularioOriginal.clone(): resultado;
                resultado = getCopyFormualarioDomainEvent(formularioOriginalAux, domainEvent);
                formularioOriginalAux = (FormularioResponseGenerico) resultado.clone();
                formularioResponseGenericoList2.add((FormularioResponseGenerico) formularioOriginalAux.clone());
            }

            formularioResponseGenericoList2.add(formularioOriginal);
            FormulariosResponse formulariosResponse = new FormulariosResponse(formularioResponseGenericoList2.stream().sorted(Comparator.comparing(FormularioResponseGenerico::getFechaUltimaModificacion).reversed()).collect(Collectors.toList()));
            return formulariosResponse;
        } catch (QueryHandlerExecutionError | QueryNotRegisteredError | CloneNotSupportedException queryHandlerExecutionError) {
            queryHandlerExecutionError.printStackTrace();
        }

        return null;
    }

    private DomainEvent getCompraResponse(AnalyticsDomainEventResponse pResponse) {

        Class<? extends DomainEvent> formularioModifiacionDomainEvent = eventsInformation.forName(pResponse.name());
        DomainEvent result = null;
        try {
            result = (formularioModifiacionDomainEvent.getDeclaredConstructor().newInstance()).fromPrimitives(pResponse.aggregateId(), Utils.jsonDecode(pResponse.body()), pResponse.name(), Utils.localDateTimeToString(pResponse.occurredOn()));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private FormularioResponseGenerico getCopyFormualarioDomainEvent(FormularioResponseGenerico formularioResponseGenerico, DomainEvent domainEvent) {
        copyProperties(domainEvent, formularioResponseGenerico);
        return formularioResponseGenerico;
    }
}
