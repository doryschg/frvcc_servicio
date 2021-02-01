package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.habilitar_rectificacion_libro;


import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroRectificadoDeclaradoNotaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({LibroRectificadoDeclaradoNotaDomainEvent.class})
public class CancelarDeclaracionNotaOnHabilitacionRectificatorioLibroService {
	   public final NotaCancelarDeclaracionCambiarIdLibroServiceImpl service;

	    public CancelarDeclaracionNotaOnHabilitacionRectificatorioLibroService(NotaCancelarDeclaracionCambiarIdLibroServiceImpl pDeclararNota) {
	        this.service = pDeclararNota;
	    }

	    @EventListener
	    public void on(LibroRectificadoDeclaradoNotaDomainEvent pEvent){
	        service.cancelarDeclaracion(new CompraNotaLibroId(pEvent.aggregateId()), pEvent.idLibroRectificado());
	    }
}
