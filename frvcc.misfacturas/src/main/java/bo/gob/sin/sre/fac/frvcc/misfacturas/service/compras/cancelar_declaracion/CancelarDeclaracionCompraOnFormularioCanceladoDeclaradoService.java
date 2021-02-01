package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.cancelar_declaracion;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoCanceladoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({FormularioDeclaradoCanceladoEventDomain.class})
public class CancelarDeclaracionCompraOnFormularioCanceladoDeclaradoService {
	   public final CompraCancelarDeclaracionServiceImpl service;

	    public CancelarDeclaracionCompraOnFormularioCanceladoDeclaradoService(CompraCancelarDeclaracionServiceImpl pDeclararCompra) {
	        this.service = pDeclararCompra;
	    }

	    @EventListener
	    public void on(FormularioDeclaradoCanceladoEventDomain pEvent){
	    	service.cancelarDeclaracion(new CompraFormularioId(pEvent.aggregateId()),new CompraUsuarioUltimaModificacion(pEvent.getUsuarioUltimaModificacion()));
	    }
}
