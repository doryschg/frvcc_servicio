package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar_selecionado;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_selecionado.ICompraModificarSeleccionado;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;


import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CompraModificarSeleccionadoImpl implements ICompraModificarSeleccionado {
    private static final Logger LOG = LoggerFactory.getLogger(CompraModificarSeleccionadoImpl.class);
    private final CompraRepository repository;

    private final CompraValidador validadorCompra;
    private final FormularioValidador validadorFormulario;

    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

    public CompraModificarSeleccionadoImpl(CompraRepository pRepository, CompraValidador validadorCompra,
                                           FormularioValidador validadorFormulario,
                                           VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository) {
        this.repository = pRepository;

        this.validadorCompra = validadorCompra;
        this.validadorFormulario = validadorFormulario;


        this.verificaCodigoAutorizacionRepository = verificaCodigoAutorizacionRepository;
    }


    @Override
    public void modificar(CompraId pId,
                          CompraFechaFactura pFechaFactura,
                          CompraImporteTotalCompra pImporteTotalCompra,
                          CompraImporteBaseCf pCompraImporteBaseCf,
                          CompraCreditoFiscal pCompraCreditoFiscal,
                          CompraCodigoControl pCodigoControl,
                          CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                          CompraOrigenId pOrigenId) {
        Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraListaErrores(pId, validadorCompra.crearValidacionCompraNoExiste()));

        if (pId.value().equals(vCompra.id().value()) &&
                pFechaFactura.value().equals(vCompra.fechaFactura().value()) &&
                pImporteTotalCompra.value().equals(vCompra.importeTotalCompra().value()) &&
                pCodigoControl.value().equals(vCompra.codigoControl().value()) &&
                pOrigenId.value().equals(vCompra.origenId())) {
            return;
        }
        VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
                .verificaCodigoAutorizacion(vCompra.nitProveedor().value(),
                        vCompra.numeroFactura().value(),
                        vCompra.codigoAutorizacion().value(),
                        vCompra.numeroDocumentoCliente().value(),
                        pFechaFactura.value(),
                        pCodigoControl.value(),
                        pImporteTotalCompra.value());
        if (!vResultadoVerificadorNumeroAutorizacion.isValid()) {
            throw new CompraListaErrores(pId, validadorCompra.getValidacionNumeroAutorizacionException(vResultadoVerificadorNumeroAutorizacion.getErorres()));
        }

        vCompra.modificarSeleccionado(pFechaFactura,
                pImporteTotalCompra,
                pCompraImporteBaseCf,
                pCompraCreditoFiscal,
                pCodigoControl,
                pUsuarioUltimaModificacion,
                pOrigenId);
        repository.guardar(vCompra);
    }
}
