package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface IComprasDeclararLibro {
	void declarar(CompraLibroId pLibroId, CompraUsuarioUltimaModificacion usuarioUltimaModificacion);

}
