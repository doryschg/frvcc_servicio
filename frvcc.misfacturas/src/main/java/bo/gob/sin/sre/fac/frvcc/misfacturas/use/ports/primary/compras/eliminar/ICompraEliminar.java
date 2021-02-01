package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.eliminar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface ICompraEliminar {

	void eliminar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
