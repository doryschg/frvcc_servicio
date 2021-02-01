package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.decrementar_importe;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.decrementar_importe.IFormularioDecrementarImporte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;


@Service
public class FormularioDecrementarImporteServiceImpl implements IFormularioDecrementarImporte  {
	private static final Logger LOG= LoggerFactory.getLogger(FormularioDecrementarImporteServiceImpl.class);
    private final FormularioRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public FormularioDecrementarImporteServiceImpl(FormularioRepository pRepository, EventBus pEventBus, QueryBus pQueryBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
    }

    public void decrementar(FormularioId pFormularioId,
                            BigDecimal pImporteBaseCf,
                            BigDecimal pCreditoFiscal,
                            CompraId pCompraId,
                            FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion
                            ,BigDecimal importeTotalCompra,CompraMarcaEspecialId marcaEspecialId,String modalidadId) {
        repository.search(pFormularioId).ifPresent(
                formulario ->
                        formulario.compras()
                                .stream()
                                .filter(compraId -> compraId.value().equals(pCompraId.value()))
                                .findFirst()
                                .ifPresent(compraId -> {
                                    try {
                                	formulario.decrementoImporte(pImporteBaseCf, pCreditoFiscal, pUsuarioUltimaModificacion, pCompraId
                                			,importeTotalCompra,marcaEspecialId,modalidadId);

                                    repository.save(formulario);
                                    } catch (Exception excepcion) {
                            	  		LOG.error(excepcion.getCause().toString(), excepcion);
									}
                                    eventBus.publish(formulario.pullDomainEvents());
                                })
        );
    }
}
