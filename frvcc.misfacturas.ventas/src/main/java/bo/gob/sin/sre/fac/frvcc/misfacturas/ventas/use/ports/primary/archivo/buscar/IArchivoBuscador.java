package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.buscar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.ArchivoResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;

public interface IArchivoBuscador {
	ArchivoResponse buscar(ArchivoId pId);
}
