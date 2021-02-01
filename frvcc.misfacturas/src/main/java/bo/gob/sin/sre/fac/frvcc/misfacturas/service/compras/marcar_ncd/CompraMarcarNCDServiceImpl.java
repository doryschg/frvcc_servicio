package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.marcar_ncd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.marcar_ncd.ICompraMarcarNCD;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;


@Service
public class CompraMarcarNCDServiceImpl implements ICompraMarcarNCD {
	private static final Logger LOG= LoggerFactory.getLogger(CompraMarcarNCDServiceImpl.class);
	 private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public CompraMarcarNCDServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
    }
    
    @Override
	public void marcarNCD(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
		vCompra.marcarNCD(pUsuarioUltimaModificacion);
		try {
			repository.guardar(vCompra);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
		eventBus.publish(vCompra.pullDomainEvents());
	}
}
