package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({LibroDeclaradoEventDomain.class})
public class DeclararCompraOnLibroDeclaradoService {
	   public final ComprasDeclaradorLibroServiceImpl declararComprasLibro;

	    public DeclararCompraOnLibroDeclaradoService(ComprasDeclaradorLibroServiceImpl pDeclararComprasLibro) {
	        this.declararComprasLibro = pDeclararComprasLibro;
	    }

	    @EventListener
	    public void on(LibroDeclaradoEventDomain pEvent){
	    	declararComprasLibro.declarar(new CompraLibroId(pEvent.aggregateId()), new CompraUsuarioUltimaModificacion(pEvent.usuarioUltimaModificacion()));
	    }
}
