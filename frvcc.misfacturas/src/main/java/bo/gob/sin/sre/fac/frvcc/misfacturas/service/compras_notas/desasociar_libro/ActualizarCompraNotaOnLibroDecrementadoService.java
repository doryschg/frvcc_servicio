package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.desasociar_libro;


import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDecrementadoImporteNotasDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
@DomainEventSubscriber({LibroDecrementadoImporteNotasDomainEvent.class})
public class ActualizarCompraNotaOnLibroDecrementadoService {
	   public final CompraNotaDesAsociadorLibroServiceImpl desasociador;

	    public ActualizarCompraNotaOnLibroDecrementadoService(CompraNotaDesAsociadorLibroServiceImpl pDeclararCompra) {
	        this.desasociador = pDeclararCompra;
	    }

	    @EventListener
	    public void on(LibroDecrementadoImporteNotasDomainEvent pEvent) throws QueryNotRegisteredError, QueryHandlerExecutionError{
	        desasociador.desAsociarLibro(
	        		new CompraNotaId(pEvent.compraNotaId()), new CompraNotaLibroId(pEvent.aggregateId()),
	    	        		new CompraNotaUsuarioUltimaModificacion(pEvent.usuarioUltimaModificacion()),
	    	        		new CompraNotaPeriodoUso(pEvent.periodoMes()),
	    	        		new CompraNotaGestionUso(pEvent.periodoAnio()),
	    	        		new CompraNotaNombreFormularioUso(pEvent.nombreLibro())
	    	        		);
	    }
}
