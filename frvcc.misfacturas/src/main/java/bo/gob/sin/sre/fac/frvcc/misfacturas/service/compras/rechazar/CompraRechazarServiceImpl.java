package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.rechazar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.rechazar.ICompraRechazar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class CompraRechazarServiceImpl implements ICompraRechazar {
	private static final Logger LOG = LoggerFactory.getLogger(CompraRechazarServiceImpl.class);

	private final CompraRepository repository;
	private final EventBus eventBus;

	public CompraRechazarServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	public void rechazar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Compra compra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
		compra.rechazarCompra(pUsuarioUltimaModificacion);
		try {
			repository.guardar(compra);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
		eventBus.publish(compra.pullDomainEvents());
	}
}
