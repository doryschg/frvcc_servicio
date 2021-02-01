package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.generar_historial;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.buscar_por_id_agregado.BuscarEventoDominioPorIdQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.generar_historial.IGeneradorHistorialCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventsInformation;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


import java.io.IOException;


import java.lang.reflect.InvocationTargetException;
import java.util.*;

import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.*;

@Service
public final class GeneradorHistorialComprasImpl implements IGeneradorHistorialCompras {
    private final CompraRepository repository;
    private final QueryBus queryBus;
    private final CompraValidador validador;
    private final DomainEventsInformation eventsInformation;

    public GeneradorHistorialComprasImpl(CompraRepository repository, QueryBus queryBus, CompraValidador validador, DomainEventsInformation eventsInformation) {
        this.repository = repository;
        this.queryBus = queryBus;
        this.validador = validador;
        this.eventsInformation = eventsInformation;
    }

    @Override
    public ComprasResponse generadorHistorial(CompraId id) {

        Compra vCompra = repository.findById(id).orElseThrow(() -> new CompraNotExist(id));
        CompraResponseGenerico formularioOriginal = CompraResponseGenerico.fromAggregate(vCompra);
        List<DomainEvent> vCompraResponseGenericoList = new ArrayList<>();
        List<CompraResponseGenerico> vCompraResponseHistorico = new ArrayList<>();


        try {
            AnalyticsDomainEventsResponse responses = queryBus.ask(new BuscarEventoDominioPorIdQuery(id.value()));
            vCompraResponseGenericoList.addAll(responses.response().stream()
                    .map(analyticsDomainEventResponse -> getCompraResponse(analyticsDomainEventResponse))
                    .collect(Collectors.toList()));
            List<DomainEvent> listOrdenada = vCompraResponseGenericoList.stream().sorted(Comparator.comparing(DomainEvent::occurredOn).reversed()).collect(Collectors.toList());
            CompraResponseGenerico compraOriginalAux = null;
            CompraResponseGenerico resultado = null;
            for (DomainEvent domainEvent : listOrdenada) {
                compraOriginalAux = resultado == null ? (CompraResponseGenerico) formularioOriginal.clone() : resultado;
                resultado = getCopyCompraDomainEvent(compraOriginalAux, domainEvent);
                compraOriginalAux = (CompraResponseGenerico) resultado.clone();
                vCompraResponseHistorico.add((CompraResponseGenerico) compraOriginalAux.clone());
            }

            vCompraResponseHistorico.add(formularioOriginal);
            ComprasResponse formulariosResponse = new ComprasResponse(vCompraResponseHistorico.stream().sorted(Comparator.comparing(CompraResponseGenerico::getFechaUltimaModificacion).reversed()).collect(Collectors.toList()));
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

    private CompraResponseGenerico getCopyCompraDomainEvent(CompraResponseGenerico pCompraResponseGenerico, DomainEvent domainEvent) {
        copyProperties(domainEvent, pCompraResponseGenerico);
        return pCompraResponseGenerico;
    }


}

