package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.consolidar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.consolidar.ICompraConsolidar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class CompraConsolidarServiceImpl implements ICompraConsolidar {
	private static final Logger LOG= LoggerFactory.getLogger(CompraConsolidarServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;

    public CompraConsolidarServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void consolidar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
        vCompra.consolidarCompra(pUsuarioUltimaModificacion);
        try {
        repository.guardar(vCompra);
        } catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
        eventBus.publish(vCompra.pullDomainEvents());
    }
}
