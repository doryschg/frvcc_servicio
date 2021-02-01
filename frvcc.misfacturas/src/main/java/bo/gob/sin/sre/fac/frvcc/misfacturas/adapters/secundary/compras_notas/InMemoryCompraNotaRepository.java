package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras_notas;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public final class InMemoryCompraNotaRepository implements CompraNotaRepository {
	private HashMap<String, CompraNota> beneficiarioFacturas = new HashMap<>();

	@Override
	public void guardar(CompraNota pCompraNota) {
		beneficiarioFacturas.put(pCompraNota.id().value(), pCompraNota);
	}
	
	 @Override
	    public void guardarTodo(List<CompraNota> pComprasNotas) {

	    }
	
	 public Optional<CompraNota> findById(CompraNotaId id) {
	        return Optional.ofNullable(beneficiarioFacturas.get(id.value()));
	    }
	
	 @Override
	    public Optional<CompraNota> BuscarCompraNotaExistente(CompraNota vCompraNota) {
	        return Optional.empty();
	    }
	 @Override
	    public Pagina<CompraNota> matching(Criteria criteria) {
	        return null;
	    }

		@Override
		public Long countByCriteria(Criteria criteria) {
			return 0L;
		}

}
