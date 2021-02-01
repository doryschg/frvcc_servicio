package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.recepcion.buscar;

import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.RecepcionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.buscar.IRecepcionBuscador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.recepcion.IRecepcionRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class RecepcionBuscadorServiceImpl implements IRecepcionBuscador {
	private final IRecepcionRepository repository;

	public RecepcionBuscadorServiceImpl(IRecepcionRepository pRepository) {
		this.repository = pRepository;
	}

	@Override
	public RecepcionResponse buscar(RecepcionId pId) {
		Optional<Recepcion> recepcion = repository.findById(pId);
		if (recepcion.isPresent()) {
			return RecepcionResponse.fromAggregate(recepcion.get());
		}
		throw new RecepcionNotExist(pId);

	}
}
