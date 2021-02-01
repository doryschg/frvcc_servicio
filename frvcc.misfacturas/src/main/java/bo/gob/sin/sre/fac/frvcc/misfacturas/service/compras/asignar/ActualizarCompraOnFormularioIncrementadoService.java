package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asignar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioIncrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.context.event.EventListener;
import java.util.stream.Collectors;

@Service
@DomainEventSubscriber({FormularioIncrementadoImporteDomainEvent.class})
public class ActualizarCompraOnFormularioIncrementadoService {
	   public final CompraAsignadorServiceImpl asociador;

	    public ActualizarCompraOnFormularioIncrementadoService(CompraAsignadorServiceImpl vDeclararCompra) {
	        this.asociador = vDeclararCompra;
	    }

	    @EventListener
	    public void on(FormularioIncrementadoImporteDomainEvent pEvent) {
	        asociador.asignar(
	        		pEvent.getComprasActual().stream().map(CompraId::new).collect(Collectors.toList()), new CompraFormularioId(pEvent.aggregateId()),
	        		new CompraUsuarioUltimaModificacion(pEvent.getUsuarioUltimaModificacion()),
	        		new CompraPeriodoUso(pEvent.getPeriodoMes()),
	        		new CompraGestionUso(pEvent.getPeriodoAnio()),
	        		new CompraNombreFormularioUso(pEvent.getNombreformulario()),
	        		pEvent.getTipoFormularioId());
	        		
	    }
}
