package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.recepcion.actualizar_id_archivo;

import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.actualizar_id_archivo.IRecepcionActualizadorIdArchivoRegistrado;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.recepcion.IRecepcionRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class RecepcionActualizadorIdArchivoRegistradoService
		implements IRecepcionActualizadorIdArchivoRegistrado {
	private final IRecepcionRepository repository;

	public RecepcionActualizadorIdArchivoRegistradoService(IRecepcionRepository pRepository) {
		this.repository = pRepository;
	}

	@Override
	public void actualizarIdArchivo(RecepcionId pId, RecepcionArchivoId pArchivoId) {
		Optional<Recepcion> recepcion = repository.findById(pId);
		if (recepcion.isPresent()) {
			recepcion.get().asignarArchivo(pArchivoId);
			repository.guardar(recepcion.get());
		}
	}
}
