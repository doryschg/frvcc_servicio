package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoByte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoIdPadre;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface IArchivoRegistro {
	void registrar(ArchivoId pId, ArchivoOrigenId pOrigenId, ArchivoIdPadre pIdPadre, ArchivoByte pArchivoByte,
			ArchivoUsuarioRegistro usuarioRegistro, ArchivoTipoRecepcionId tipoRecepcionId)
			throws QueryNotRegisteredError, QueryHandlerExecutionError, ValidatorNotExist;
}
