package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.criterio_busqueda;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.search_by_criteria.SearchFormulariosByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.search_by_criteria.FormulariosByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones.IBuscarConsolidacionPorCriteriaService;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public final class SearchConsolidacionByCriteriaQueryHandler implements QueryHandler<SearchConsolidacionByCriteriaQuery, ConsolidacionResponse> {
    private final IBuscarConsolidacionPorCriteriaService service;

    public SearchConsolidacionByCriteriaQueryHandler(IBuscarConsolidacionPorCriteriaService service) {
        this.service = service;
    }


    @Override
    public ConsolidacionResponse handle(SearchConsolidacionByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());

        return service.search(filters, order, query.limit(), query.offset());
    }
}
