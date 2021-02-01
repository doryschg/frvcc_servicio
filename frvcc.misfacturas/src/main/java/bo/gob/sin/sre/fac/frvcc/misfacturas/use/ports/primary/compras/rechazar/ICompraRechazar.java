package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.rechazar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface ICompraRechazar {
	void rechazar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
