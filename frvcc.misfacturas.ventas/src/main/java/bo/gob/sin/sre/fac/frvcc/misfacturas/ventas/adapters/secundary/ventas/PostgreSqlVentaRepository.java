package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.OrderBy;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.OrderType;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;

@Service
@Transactional("misfacturasVentas-transaction_manager")
public class PostgreSqlVentaRepository extends SpringDataRepository<Venta> implements IVentaRepository {

	public PostgreSqlVentaRepository(@Qualifier("misfacturasVentas-session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, Venta.class);
	}

	@Override
	public void guardar(Venta pVenta) {
		save(pVenta);
	}

	@Override
	public void guardarTodo(List<Venta> pVentas) {
		persisteAll(pVentas);
	}

	@Override
	public Optional<Venta> findById(VentaId id) {
		return byId(id);
	}

	@Override
	public Optional<Venta> buscarVentaExistente(Venta pVenta) {
		String vComplemento = "";

		if (pVenta.complementoDocumentoCliente() != null) {
			if (pVenta.complementoDocumentoCliente().value() != null) {
				vComplemento = pVenta.complementoDocumentoCliente().value();
			}
		}

		Filters filters = new Filters(Arrays.asList(
				Filter.create("numeroDocumentoCliente", "=", pVenta.numeroDocumentoCliente().value()),
				//Filter.create("tipoDocumentoCliente", "=", pVenta.tipoDocumentoCliente().value()),
				vComplemento.strip().length() > 0 ? Filter.create("complementoDocumentoCliente", "=", vComplemento)
						: null,
				Filter.create("nitProveedor", "=", pVenta.nitProveedor().value().toString()),
				Filter.create("codigoAutorizacion", "=", pVenta.codigoAutorizacion().value()),
				Filter.create("numeroFactura", "=", pVenta.numeroFactura().value().toString()),
				Filter.create("estadoId", "=", ConstEstado.ESTADO_ACTIVO)

		).stream().filter(filter -> filter != null).collect(Collectors.toList()));
		Criteria criteria = new Criteria(filters, Order.none(), Optional.of(Integer.valueOf(1)), Optional.empty());
		return this.findAll(criteria).get().findFirst();
	}

	@Override
	public Pagina<Venta> matching(Criteria criteria) {
		Page<Venta> vResult = this.findAll(criteria);
		return new Pagina<>(vResult.getTotalPages(), vResult.getTotalElements(), vResult.getContent());
	}

	@Override
	public Long countByCriteria(Criteria criteria) {
		return byCriteriaCount(criteria);
	}

	@Override
	public List<Venta> listaDeVentasPorIds(List<String> pListaIdsVentas) {
		String vListaInIdsVentas = pListaIdsVentas.stream().collect(Collectors.joining(","));
		Criteria criteria = new Criteria(new Filters(Arrays.asList(Filter.create("id", "IN", vListaInIdsVentas))),
				new Order(new OrderBy("fechaFactura"), OrderType.ASC));

		return this.byCriteria(criteria);
	}
}
