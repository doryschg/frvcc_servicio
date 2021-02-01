package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.consolidaciones;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaCountQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.criterio_busqueda.SearchConsolidacionByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/misfacturas")
public class ConsolidacionesGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
	public ConsolidacionesGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping(value = "/consolidaciones")
	public ResponseEntity<ConsolidacionResponse> index(
			@RequestParam HashMap<String, Serializable> params)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {

		String limit = null;
		String offset = null;
		String order_by = null;
		String order = null;
		if (params.get("filters[limit][limit]") != null)
			limit = params.get("filters[limit][limit]").toString();
		if (params.get("filters[offset][offset]") != null)
			offset = params.get("filters[offset][offset]").toString();
		
			limit = params.get("limit") != null? params.get("limit").toString() : "20";
			offset = params.get("offset") != null ? params.get("offset").toString() : "0";


		if (params.get("order_by") != null)
			order_by = params.get("order_by").toString();
		if (params.get("order") != null)
			order = params.get("order").toString();

		SearchConsolidacionByCriteriaQuery searchFormulariosByCriteriaQuery = new SearchConsolidacionByCriteriaQuery(parseFilters(params), Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null));

		ConsolidacionResponse consolidacionResponse = ask(searchFormulariosByCriteriaQuery);

		if(!consolidacionResponse.getConsolidacionesResponse().isEmpty()) {
			consolidacionResponse.setOk(Boolean.TRUE);
		}else {
			consolidacionResponse.setOk(Boolean.FALSE);
			consolidacionResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.RESULTADO_BUSQUEDA_VACIA));
		}  
 		return ResponseEntity.ok(consolidacionResponse);

	}

	@GetMapping(value = "/consolidaciones/count")
	public ResponseEntity<Long> count(@RequestParam HashMap<String, Serializable> params)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {
		TotalRegistrosResponse comprasResponse = ask(new SearchComprasByCriteriaCountQuery(parseFilters(params)));
		return ResponseEntity.ok(comprasResponse.totalPaginas());

	}

	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>(){{
            put(ConsolidacionListaErrores.class,HttpStatus.OK);
        }};
    }

	private List<HashMap<String, String>> parseFilters(HashMap<String, Serializable> params) {
		int maxParams = params.size();

		List<HashMap<String, String>> filters = new ArrayList<>();

		for (int possibleFilterKey = 0; possibleFilterKey < maxParams; possibleFilterKey++) {
			if (params.containsKey(String.format("filters[%s][field]", possibleFilterKey))) {
				int key = possibleFilterKey;

				filters.add(new HashMap<String, String>() {
					{
						put("field", (String) params.get(String.format("filters[%s][field]", key)));
						put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
						put("value", (String) params.get(String.format("filters[%s][value]", key)));
					}
				});
			}
		}
		return filters;
	}
}
