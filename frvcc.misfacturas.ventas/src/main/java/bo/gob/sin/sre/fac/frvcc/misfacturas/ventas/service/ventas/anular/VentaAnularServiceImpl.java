package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.anular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class VentaAnularServiceImpl {
	private static final Logger LOG = LoggerFactory.getLogger(VentaAnularServiceImpl.class);

	private final IVentaRepository repository;
	private final EventBus eventBus;

	public VentaAnularServiceImpl(IVentaRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	public void anular(VentaId pId, VentaUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Venta venta = repository.findById(pId).orElseThrow(() -> new VentaNotExist(pId));
		venta.anularVenta(pUsuarioUltimaModificacion);
		try {
			repository.guardar(venta);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
		eventBus.publish(venta.pullDomainEvents());
	}
}
