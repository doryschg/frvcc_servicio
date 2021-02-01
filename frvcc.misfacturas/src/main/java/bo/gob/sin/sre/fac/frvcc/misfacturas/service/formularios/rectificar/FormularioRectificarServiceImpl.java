package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.rectificar;

import java.util.*;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.criterio_busqueda.SearchConsolidacionByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.enumeradores.mensajeria.EnumEstadoRegistro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.rectificar.IFormularioRectificar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.GeneraNumeroOrdenRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class FormularioRectificarServiceImpl implements IFormularioRectificar {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioRectificarServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final GeneraNumeroOrdenRepository generaNumeroOrden;
	private final FormularioValidador validador;

	public FormularioRectificarServiceImpl(FormularioRepository pRepository, EventBus pEventBus,QueryBus queryBus,
			GeneraNumeroOrdenRepository pGeneraNumeroOrden, FormularioValidador pValidador) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.generaNumeroOrden = pGeneraNumeroOrden;
		this.validador = pValidador;
		this.queryBus=queryBus;
	}

	public void rectificar(FormularioId pFormularioId, Integer pCodAdmin,
			FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {

			Optional<Formulario> vFormulario = repository.search(pFormularioId);
		if (vFormulario.isPresent()) {

			if(vFormulario.get().tipoUsoId().value().equals(EnumTipoUsoId.TIPO_DEPENDIENTE.value()))
			{
				if(vFormulario.get().direccionEmpleador()==null || vFormulario.get().direccionEmpleador().value().equals(" ") || vFormulario.get().direccionEmpleador().value().equals("NE") )
				{
					throw new FormularioListaErrores(pFormularioId, validador.crearValidacionconsolidacionDireccionEmpleadorRequerida());
				}

				List<HashMap<String, String>> filters = new ArrayList<>();

				filters.add(new HashMap<>(){{put("field", "nitAgente"); put("operator", "="); put("value", vFormulario.get().nitEmpleador().value().toString());   }});
				filters.add(new HashMap<>(){{put("field", "gestion");  put("operator", "="); put("value", vFormulario.get().anioPeriodo().value().toString());      }});
				filters.add(new HashMap<>(){{put("field", "periodo");  put("operator", "=");  put("value", vFormulario.get().mesPeriodo().value().toString());     }});
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


			vFormulario.get().rectificarFormulario(
					new FormularioNumeroOrden(generaNumeroOrden.obtenerNumeroOrden(pCodAdmin)),
					pUsuarioUltimaModificacion);





			try {
				repository.save(vFormulario.get());

			} catch (Exception excepcion) {
				LOG.error(excepcion.getCause().toString(), excepcion);
				throw new FormularioListaErrores(pFormularioId, crearValidacionException());

			}
			eventBus.publish(vFormulario.get().pullDomainEvents());
		} else {
			throw new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente());
		}
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_RECTIFICACION_FORMULARIO.getId()));
			}
		});
	}

}
