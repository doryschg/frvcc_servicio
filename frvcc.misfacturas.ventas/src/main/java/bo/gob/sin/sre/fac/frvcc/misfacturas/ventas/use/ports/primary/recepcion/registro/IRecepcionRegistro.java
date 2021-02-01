package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionIfc;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionNit;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionTipoDocumentoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionUsuarioRegistro;

public interface IRecepcionRegistro {
	void registrar(RecepcionId pId, RecepcionTipoRecepcionId pTipoRecepcionId,
			RecepcionTipoDocumentoId pTipoDocumentoId, RecepcionIfc pIfc, RecepcionNit pNit,
			RecepcionUsuarioRegistro pUsuarioRegistro);
}
