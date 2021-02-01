package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.search_by_criteria;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.ComprasNotasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.search_by_criteria.ComprasNotasByCriteriaSearcherService;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public final class SearchComprasNotaByCriteriaQueryHandler implements QueryHandler<SearchComprasNotaByCriteriaQuery, ComprasNotasResponse> {
    private final ComprasNotasByCriteriaSearcherService service;

    public SearchComprasNotaByCriteriaQueryHandler(ComprasNotasByCriteriaSearcherService service) {
        this.service = service;
    }

    @Override
    public ComprasNotasResponse handle(SearchComprasNotaByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());

        return service.search(filters, order, query.limit(), query.offset());
    }
}
