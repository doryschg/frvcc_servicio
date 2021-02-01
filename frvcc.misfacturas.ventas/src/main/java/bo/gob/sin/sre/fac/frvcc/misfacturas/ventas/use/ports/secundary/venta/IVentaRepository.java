package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta;

import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public interface IVentaRepository {
	void guardar(Venta pVenta);

	void guardarTodo(List<Venta> pVentas);

	Optional<Venta> findById(VentaId id);

	Optional<Venta> buscarVentaExistente(Venta pVenta);

	Pagina<Venta> matching(Criteria criteria);

	Long countByCriteria(Criteria criteria);

	List<Venta> listaDeVentasPorIds(List<String> pListaIdsVentas);
}
