package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.ventas;

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

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.VentasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.search_by_criteria.SearchVentasByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
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
public class VentasGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

	public VentasGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping(value = "/ventas")
	public ResponseEntity<VentasResponse> index(@RequestParam HashMap<String, Serializable> params)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {

		String limit = null;
		String offset = null;
		String order_by = null;
		String order = null;
		if (params.get("filters[limit][limit]") != null)
			limit = params.get("filters[limit][limit]").toString();
		if (params.get("filters[offset][offset]") != null)
			offset = params.get("filters[offset][offset]").toString();

		limit = params.get("limit") != null ? params.get("limit").toString() : "20";
		offset = params.get("offset") != null ? params.get("offset").toString() : "0";

		if (params.get("order_by") != null)
			order_by = params.get("order_by").toString();
		if (params.get("order") != null)
			order = params.get("order").toString();

		SearchVentasByCriteriaQuery searchVentasByCriteriaQuery = new SearchVentasByCriteriaQuery(
				parseFilters(params), Optional.ofNullable(order_by != null ? order_by : null),
				Optional.ofNullable(order != null ? order : null),
				Optional.ofNullable(limit != null ? Integer.valueOf(limit) : 1),
				Optional.ofNullable((offset != null ? Integer.valueOf(offset) : null)));
		VentasResponse VentasResponse = ask(searchVentasByCriteriaQuery);

		if (!VentasResponse.getVentasResponse().isEmpty()) {
			VentasResponse.setOk(Boolean.TRUE);
		} else {
			VentasResponse.setOk(Boolean.FALSE);
			VentasResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,
					EnumFacFrvccMensajesShared.RESULTADO_BUSQUEDA_VACIA));
		}
		return ResponseEntity.ok(VentasResponse);

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

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<>() {
			{
				put(VentaListaErrores.class, HttpStatus.OK);
			}
		};
	}

}
