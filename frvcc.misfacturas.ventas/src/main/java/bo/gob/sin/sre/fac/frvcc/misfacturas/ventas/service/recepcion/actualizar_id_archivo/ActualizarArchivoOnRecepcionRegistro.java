package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.recepcion.actualizar_id_archivo;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain.ArchivoRegistradoDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber(ArchivoRegistradoDomainEvent.class)
public class ActualizarArchivoOnRecepcionRegistro {
	private final RecepcionActualizadorIdArchivoRegistradoService recepcionActualizadorIdArchivoRegistradoService;

	public ActualizarArchivoOnRecepcionRegistro(
			RecepcionActualizadorIdArchivoRegistradoService recepcionActualizadorIdArchivoRegistradoService) {
		this.recepcionActualizadorIdArchivoRegistradoService = recepcionActualizadorIdArchivoRegistradoService;
	}

	@EventListener
	public void on(ArchivoRegistradoDomainEvent event) {
		recepcionActualizadorIdArchivoRegistradoService.actualizarIdArchivo(new RecepcionId(event.tipoRecepcionId()),
				new RecepcionArchivoId(event.aggregateId()));
	}
}
