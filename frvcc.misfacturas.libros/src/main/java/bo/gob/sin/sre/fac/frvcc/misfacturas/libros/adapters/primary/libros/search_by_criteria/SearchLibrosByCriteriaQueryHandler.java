package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.search_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibrosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.search_by_criteria.LibrosByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.search_by_criteria.FormulariosByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public final class SearchLibrosByCriteriaQueryHandler implements QueryHandler<SearchLibrosByCriteriaQuery, LibrosResponse> {
    private final LibrosByCriteriaSearcher service;

    public SearchLibrosByCriteriaQueryHandler(LibrosByCriteriaSearcher service) {
        this.service = service;
    }



    @Override
    public LibrosResponse handle(SearchLibrosByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order   = Order.fromValues(query.orderBy(), query.orderType());

        return service.search(filters, order, query.limit(), query.offset());
    }
}
