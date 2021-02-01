package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.desasociar_libro;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.desasociar_libro.ICompraDesasociarLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class CompraDesAsociadorLibroServiceImpl implements ICompraDesasociarLibro {
	private static final Logger LOG = LoggerFactory.getLogger(CompraDesAsociadorLibroServiceImpl.class);
	private final CompraRepository repository;
	private final EventBus eventBus;

	public CompraDesAsociadorLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	@Override
	public void desAsociarLibro(CompraId pId, CompraLibroId pLibroId,
			CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
		vCompra.desAsociarLibro(pLibroId, pUsuarioUltimaModificacion);
		try {
			repository.guardar(vCompra);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
			throw new CompraListaErrores(pId, crearValidacionException());

		}
		eventBus.publish(vCompra.pullDomainEvents());
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DESASOCIACION_COMPRAS.getId()));
			}
		});
	}
}
