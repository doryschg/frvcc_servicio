package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.incrementar_importe;

import java.math.BigDecimal;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.incrementar_importe.IFormularioIncrementarImporte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class FormularioIncrementarImporteServiceImpl implements IFormularioIncrementarImporte {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioIncrementarImporteServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;

	public FormularioIncrementarImporteServiceImpl(FormularioRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	public void incremento(FormularioId pFormularioId,
                           BigDecimal pImporteBaseCf,
                           BigDecimal pCreditoFiscal,
			FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraId pCompraId,
			BigDecimal pImporteTotalCompra, CompraMarcaEspecialId pMarcaEspecialId, String pModalidadId) {

		repository.search(pFormularioId)
				.ifPresent(formulario -> formulario.compras().stream()
						.filter(compraId -> compraId.value().equals(pCompraId.value())).findFirst()
						.ifPresentOrElse(compraId -> Function.identity(), () -> {
							try {
								formulario.incrementoImporte(pImporteBaseCf, pCreditoFiscal, pUsuarioUltimaModificacion,
										pCompraId, pImporteTotalCompra, pMarcaEspecialId, pModalidadId);
								repository.save(formulario);
							} catch (Exception excepcion) {
								LOG.error(excepcion.getCause().toString(), excepcion);
							}
							eventBus.publish(formulario.pullDomainEvents());
						}));
	}
}
