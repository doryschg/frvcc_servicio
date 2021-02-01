package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.des_asignar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDecrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.context.event.EventListener;

import java.util.stream.Collectors;

@Service
@DomainEventSubscriber({FormularioDecrementadoImporteDomainEvent.class})
public class ActualizarCompraOnFormularioDecrementadoService {
	   public final CompraDesAsignadorServiceImpl desAsociador;

	    public ActualizarCompraOnFormularioDecrementadoService(CompraDesAsignadorServiceImpl pDeclararCompra) {
	        this.desAsociador = pDeclararCompra;
	    }

	    @EventListener
	    public void on(FormularioDecrementadoImporteDomainEvent pEvent){
	        desAsociador.desAsignar(
	        		pEvent.getComprasActual().stream().map(CompraId::new).collect(Collectors.toList()),
					new CompraFormularioId(pEvent.aggregateId()),
	        		new CompraUsuarioUltimaModificacion(pEvent.getUsuarioUltimaModificacion()),
	        		new CompraPeriodoUso(pEvent.getPeriodoMes()),
	        		new CompraGestionUso(pEvent.getPeriodoAnio()),
	        		new CompraNombreFormularioUso(pEvent.getNombreformulario()),
	        		pEvent.getTipoFormularioId());
	        		
	    }
}
