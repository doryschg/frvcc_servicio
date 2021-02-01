package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.search_by_criteria;


import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.service.search_by_criteria.AnalyticsDomainEventByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public final class SearchAnalyticsDomainEventByCriteriaQueryHandler implements QueryHandler<SearchAnalyticsDomainEventByCriteriaQuery, AnalyticsDomainEventsResponse> {
    private final AnalyticsDomainEventByCriteriaSearcher service;

    public SearchAnalyticsDomainEventByCriteriaQueryHandler(AnalyticsDomainEventByCriteriaSearcher service) {
        this.service = service;
    }



    @Override
    public AnalyticsDomainEventsResponse handle(SearchAnalyticsDomainEventByCriteriaQuery query) throws QueryHandlerExecutionError {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());

        return service.search(filters, order, query.limit(), query.offset());
    }
}
