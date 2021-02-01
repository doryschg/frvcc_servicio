package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.marcar_ncd;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface ICompraMarcarNCD {
	void marcarNCD(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion);

}
