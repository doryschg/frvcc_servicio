package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.habilitar_rectificacion_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;

public interface INotaCancelarDeclaracionCambiarIdLibro {
	 void cancelarDeclaracion(CompraNotaLibroId libroId,String pIdLibroRectificado);
}
