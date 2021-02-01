package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.search_by_criteria;

import java.util.Optional;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.VentaResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.VentasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores.VentaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;

@Service
public class VentasByCriteriaSearcherImpl {
	private final IVentaRepository repository;
	private final VentaValidador validador;

	public VentasByCriteriaSearcherImpl(IVentaRepository repository, VentaValidador validador) {
		this.repository = repository;
		this.validador = validador;
	}

	public VentasResponse search(Filters filters, Order order, Optional<Integer> limit, Optional<Integer> offset) {
		Filter filter = Filter.create("estadoId", "=", ConstEstado.ESTADO_ACTIVO);
		filters.filters().add(filter);
		Criteria criteria = new Criteria(filters, order, limit, offset);

		Pagina<Venta> pagina = repository.matching(criteria);

		return new VentasResponse(
				pagina.getContent().stream().map(VentaResponseGenerico::fromAggregate).collect(Collectors.toList()),
				pagina.getTotalPaginas(), pagina.getTotalElementos());

	}

	public TotalRegistrosResponse countResultSearch(Filters filters) {
		Criteria criteria = new Criteria(filters, null);
		return new TotalRegistrosResponse(repository.countByCriteria(criteria));

	}
}
