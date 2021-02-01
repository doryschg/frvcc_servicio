package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.archivo;

import java.util.HashMap;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.Archivo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.archivo.IArchivoRepository;

public final class InMemoryArchivoRepository implements IArchivoRepository {
	private HashMap<String, Archivo> archivo = new HashMap<>();

	@Override
	public void guardar(Archivo pArchivo) {
		archivo.put(pArchivo.id().value(), pArchivo);
	}

	@Override
	public Optional<Archivo> findById(ArchivoId pId) {
		// TODO Auto-generated method stub
		return null;
	}
}
