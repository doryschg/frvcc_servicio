package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.habilitar_rectificacion;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;

public interface ICompraCancelarDeclaracionCambiarIdFormulario {
	 void cancelarDeclaracion(CompraFormularioId formularioId,String pIdFormularioRectificado);
}
