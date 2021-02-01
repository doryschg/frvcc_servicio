package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.buscar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.RecepcionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;

public interface IRecepcionBuscador {
	RecepcionResponse buscar(RecepcionId id);
}
