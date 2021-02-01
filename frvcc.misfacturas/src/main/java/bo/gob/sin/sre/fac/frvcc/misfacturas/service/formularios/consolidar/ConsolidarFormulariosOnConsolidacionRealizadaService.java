package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.consolidar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.consolidaciones.ConsolidacionRealizadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroIncrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import org.springframework.context.event.EventListener;

import java.util.stream.Collectors;

@Service
@DomainEventSubscriber({ConsolidacionRealizadaDomainEvent.class})
public class ConsolidarFormulariosOnConsolidacionRealizadaService {
	   public final ConsolidarFormulariosServiceImpl service;

	    public ConsolidarFormulariosOnConsolidacionRealizadaService(ConsolidarFormulariosServiceImpl pDeclararCompra) {
	        this.service = pDeclararCompra;
	    }

	    @EventListener
	    public void on(ConsolidacionRealizadaDomainEvent pEvent){

	        service.consolidar(
					pEvent.getFormularios().stream().map(FormularioId::new).collect(Collectors.toList()),
					new ConsolidacionId(pEvent.aggregateId()),
					new ConsolidacionUsuarioUltimaModificacion(pEvent.getUsuarioUltimaModificacion())
	    	        		);
	    }
}
