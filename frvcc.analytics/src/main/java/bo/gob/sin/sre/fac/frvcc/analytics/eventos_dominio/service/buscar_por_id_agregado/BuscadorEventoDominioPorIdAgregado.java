package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.service.buscar_por_id_agregado;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.secundary.DomainEventsRepository;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEvent;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEventAggregateId;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class BuscadorEventoDominioPorIdAgregado {
    private final DomainEventsRepository repository;

    public BuscadorEventoDominioPorIdAgregado(DomainEventsRepository repository) {
        this.repository = repository;
    }

  public   AnalyticsDomainEventsResponse buscar(AnalyticsDomainEventAggregateId aggregateId){
        Criteria criteria = new Criteria(new Filters(Arrays.asList(Filter.create("aggregateId","=", aggregateId.value()))), Order.none(), Optional.of(Integer.MAX_VALUE),Optional.of(0));
        return new AnalyticsDomainEventsResponse(repository.matching(criteria).stream().map(AnalyticsDomainEventResponse::fromAnalyticsDomainEvent).collect(Collectors.toList()));
    }
}
