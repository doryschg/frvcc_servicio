package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.archivo.buscar;

import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.ArchivoResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.Archivo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.buscar.IArchivoBuscador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.archivo.IArchivoRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class ArchivoBuscadorServiceImpl implements IArchivoBuscador {
	private final IArchivoRepository repository;

	public ArchivoBuscadorServiceImpl(IArchivoRepository repository) {
		this.repository = repository;
	}

	@Override
	public ArchivoResponse buscar(ArchivoId pId) {
		Optional<Archivo> archivo = repository.findById(pId);
		if (archivo.isPresent()) {
			return ArchivoResponse.fromAggregate(archivo.get());
		}
		throw new ArchivoNotExist(pId);
	}
}
