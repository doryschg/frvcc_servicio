package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asociar_libro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroIncrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({LibroIncrementadoImporteDomainEvent.class})
public class ActualizarCompraOnLibroIncrementadoService {
	   public final CompraAsociadorLibroServiceImpl asociador;

	    public ActualizarCompraOnLibroIncrementadoService(CompraAsociadorLibroServiceImpl pDeclararCompra) {
	        this.asociador = pDeclararCompra;
	    }

	    @EventListener
	    public void on(LibroIncrementadoImporteDomainEvent pEvent) throws QueryNotRegisteredError, QueryHandlerExecutionError{
	        asociador.asociarLibro(
	        		new CompraId(pEvent.compraId()), new CompraLibroId(pEvent.aggregateId()),
	    	        		new CompraUsuarioUltimaModificacion(pEvent.usuarioUltimaModificacion()),
	    	        		new CompraPeriodoUso(pEvent.periodoMes()),
	    	        		new CompraGestionUso(pEvent.periodoAnio()),
	    	        		new CompraNombreFormularioUso(pEvent.nombreLibro())
	    	        		);
	    }
}
