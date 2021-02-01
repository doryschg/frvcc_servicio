package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas;

import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public interface CompraNotaRepository {
	void guardar(CompraNota pCompra);
    void guardarTodo(List<CompraNota> pComprasNotas);

	 Optional<CompraNota> findById(CompraNotaId id);
	 Optional<CompraNota> BuscarCompraNotaExistente(CompraNota vCompraNota);
	 Pagina<CompraNota> matching(Criteria criteria);
	    Long countByCriteria(Criteria criteria);
}
