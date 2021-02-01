package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.habilitar_rectificacion_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;

public interface ICompraCancelarDeclaracionCambiarIdLibro {
	 void cancelarDeclaracion(CompraLibroId libroId,String pIdLibroRectificado);
}
