package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.desasociar_libro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.desasociar_libro.ICompraDesasociarLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.desasociar_libro.ICompraNotaDesAsociarLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CompraNotaDesAsociadorLibroServiceImpl implements ICompraNotaDesAsociarLibro {
	private static final Logger LOG = LoggerFactory.getLogger(CompraNotaDesAsociadorLibroServiceImpl.class);
	private final CompraNotaRepository repository;
	private final EventBus eventBus;

	public CompraNotaDesAsociadorLibroServiceImpl(CompraNotaRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	@Override
	public void desAsociarLibro(CompraNotaId pId, CompraNotaLibroId pLibroId,
			CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraNotaPeriodoUso pPeriodoUso,
			CompraNotaGestionUso pGestionUso, CompraNotaNombreFormularioUso pNombreFormulrioUso) {
		CompraNota vCompraNota = repository.findById(pId).orElseThrow(() -> new CompraNotaNotExist(pId));
		vCompraNota.desAsociarLibro(pLibroId, pUsuarioUltimaModificacion);
		try {

			repository.guardar(vCompraNota);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
		eventBus.publish(vCompraNota.pullDomainEvents());
	}
}
