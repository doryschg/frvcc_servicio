package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public final class InMemoryVentaRepository implements IVentaRepository {
	private HashMap<String, Venta> venta = new HashMap<>();

	@Override
	public void guardar(Venta pVenta) {
		venta.put(pVenta.id().value(), pVenta);
	}

	@Override
	public void guardarTodo(List<Venta> pVentas) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Venta> findById(VentaId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Venta> buscarVentaExistente(Venta pVenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagina<Venta> matching(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listaDeVentasPorIds(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
}
