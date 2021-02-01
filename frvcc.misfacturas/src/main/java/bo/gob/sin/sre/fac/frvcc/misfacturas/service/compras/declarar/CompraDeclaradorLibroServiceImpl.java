package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar.ICompraDeclararLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class CompraDeclaradorLibroServiceImpl implements ICompraDeclararLibro {
	private static final Logger LOG = LoggerFactory.getLogger(CompraDeclaradorLibroServiceImpl.class);
	private final CompraRepository repository;
	private final EventBus eventBus;

	public CompraDeclaradorLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	@Override
	public void declarar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
		vCompra.declararCompra(pUsuarioUltimaModificacion);
		try {
			repository.guardar(vCompra);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
		eventBus.publish(vCompra.pullDomainEvents());
	}
}
