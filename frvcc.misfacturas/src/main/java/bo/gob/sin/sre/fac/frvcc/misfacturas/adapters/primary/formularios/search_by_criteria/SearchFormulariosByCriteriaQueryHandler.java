package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.search_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.search_by_criteria.FormulariosByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public final class SearchFormulariosByCriteriaQueryHandler implements QueryHandler<SearchFormulariosByCriteriaQuery, FormulariosResponse> {
    private final FormulariosByCriteriaSearcher service;

    public SearchFormulariosByCriteriaQueryHandler(FormulariosByCriteriaSearcher service) {
        this.service = service;
    }



    @Override
    public FormulariosResponse handle(SearchFormulariosByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());

        return service.search(filters, order, query.limit(), query.offset());
    }
}
