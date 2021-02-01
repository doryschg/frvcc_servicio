package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.serach_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.search_by_criteria.SearchFormulariosByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalesUsuariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.search_by_criteria.FormulariosByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.search_by_criteria.SucursalUsuarioByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public final class SearchSucursalesUsuariosByCriteriaQueryHandler implements QueryHandler<SearchSucursalesUsuariosByCriteriaQuery, SucursalesUsuariosResponse> {
    private final SucursalUsuarioByCriteriaSearcher service;

    public SearchSucursalesUsuariosByCriteriaQueryHandler(SucursalUsuarioByCriteriaSearcher service) {
        this.service = service;
    }
    @Override
    public SucursalesUsuariosResponse handle(SearchSucursalesUsuariosByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());
        return service.search(filters, order, query.limit(), query.offset());
    }
}
