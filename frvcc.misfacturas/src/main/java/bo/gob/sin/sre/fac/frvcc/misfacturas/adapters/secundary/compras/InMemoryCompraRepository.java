package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraContribuyente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public final class InMemoryCompraRepository implements CompraRepository {
    private HashMap<String, Compra> beneficiarioFacturas = new HashMap<>();

    @Override
    public void guardar(Compra pCompra) {
        beneficiarioFacturas.put(pCompra.id().value(), pCompra);
    }

    @Override
    public void persist(Compra pCompra) {

    }

    @Override
    public void guardarTodo(List<Compra> pCompras) {

    }

    public Optional<Compra> findById(CompraId id) {
        return Optional.ofNullable(beneficiarioFacturas.get(id.value()));
    }

    @Override
    public Optional<Compra> BuscarCompraExistente(Compra vCompra) {
        return Optional.empty();
    }
    
    @Override
    public Optional<Compra> BuscarCompraEstandarExistente(Compra vCompra) {
        return Optional.empty();
    }
    
    @Override
    public Pagina<Compra> matching(Criteria criteria) {
        return null;
    }

	@Override
	public Long countByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return 0L;
	}

    @Override
    public List<Compra> ListaDeComprasPorIds(List<String> ids) {
        return null;
    }

    @Override
    public HashMap<Long, CompraContribuyente> proveedoresRecurrentes() {
        return null;
    }
}
