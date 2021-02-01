package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.asociar_libro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.asociar_libro.ICompraNotaAsociarLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class CompraNotaAsociadorLibroServiceImpl implements ICompraNotaAsociarLibro {
	private static final Logger LOG = LoggerFactory.getLogger(CompraNotaAsociadorLibroServiceImpl.class);
	private final CompraNotaRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;

	public CompraNotaAsociadorLibroServiceImpl(CompraNotaRepository pRepository, EventBus pEventBus, QueryBus queryBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = queryBus;
	}

//TODO REFACTORIZAR
	public void asociarLibro(CompraNotaId pId, CompraNotaLibroId pLibroId,
			CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraNotaPeriodoUso pPeriodoUso,
			CompraNotaGestionUso pGestionUso, CompraNotaNombreFormularioUso pNombreFormulrioUso)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {
		LOG.info("compra id {}. formulario id {}. usuario {}.", pId, pLibroId, pUsuarioUltimaModificacion);
		CompraNota vCompraNota = repository.findById(pId).orElseThrow(() -> new CompraNotaNotExist(pId));

		try {
			vCompraNota.asociarALibro(pLibroId, pUsuarioUltimaModificacion, pPeriodoUso, pGestionUso,
					pNombreFormulrioUso);
			LOG.info("creditoFiscal {}", vCompraNota.creditoFiscalNota().value());
			LOG.info("importe credito fiscal {}", vCompraNota.importeTotalNota().value());

			repository.guardar(vCompraNota);
		} catch (Exception excepcion) {
			excepcion.printStackTrace();
			LOG.error(excepcion.getMessage(), excepcion);
		}
		eventBus.publish(vCompraNota.pullDomainEvents());
	}

}
