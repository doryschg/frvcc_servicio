package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.declarar;

import java.math.BigDecimal;
import java.util.*;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.criterio_busqueda.SearchConsolidacionByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.IRecepionFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.RespuestaConciliacionDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.declarar.IFormularioDeclar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.GeneraNumeroOrdenRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class FormularioDeclararServiceImpl implements IFormularioDeclar {
    private static final Logger LOG = LoggerFactory.getLogger(FormularioDeclararServiceImpl.class);
    private final FormularioRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final GeneraNumeroOrdenRepository generaNumeroOrden;
    private final FormularioValidador validador;
    private final IRecepionFormulario recepionFormulario;

    public FormularioDeclararServiceImpl(FormularioRepository pRepository, EventBus pEventBus, QueryBus queryBus,
                                         GeneraNumeroOrdenRepository pGeneraNumeroOrden, FormularioValidador pValidador, IRecepionFormulario recepionFormulario) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.generaNumeroOrden = pGeneraNumeroOrden;
        this.validador = pValidador;
        this.queryBus = queryBus;
        this.recepionFormulario = recepionFormulario;
    }

    @Override
    public void declarar(FormularioId pFormularioId, Integer pCodAdmin,
                         FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        Formulario vFormulario = repository.search(pFormularioId).orElseThrow(
                () -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));
        if (vFormulario.compras().size() == 0) {
            throw new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoTieneCompras());
        }



		if(!vFormulario.tipoFormularioId().value().equals(EnumTipoFormularioId.FORMULARIO_111.value())){
            ValidationResponse vResultadoValidacion = validador.validarFormulario(
                    new HashMap<>() {{
                        put("direccionEmpleador", vFormulario.direccionEmpleador()!= null ? vFormulario.tipoFormularioId().value()+"|"+vFormulario.tipoUsoId().value()+"|"+vFormulario.direccionEmpleador().value() : vFormulario.tipoFormularioId().value()+"|"+vFormulario.tipoUsoId().value()+"|");

                    }});
            if (vResultadoValidacion.hasErrors()) {
                throw new FormularioListaErrores(vFormulario.id(), vResultadoValidacion);
            }
            List<HashMap<String, String>> filters = new ArrayList<>();

            filters.add(new HashMap<>() {{
                put("field", "nitAgente");
                put("operator", "=");
                put("value", vFormulario.nitEmpleador().value().toString());
            }});
            filters.add(new HashMap<>() {{
                put("field", "gestion");
                put("operator", "=");
                put("value", vFormulario.anioPeriodo().value().toString());
            }});
            filters.add(new HashMap<>() {{
                put("field", "periodo");
                put("operator", "=");
                put("value", vFormulario.mesPeriodo().value().toString());
            }});
            filters.add(new HashMap<>() {{
                put("field", "estadoConsolidadoId");
                put("operator", "=");
                put("value", EnumEstadoId.ACTIVO.value());
            }});
            filters.add(new HashMap<>() {{
                put("field", "estadoId");
                put("operator", "=");
                put("value", EnumEstadoId.ACTIVO.value());
            }});
            SearchConsolidacionByCriteriaQuery searchConsolidacionByCriteriaQuery = new SearchConsolidacionByCriteriaQuery(filters, Optional.ofNullable(null), Optional.ofNullable(null), Optional.ofNullable(null), Optional.ofNullable(null));
            ConsolidacionResponse vConsolidacionesResponse = new ConsolidacionResponse(new ArrayList<>());
            try {
                vConsolidacionesResponse = queryBus.ask(searchConsolidacionByCriteriaQuery);
            } catch (QueryHandlerExecutionError | QueryNotRegisteredError queryHandlerExecutionError) {

                queryHandlerExecutionError.printStackTrace();
            }

            if (vConsolidacionesResponse.getConsolidacionesResponse().size() > 0) {
                throw new FormularioListaErrores(pFormularioId, validador.crearValidacionconsolidacionRealizadaAgente());
            }

        } else {
            ResultadoGenericoDto<RespuestaConciliacionDto> respuesta = recepionFormulario.recepcionFormulario(vFormulario.id().value(),
                    vFormulario.codigoDependiente().value(), vFormulario.mesPeriodo().value(),
                    vFormulario.anioPeriodo().value(),
                    vFormulario.determinacionPago().value(), vFormulario.cantidadCompras().value(),
                    vFormulario.totalCompras().value());
          if(!respuesta.isOk()){
              throw new FormularioListaErrores(pFormularioId, validador.crearValidacionConciliacionExistentye());
          }
        }




        vFormulario.declararFormulario(new FormularioNumeroOrden(generaNumeroOrden.obtenerNumeroOrden(pCodAdmin)),
                pUsuarioUltimaModificacion);

        try {
            repository.save(vFormulario);
        } catch (Exception excepcion) {
            LOG.error(excepcion.getCause().toString(), excepcion);
            throw new FormularioListaErrores(pFormularioId, crearValidacionException());
        }
        eventBus.publish(vFormulario.pullDomainEvents());
    }

    private ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DECLARAR_FORMULARIO.getId()));
            }
        });
    }

}
