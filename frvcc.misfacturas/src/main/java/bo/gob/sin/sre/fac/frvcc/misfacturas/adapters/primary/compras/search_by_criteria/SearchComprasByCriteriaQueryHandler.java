package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.search_by_criteria.ComprasByCriteriaSearcherImpl;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public final class SearchComprasByCriteriaQueryHandler implements QueryHandler<SearchComprasByCriteriaQuery, ComprasResponse> {
    private final ComprasByCriteriaSearcherImpl service;

    public SearchComprasByCriteriaQueryHandler(ComprasByCriteriaSearcherImpl service) {
        this.service = service;
    }



    @Override
    public ComprasResponse handle(SearchComprasByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());

        return service.search(filters, order, query.limit(), query.offset());
    }
}
