package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.procesar_archivo;

import java.io.IOException;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain.VentaRegistradaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
@DomainEventSubscriber(VentaRegistradaDomainEvent.class)
public class ProcesarArchivoOnVentaRegistro {
	private final VentaRegistroDeArchivoService ventaRegistroDeArchivoService;

	public ProcesarArchivoOnVentaRegistro(VentaRegistroDeArchivoService ventaRegistroDeArchivoService) {
		this.ventaRegistroDeArchivoService = ventaRegistroDeArchivoService;
	}

	@EventListener
	public void on(VentaRegistradaDomainEvent event)
			throws QueryHandlerExecutionError, QueryNotRegisteredError, IOException {
		ventaRegistroDeArchivoService.registrarArchivo(new ArchivoId(event.aggregateId()),
				new ArchivoTipoRecepcionId(event.tipoRecepcionId()));
	}
}
