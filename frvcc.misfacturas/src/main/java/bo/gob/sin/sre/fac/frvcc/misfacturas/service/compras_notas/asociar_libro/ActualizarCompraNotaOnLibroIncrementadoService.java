package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.asociar_libro;


import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroIncrementadoImporteNotasDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
@DomainEventSubscriber({LibroIncrementadoImporteNotasDomainEvent.class})
public class ActualizarCompraNotaOnLibroIncrementadoService {
	   public final CompraNotaAsociadorLibroServiceImpl asociador;

	    public ActualizarCompraNotaOnLibroIncrementadoService(CompraNotaAsociadorLibroServiceImpl pDeclararCompra) {
	        this.asociador = pDeclararCompra;
	    }

	    @EventListener
	    public void on(LibroIncrementadoImporteNotasDomainEvent pEvent) throws QueryNotRegisteredError, QueryHandlerExecutionError{
	        asociador.asociarLibro(
	        		new CompraNotaId(pEvent.compraNotaId()), new CompraNotaLibroId(pEvent.aggregateId()),
	    	        		new CompraNotaUsuarioUltimaModificacion(pEvent.usuarioUltimaModificacion()),
	    	        		new CompraNotaPeriodoUso(pEvent.periodoMes()),
	    	        		new CompraNotaGestionUso(pEvent.periodoAnio()),
	    	        		new CompraNotaNombreFormularioUso(pEvent.nombreLibro())
	    	        		);
	    }
}
