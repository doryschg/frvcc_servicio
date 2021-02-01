package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.archivo;

import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.Archivo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;

public interface IArchivoRepository {
	void guardar(Archivo pArchivo);
	
	Optional<Archivo> findById(ArchivoId pId);
}
