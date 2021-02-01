package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.rechazar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.criterio_busqueda.SearchConsolidacionByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import bo.gob.sin.str.enumeradores.mensajeria.EnumEstadoRegistro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.rechazar.RechazarCompraCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.rechazar.IFormularioRechazo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

//TODO REALIZAR REFACTORIZACIÓN EVENTO DE DOMINIO
@Service
public class FormularioRechazoServiceImpl implements IFormularioRechazo {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioRechazoServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final CommandBus commandBus;
	private final FormularioValidador validador;

	public FormularioRechazoServiceImpl(FormularioRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,
			CommandBus pCommandBus, FormularioValidador pValidador) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.commandBus = pCommandBus;
		this.validador = pValidador;
	}

	public void rechazar(FormularioId pFormularioId,
						 FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion,
						 FormularioNombreReceptor pNombreReceptor,
							FormularioLoginUsuarioReceptor pLoginUsuarioReceptor)
			throws CommandNotRegisteredError, CommandHandlerExecutionError {
		ComprasResponse vComprasResponse = null;
		try {
			List<HashMap<String, String>> vFilters = new ArrayList<>();
			HashMap<String, String> hp = new HashMap<>();
			hp.put("field", "formularioId");
			hp.put("operator", "=");
			hp.put("value", pFormularioId.value());
			vFilters.add(hp);
			vComprasResponse = queryBus.ask(new SearchComprasByCriteriaQuery(vFilters,
					Optional.ofNullable((String) hp.get("order_by")), Optional.ofNullable((String) hp.get("order")),
					Optional.ofNullable(hp.get("limit") != null ? Integer.valueOf(2) : null),
					Optional.ofNullable((hp.get("ofset") != null ? Integer.valueOf(2) : null))));

			for (CompraResponseGenerico compra : vComprasResponse.getComprasResponse()) {
				commandBus.dispatch(new RechazarCompraCommand(
						compra.id(),
						pUsuarioUltimaModificacion.value()));
			}
		} catch (QueryHandlerExecutionError | QueryNotRegisteredError error) {
			error.printStackTrace();
			LOG.error(error.getCause().toString(), error);
			throw new FormularioListaErrores(pFormularioId, crearValidacionException());

		}
        Formulario vFormulario = repository.search(pFormularioId).orElseThrow(
                () -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));

		if(vFormulario.tipoUsoId().value().equals(EnumTipoUsoId.TIPO_DEPENDIENTE.value()))
		{
			List<HashMap<String, String>> filters = new ArrayList<>();

			filters.add(new HashMap<>(){{put("field", "nitAgente"); put("operator", "="); put("value", vFormulario.nitEmpleador().value().toString());   }});
			filters.add(new HashMap<>(){{put("field", "gestion");  put("operator", "="); put("value", vFormulario.anioPeriodo().value().toString());      }});
			filters.add(new HashMap<>(){{put("field", "periodo");  put("operator", "=");  put("value", vFormulario.mesPeriodo().value().toString());     }});
			filters.add(new HashMap<>(){{put("field", "estadoConsolidadoId");put("operator", "="); put("value", EnumEstadoId.ACTIVO.value());}});
			filters.add(new HashMap<>(){{put("field", "tipoId");put("operator", "="); put("value", "P");}});
			filters.add(new HashMap<>(){{put("field", "estadoId");put("operator", "="); put("value", EnumEstadoId.ACTIVO.value());}});


			SearchConsolidacionByCriteriaQuery searchConsolidacionByCriteriaQuery  = new SearchConsolidacionByCriteriaQuery(filters, Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null));
			ConsolidacionResponse vConsolidacionesResponse  = new ConsolidacionResponse(new ArrayList<>());
			try {
				vConsolidacionesResponse = queryBus.ask(searchConsolidacionByCriteriaQuery);
			} catch (QueryHandlerExecutionError queryHandlerExecutionError) {
				queryHandlerExecutionError.printStackTrace();
			} catch (QueryNotRegisteredError queryNotRegisteredError) {
				queryNotRegisteredError.printStackTrace();
			}

			if(vConsolidacionesResponse.getConsolidacionesResponse().size()>0)
			{
				throw new FormularioListaErrores(pFormularioId, validador.crearValidacionconsolidacionRealizadaAgente());
			}
		}


        vFormulario.RechazarFormulario(pUsuarioUltimaModificacion, pNombreReceptor, pLoginUsuarioReceptor);
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
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REZACHO_FORMULARIO.getId()));
			}
		});
	}
}
