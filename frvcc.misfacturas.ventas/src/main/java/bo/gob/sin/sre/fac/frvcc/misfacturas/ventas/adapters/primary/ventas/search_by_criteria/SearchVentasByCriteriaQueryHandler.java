package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.search_by_criteria;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.VentasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.search_by_criteria.VentasByCriteriaSearcherImpl;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public class SearchVentasByCriteriaQueryHandler implements QueryHandler<SearchVentasByCriteriaQuery, VentasResponse> {
	private final VentasByCriteriaSearcherImpl service;

	public SearchVentasByCriteriaQueryHandler(VentasByCriteriaSearcherImpl service) {
		this.service = service;
	}

	@Override
	public VentasResponse handle(SearchVentasByCriteriaQuery query) {
		Filters filters = Filters.fromValues(query.filters());
		Order order = Order.fromValues(query.orderBy(), query.orderType());

		return service.search(filters, order, query.limit(), query.offset());
	}
}
