package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.desmarcar_compras;

import java.util.*;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EnumMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasListaIds;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.desmarcar_compras.IFormularioDesmarcarCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class FormularioDesmarcarComprasServiceImpl implements IFormularioDesmarcarCompras {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioDesmarcarComprasServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final FormularioValidador validador;

	public FormularioDesmarcarComprasServiceImpl(FormularioRepository pRepository, EventBus pEventBus,
			FormularioValidador pValidador, QueryBus pQueryBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.validador = pValidador;
		this.queryBus = pQueryBus;
	}

	public void decrementarImporte(FormularioId pFormularioId,
			FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, List<String> pListaIdsCompras) {
		Formulario vFormulario = repository.search(pFormularioId).orElseThrow(
				() -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));
		ComprasResponse vComprasResponse = null;

		ValidationResponse vResultadoValidacion = validador.validarFormulario(
				new HashMap<>() {{
					put("id", pFormularioId.value() != null ? pFormularioId.value() : "");
				}});
		if (vResultadoValidacion.hasErrors()) {
			throw new FormularioListaErrores(pFormularioId, vResultadoValidacion);
		}
		List<String> vFiltroComprasSeleccionadas = pListaIdsCompras.stream().filter(compra -> vFormulario.compras()
				.stream()
				.anyMatch(compraId -> compraId.value().equals(compra))).collect(Collectors.toList());
		  ComprasResponse vComprasAnteriores = null;
		try {
			vComprasResponse = queryBus.ask(new SearchComprasListaIds(vFiltroComprasSeleccionadas));

		} catch (QueryHandlerExecutionError | QueryNotRegisteredError error){
			error.printStackTrace();
		}

		vFormulario.desmarcarImporte(
				vComprasResponse
						.getComprasResponse()
						.stream()
						.filter(c -> Long.parseLong(c.getNumeroDocumentoCliente())==vFormulario.nitCi().value() &&
						c.getEstadoUsoId().equals(EstadoUsoId.ASOCIADO.value())).collect(Collectors.toList()),
				pUsuarioUltimaModificacion
		);
  	try {
			repository.save(vFormulario);
		} catch (Exception excepcion) {
			throw new FormularioListaErrores(pFormularioId, crearValidacionException());
		}
		eventBus.publish(vFormulario.pullDomainEvents());
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Collections.singletonList(EnumFacFrvccMensajesShared.ERROR_DECLARAR_FORMULARIO.getId()));
			}
		});
	}

	private Boolean filtroPorTipoFormulario(String tipoFormularioId, String marcaEspecialId, Integer tipoSectorId) {
		if (tipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_111.value())) {
			if ( marcaEspecialId.equals(EnumMarcaEspecialId.SINMARCA.value()) && tipoSectorId == null){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private List<HashMap<String, String>> filtrosTotalCompras(String idFormulario) {


		return   Arrays.asList(
				new HashMap<>(){{
					put("field", "formularioId");
					put("operator", "=");
					put("value", idFormulario);
				}},
				new HashMap<>(){{
					put("field", "estadoUsoId");
					put("operator", "=");
					put("value", EstadoUsoId.ASOCIADO.value());
				}},
				new HashMap<>(){{
					put("field", "estadoId");
					put("operator", "=");
					put("value", EnumEstadoId.ACTIVO.value());
				}}
		) ;
	}

}

