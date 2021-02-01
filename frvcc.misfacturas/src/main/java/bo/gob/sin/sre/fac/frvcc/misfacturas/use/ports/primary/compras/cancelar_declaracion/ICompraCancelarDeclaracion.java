package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.cancelar_declaracion;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface ICompraCancelarDeclaracion {
	void cancelarDeclaracion(CompraFormularioId pFormularioId, CompraUsuarioUltimaModificacion compraUsuarioUltimaModificacion);
}
