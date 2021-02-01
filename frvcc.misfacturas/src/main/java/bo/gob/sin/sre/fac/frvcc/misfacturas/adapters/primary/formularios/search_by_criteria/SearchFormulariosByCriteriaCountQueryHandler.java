package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.search_by_criteria;


import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.search_by_criteria.FormulariosByCriteriaSearcher;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public class SearchFormulariosByCriteriaCountQueryHandler 
implements QueryHandler<SearchFormulariosByCriteriaCountQuery, TotalRegistrosResponse> {
	private final FormulariosByCriteriaSearcher service;

	public SearchFormulariosByCriteriaCountQueryHandler(FormulariosByCriteriaSearcher service) {
		this.service = service;
	}

	@Override
	public TotalRegistrosResponse handle(SearchFormulariosByCriteriaCountQuery query) {
		Filters filters = Filters.fromValues(query.filters());
		return service.countResultSearch(filters);
	}
}
