package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.habilitar_rectificacion_libro;


import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroRectificadoDeclaradoCompraDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({LibroRectificadoDeclaradoCompraDomainEvent.class})
public class CancelarDeclaracionCompraOnHabilitacionRectificatorioLibroService {
	   public final CompraCancelarDeclaracionCambiarIdLibroServiceImpl service;

	    public CancelarDeclaracionCompraOnHabilitacionRectificatorioLibroService(CompraCancelarDeclaracionCambiarIdLibroServiceImpl pDeclararCompra) {
	        this.service = pDeclararCompra;
	    }

	    @EventListener
	    public void on(LibroRectificadoDeclaradoCompraDomainEvent pEvent){
	        service.cancelarDeclaracion(new CompraLibroId(pEvent.aggregateId()), pEvent.idLibroRectificado());
	    }
}
