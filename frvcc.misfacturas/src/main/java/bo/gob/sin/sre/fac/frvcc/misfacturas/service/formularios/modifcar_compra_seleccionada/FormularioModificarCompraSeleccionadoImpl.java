package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.modifcar_compra_seleccionada;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find.FindCompraQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro.CompraRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modifcar_compra_seleccionada.IFormularioModificarCompraSeleccionado;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public final class FormularioModificarCompraSeleccionadoImpl implements IFormularioModificarCompraSeleccionado {
    private final FormularioRepository repository;
    private final QueryBus queryBus;
    private final EventBus eventBus;
    private final FormularioValidador formularioValidador;
    private final CompraValidador compraValidador;
    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

    public FormularioModificarCompraSeleccionadoImpl(FormularioRepository repository, QueryBus queryBus, EventBus eventBus, FormularioValidador formularioValidador, CompraValidador compraValidador, VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository) {
        this.repository = repository;
        this.queryBus = queryBus;
        this.eventBus = eventBus;
        this.formularioValidador = formularioValidador;
        this.compraValidador = compraValidador;

        this.verificaCodigoAutorizacionRepository = verificaCodigoAutorizacionRepository;
    }

    @Override
    public void modifciarCompraSeleccionado( CompraId pCompraId,
                                             CompraImporteTotalCompra pImporteTotalCompra,
                                             CompraFechaFactura pFechaFactura,
                                             CompraCodigoControl pCodigoControl,
                                             CompraOrigenId pOrigenId,
                                             FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        try {
            CompraResponse compraResponse = queryBus.ask(new FindCompraQuery(pCompraId.value()));

            Formulario formulario = repository.search(new FormularioId(compraResponse.getCompraResponse().formularioId())).orElseThrow(() -> new FormularioNotExist(compraResponse.getCompraResponse().formularioId(), formularioValidador.crearValidacionFormularioNoExistente()));

            if (pCompraId.value().equals(compraResponse.getCompraResponse().id()) &&
                    pFechaFactura.value().equals(compraResponse.getCompraResponse().fechaFactura()) &&
                    pImporteTotalCompra.value().equals(compraResponse.getCompraResponse().importeTotalCompra()) &&
                    pCodigoControl.value().equals(compraResponse.getCompraResponse().codigoControl())
            ) {
                return;
            }
          VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = null;
                vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
                        .verificaCodigoAutorizacion(compraResponse.getCompraResponse().getNitProveedor(),
                                compraResponse.getCompraResponse().getNumeroFactura(),
                                compraResponse.getCompraResponse().codigoAutorizacion(),
                                compraResponse.getCompraResponse().getNumeroDocumentoCliente(),
                                pFechaFactura.value(),
                                pCodigoControl.value(),
                                pImporteTotalCompra.value());
            CompraImporteBaseCf vImporteBaseCf = CompraImporteBaseCf.importeBaseCreditoFiscal(pImporteTotalCompra.value(), BigDecimal.ZERO, vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(), vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
            CompraCreditoFiscal vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(pImporteTotalCompra.value(), vImporteBaseCf.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(), vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
            Boolean vFechaValidacion = compraValidador.verificaFechaValidaEnRango(formulario.tipoFormularioId().value(),
                    formulario.fechaPresentacion().value(),
                    formulario.cantidadPeriodicidad().value(), formulario.anioPeriodo().value(), formulario.mesPeriodo().value(), pFechaFactura.value());
           if (vFechaValidacion){
                formulario.actulizarImporteCompraSelecionada(
                        new CompraId(compraResponse.getCompraResponse().getId()),
                        compraResponse.getCompraResponse().getImporteBaseCf(),
                        compraResponse.getCompraResponse().getCreditoFiscal(),
                        compraResponse.getCompraResponse().getImporteTotalCompra(),
                        vImporteBaseCf.value(),
                        vCreditoFiscal.value(),
                        pImporteTotalCompra.value(),
                        compraResponse.getCompraResponse().getModalidadId(),
                        pFechaFactura.value(),
                        pCodigoControl.value(),
                        new CompraMarcaEspecialId(compraResponse.getCompraResponse().getMarcaEspecialId()),
                        pUsuarioUltimaModificacion);
                repository.save(formulario);
                eventBus.publish(formulario.pullDomainEvents());
                return;
            }

            formulario.desmarcarImporte(Arrays.asList(compraResponse.getCompraResponse()),pUsuarioUltimaModificacion);
            repository.save(formulario);
            eventBus.publish(formulario.pullDomainEvents());
        } catch (QueryHandlerExecutionError | QueryNotRegisteredError errror) {

        }
    }
}
