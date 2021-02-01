package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria;


import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.search_by_criteria.ComprasByCriteriaSearcherImpl;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public class SearchComprasByCriteriaCountQueryHandler
		implements QueryHandler<SearchComprasByCriteriaCountQuery, TotalRegistrosResponse> {
	private final ComprasByCriteriaSearcherImpl service;

	public SearchComprasByCriteriaCountQueryHandler(ComprasByCriteriaSearcherImpl service) {
		this.service = service;
	}

	@Override
	public TotalRegistrosResponse handle(SearchComprasByCriteriaCountQuery query) {
		Filters filters = Filters.fromValues(query.filters());
		return service.countResultSearch(filters);
	}
}
