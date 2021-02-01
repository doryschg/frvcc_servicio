package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraContribuyente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public interface CompraRepository {
    void guardar(Compra pCompra);
    void persist(Compra pCompra);
    void guardarTodo(List<Compra> pCompras);
    Optional<Compra> findById(CompraId id);
    Optional<Compra> BuscarCompraExistente(Compra vCompra);
    Optional<Compra> BuscarCompraEstandarExistente(Compra vCompra);
    Pagina<Compra> matching(Criteria criteria);
    Long countByCriteria(Criteria criteria);
    List<Compra> ListaDeComprasPorIds(List<String> ids);
    HashMap<Long, CompraContribuyente> proveedoresRecurrentes();
}
