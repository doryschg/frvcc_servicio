package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaCountQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
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

@RestController
@RequestMapping("/rest/misfacturas")
public class ComprasGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
	public ComprasGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping(value = "/compras")
	public ResponseEntity<ComprasResponse> index(
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

		SearchComprasByCriteriaQuery searchComprasByCriteriaQuery = new SearchComprasByCriteriaQuery(
				parseFilters(params), Optional.ofNullable(order_by != null ? order_by:null),
				Optional.ofNullable(order != null ? order:null),
				Optional.ofNullable(limit != null ? Integer.valueOf(limit) : 1),
				Optional.ofNullable((offset != null ? Integer.valueOf(offset) : null)));
		ComprasResponse comprasResponse = ask(searchComprasByCriteriaQuery);

		if(!comprasResponse.getComprasResponse().isEmpty()) {
			comprasResponse.setOk(Boolean.TRUE);
			//comprasResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.EDITADO_CORRECTO));//TODO crear mensaje de exito
		}else {
			comprasResponse.setOk(Boolean.FALSE);
			comprasResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.RESULTADO_BUSQUEDA_VACIA));
		}  
 		return ResponseEntity.ok(comprasResponse);

	}

	@GetMapping(value = "/compras/count")
	public ResponseEntity<Long> count(@RequestParam HashMap<String, Serializable> params)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {
		TotalRegistrosResponse comprasResponse = ask(new SearchComprasByCriteriaCountQuery(parseFilters(params)));
		return ResponseEntity.ok(comprasResponse.totalPaginas());

	}

	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
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
