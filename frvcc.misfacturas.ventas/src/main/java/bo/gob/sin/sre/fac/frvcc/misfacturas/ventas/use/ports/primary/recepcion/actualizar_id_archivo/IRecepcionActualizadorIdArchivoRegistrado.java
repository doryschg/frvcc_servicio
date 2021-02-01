package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.actualizar_id_archivo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;

public interface IRecepcionActualizadorIdArchivoRegistrado {
	void actualizarIdArchivo(RecepcionId pId, RecepcionArchivoId pArchivoId);
}
