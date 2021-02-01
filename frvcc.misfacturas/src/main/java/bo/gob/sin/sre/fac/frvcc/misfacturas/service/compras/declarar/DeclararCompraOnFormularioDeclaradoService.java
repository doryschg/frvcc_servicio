package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({FormularioDeclaradoEventDomain.class})
public class DeclararCompraOnFormularioDeclaradoService {
	   public final ComprasDeclaradorServiceImpl declararCompras;

	    public DeclararCompraOnFormularioDeclaradoService(ComprasDeclaradorServiceImpl pDeclararCompra) {
	        this.declararCompras = pDeclararCompra;
	    }

	    @EventListener
	    public void on(FormularioDeclaradoEventDomain pEvent){
	    	declararCompras.declarar(new CompraFormularioId(pEvent.aggregateId()), new CompraUsuarioUltimaModificacion(pEvent.getUsuarioUltimaModificacionActual()));
	    }
}
