package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.search_by_criteria.ComprasByCriteriaSearcherImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public class SearchIdsComprasQueryHandler
		implements QueryHandler<SearchComprasListaIds, ComprasResponse> {
	private final ComprasByCriteriaSearcherImpl service;

	public SearchIdsComprasQueryHandler(ComprasByCriteriaSearcherImpl service) {
		this.service = service;
	}

	@Override
	public ComprasResponse handle(SearchComprasListaIds query) {

		return service.buscarPorListaIds(query.getIdsCompra());
	}
}
