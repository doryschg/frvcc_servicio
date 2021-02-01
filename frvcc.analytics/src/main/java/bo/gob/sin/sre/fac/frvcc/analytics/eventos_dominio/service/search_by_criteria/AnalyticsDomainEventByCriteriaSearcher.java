package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.service.search_by_criteria;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.secundary.DomainEventsRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class AnalyticsDomainEventByCriteriaSearcher {
    private final DomainEventsRepository repository;

    public AnalyticsDomainEventByCriteriaSearcher(DomainEventsRepository repository) {
        this.repository = repository;
    }

    public AnalyticsDomainEventsResponse search(Filters filters, Order order, Optional<Integer> limit, Optional<Integer> offset) {
        Criteria criteria = new Criteria(filters,order, limit, offset);
        return new AnalyticsDomainEventsResponse(repository.matching(criteria).stream().map(AnalyticsDomainEventResponse::fromAnalyticsDomainEvent).collect(Collectors.toList()));
    }
}
