package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.eliminar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;

public interface ICompraNotaEliminar {
	void eliminar(CompraNotaId pId, CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
