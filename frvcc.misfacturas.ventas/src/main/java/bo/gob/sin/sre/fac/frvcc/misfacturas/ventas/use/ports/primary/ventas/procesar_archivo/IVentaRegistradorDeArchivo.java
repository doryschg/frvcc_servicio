package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.procesar_archivo;

import java.io.IOException;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface IVentaRegistradorDeArchivo {
	void registrarArchivo(ArchivoId pArchivoId, ArchivoTipoRecepcionId pTipoRecepcionId)
			throws QueryNotRegisteredError, QueryHandlerExecutionError, IOException;
}
