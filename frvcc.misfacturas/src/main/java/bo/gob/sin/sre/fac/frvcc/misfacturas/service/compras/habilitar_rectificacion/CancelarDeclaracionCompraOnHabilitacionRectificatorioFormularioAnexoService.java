package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.habilitar_rectificacion;


import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioAnexoRectificadoDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoCanceladoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({FormularioAnexoRectificadoDeclaradoEventDomain.class})
public class CancelarDeclaracionCompraOnHabilitacionRectificatorioFormularioAnexoService {
	   public final CompraCancelarDeclaracionCambiarIdFormularioServiceImpl service;

	    public CancelarDeclaracionCompraOnHabilitacionRectificatorioFormularioAnexoService(CompraCancelarDeclaracionCambiarIdFormularioServiceImpl pDeclararCompra) {
	        this.service = pDeclararCompra;
	    }

	    @EventListener
	    public void on(FormularioAnexoRectificadoDeclaradoEventDomain pEvent){
	        service.cancelarDeclaracion(new CompraFormularioId(pEvent.aggregateId()), pEvent.getIdFormularioRectificado());
	    }
}
