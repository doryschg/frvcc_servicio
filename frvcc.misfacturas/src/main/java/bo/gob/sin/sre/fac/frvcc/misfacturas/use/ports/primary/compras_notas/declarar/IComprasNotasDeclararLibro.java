package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;

public interface IComprasNotasDeclararLibro {
	void declarar(CompraNotaLibroId pLibroId, CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion);

}
