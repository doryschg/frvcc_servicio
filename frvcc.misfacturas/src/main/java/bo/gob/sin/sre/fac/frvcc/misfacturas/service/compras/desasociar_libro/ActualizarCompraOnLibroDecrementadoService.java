package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.desasociar_libro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDecrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroIncrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({LibroDecrementadoImporteDomainEvent.class})
public class ActualizarCompraOnLibroDecrementadoService {
	   public final CompraDesAsociadorLibroServiceImpl asociador;

	    public ActualizarCompraOnLibroDecrementadoService(CompraDesAsociadorLibroServiceImpl pDeclararCompra) {
	        this.asociador = pDeclararCompra;
	    }

	    @EventListener
	    public void on(LibroDecrementadoImporteDomainEvent pEvent) throws QueryNotRegisteredError, QueryHandlerExecutionError{
	        asociador.desAsociarLibro(new CompraId(pEvent.compraId()), new CompraLibroId(pEvent.aggregateId()),
	    	        		new CompraUsuarioUltimaModificacion(pEvent.usuarioUltimaModificacion()));
	    }
}
