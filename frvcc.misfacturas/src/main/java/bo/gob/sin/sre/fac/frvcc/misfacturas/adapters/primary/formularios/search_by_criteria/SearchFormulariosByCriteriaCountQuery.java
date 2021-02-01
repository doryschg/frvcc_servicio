package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.search_by_criteria;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

import java.util.HashMap;
import java.util.List;

public class SearchFormulariosByCriteriaCountQuery implements Query {
	private final List<HashMap<String, String>> filters;

	public SearchFormulariosByCriteriaCountQuery(List<HashMap<String, String>> filters) {
		this.filters = filters;
	}

	public List<HashMap<String, String>> filters() {
		return filters;
	}
}

