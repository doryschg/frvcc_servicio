package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.search_by_criteria;

import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.search_by_criteria.ComprasNotasByCriteriaSearcherService;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public class SearchComprasNotaByCriteriaCountQueryHandler
		implements QueryHandler<SearchComprasNotaByCriteriaCountQuery, TotalRegistrosResponse> {
	private final ComprasNotasByCriteriaSearcherService service;

	public SearchComprasNotaByCriteriaCountQueryHandler(ComprasNotasByCriteriaSearcherService service) {
		this.service = service;
	}

	@Override
	public TotalRegistrosResponse handle(SearchComprasNotaByCriteriaCountQuery query) {
		Filters filters = Filters.fromValues(query.filters());
		return service.countResultSearch(filters);
	}
}
