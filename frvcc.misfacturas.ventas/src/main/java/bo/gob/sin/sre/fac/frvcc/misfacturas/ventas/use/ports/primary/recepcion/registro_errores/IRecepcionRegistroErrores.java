package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.registro_errores;



import org.json.JSONObject;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionUsuarioUltimaModificacion;

public interface IRecepcionRegistroErrores {
	void registrar(RecepcionId pId, RecepcionUsuarioUltimaModificacion pUsuarioUltimaModificacion, JSONObject pErrores);
}
