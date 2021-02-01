package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.declarar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar.ComprasDeclaradorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({LibroDeclaradoEventDomain.class})
public class DeclararCompraNotaOnLibroDeclaradoService {
	   public final ComprasNotasDeclaradorLibroServiceImpl declararComprasLibro;

	    public DeclararCompraNotaOnLibroDeclaradoService(ComprasNotasDeclaradorLibroServiceImpl pDeclararComprasLibro) {
	        this.declararComprasLibro = pDeclararComprasLibro;
	    }

	    @EventListener
	    public void on(LibroDeclaradoEventDomain pEvent){
	    	declararComprasLibro.declarar(new CompraNotaLibroId(pEvent.aggregateId()), new CompraNotaUsuarioUltimaModificacion(pEvent.usuarioUltimaModificacion()));
	    }
}
