package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.marcar_ncd;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota.CompraNotaRegistradaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({CompraNotaRegistradaDomainEvent.class})
public class MarcarNCDComprasOnComprasNotasService {

	public final CompraMarcarNCDServiceImpl comprasMarcarNCD;

    public MarcarNCDComprasOnComprasNotasService(CompraMarcarNCDServiceImpl pComprasMarcarNCD) {
        this.comprasMarcarNCD = pComprasMarcarNCD;
    }

    @EventListener
    public void on(CompraNotaRegistradaDomainEvent pEvent){
    	 CompraId compraId = new CompraId(pEvent.getCompraId());
    	 CompraUsuarioUltimaModificacion usuarioUltimaModificacion = new CompraUsuarioUltimaModificacion(pEvent.getUsuarioUltimaModificacion());
    	 comprasMarcarNCD.marcarNCD(compraId,usuarioUltimaModificacion);

    }
  }
