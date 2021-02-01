package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.controller.libros;


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

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibrosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.search_by_criteria.SearchLibrosByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
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
public class LibrosGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public LibrosGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/libros")
    public ResponseEntity<LibrosResponse> index(@RequestParam HashMap<String, Serializable> params) throws QueryNotRegisteredError, QueryHandlerExecutionError {
        String limit = null;
        String offset = null;
        if (params.get("filters[limit][limit]") != null)
            limit = params.get("filters[limit][limit]").toString();
        if (params.get("filters[offset][offset]") != null)
            offset = params.get("filters[offset][offset]").toString();

        if (params.get("limit") != null)
            limit = params.get("limit").toString();
        if (params.get("offset") != null)
            offset = params.get("offset").toString();

        SearchLibrosByCriteriaQuery searchLibrosByCriteriaQuery = new SearchLibrosByCriteriaQuery(parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")), Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable(limit != null ? Integer.valueOf(limit) : null),
                Optional.ofNullable((offset != null ? Integer.valueOf(offset) : null)));

        LibrosResponse vLibrosResponse = ask(searchLibrosByCriteriaQuery);

         if(!vLibrosResponse.getLibrosReponse().isEmpty()) {
        	vLibrosResponse.setOk(Boolean.TRUE);
        	//vFormulariosResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.EDITADO_CORRECTO));//TODO crear mensaje de exito
		}else {
			vLibrosResponse.setOk(Boolean.TRUE);
			vLibrosResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.RESULTADO_BUSQUEDA_VACIA));
		}  
 		return ResponseEntity.ok(vLibrosResponse);

    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(FormularioListaErrores.class,HttpStatus.OK);
        }};  
    }


    private List<HashMap<String, String>> parseFilters(HashMap<String, Serializable> params) {
        int maxParams = params.size();

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (int possibleFilterKey = 0; possibleFilterKey < maxParams; possibleFilterKey++) {
            if (params.containsKey(String.format("filters[%s][field]", possibleFilterKey))) {
                int key = possibleFilterKey;

                filters.add(new HashMap<String, String>() {{
                    put("field", (String) params.get(String.format("filters[%s][field]", key)));
                    put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
                    put("value", (String) params.get(String.format("filters[%s][value]", key)));
                }});
            }
        }

        return filters;
    }
}

