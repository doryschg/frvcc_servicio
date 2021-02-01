package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.domain_events;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.search_by_criteria.SearchAnalyticsDomainEventByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
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
import java.util.stream.Collectors;


@RestController
@RequestMapping("/rest/misfacturas")
public class DomainEventsGetController extends ApiController {

    public DomainEventsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/domain_events")
    public ResponseEntity<List<HashMap<String, Serializable>>> index(@RequestParam HashMap<String, Serializable> params) throws QueryNotRegisteredError, QueryHandlerExecutionError {
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

        SearchAnalyticsDomainEventByCriteriaQuery query = new SearchAnalyticsDomainEventByCriteriaQuery(parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")), Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable(limit != null ? Integer.valueOf(limit) : null),
                Optional.ofNullable((offset != null ? Integer.valueOf(offset) : null)));

        AnalyticsDomainEventsResponse analyticsDomainEventsResponse = ask(query);


        return ResponseEntity.ok(
                analyticsDomainEventsResponse.response().stream().map(response -> new HashMap<String, Serializable>() {{
                    put("id", response.id());
                    put("aggregateId", response.aggregateId());
                    put("name", response.name());
                    put("body", response.body());
                    put("occurredOn", response.occurredOn());

                }}).collect(Collectors.toList())
        );
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
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

