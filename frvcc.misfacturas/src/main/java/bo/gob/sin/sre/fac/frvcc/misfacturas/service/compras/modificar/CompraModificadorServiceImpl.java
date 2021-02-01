package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCreditoFiscal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraIfcProveedorNb;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteBaseCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteTotalCompra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraModalidadId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar.ICompraModificar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class CompraModificadorServiceImpl implements ICompraModificar {
    private static final Logger LOG = LoggerFactory.getLogger(CompraModificadorServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final CompraValidador validador;
    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;


    public CompraModificadorServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus queryBus, CompraValidador pValidador,
                                        VerificaCodigoAutorizacionRepository pVerificaCodigoAutorizacionRepository) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = queryBus;
        this.validador = pValidador;

        this.verificaCodigoAutorizacionRepository = pVerificaCodigoAutorizacionRepository;
    }


    @Override
    public void modificar(CompraId pId,
                          CompraFechaFactura pFechaFactura,
                          CompraNitProveedor pNitProveedor,
                          CompraNumeroFactura pNumeroFactura,
                          CompraCodigoAutorizacion pCodigoAutorizacion,
                          CompraImporteTotalCompra pImporteTotalCompra,
                          CompraImporteBaseCf pImporteBaseCf, //TODO BORRAR
                          CompraCodigoControl pCodigoControl,
                          CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                          CompraOrigenId pOrigenId) throws QueryNotRegisteredError, QueryHandlerExecutionError {
        Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraListaErrores(pId, validador.crearValidacionCompraNoExiste()));

        if (pId.value().equals(vCompra.id().value()) &&
                pFechaFactura.value().equals(vCompra.fechaFactura().value()) &&
                pNitProveedor.value().equals(vCompra.nitProveedor().value()) &&
                pNumeroFactura.value().equals(vCompra.numeroFactura().value()) &&
                pCodigoAutorizacion.value().equals(vCompra.codigoAutorizacion().value()) &&
                pImporteTotalCompra.value().equals(vCompra.importeTotalCompra().value()) &&
                pCodigoControl.value().equals(vCompra.codigoControl().value()) &&
                pOrigenId.value().equals(vCompra.origenId().value())) {
            return;
        }
        
        if (!(pFechaFactura.value().equals(vCompra.fechaFactura().value()) &&
                pNitProveedor.value().equals(vCompra.nitProveedor().value()) &&
                pNumeroFactura.value().equals(vCompra.numeroFactura().value()) &&
                pCodigoAutorizacion.value().equals(vCompra.codigoAutorizacion().value()) &&
                pImporteTotalCompra.value().equals(vCompra.importeTotalCompra().value()) &&
                pCodigoControl.value().equals(vCompra.codigoControl().value()))
             ) {
            VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
                    .verificaCodigoAutorizacion(pNitProveedor.value(),
                            pNumeroFactura.value(),
                            pCodigoAutorizacion.value(),
                            vCompra.numeroDocumentoCliente().value(),
                            pFechaFactura.value(),
                            pCodigoControl.value(),
                            pImporteTotalCompra.value());
            if (!vResultadoVerificadorNumeroAutorizacion.isValid()) {
                throw new CompraListaErrores(pId, validador.getValidacionNumeroAutorizacionException(vResultadoVerificadorNumeroAutorizacion.getErorres()));
            }

            CompraModalidadId vModalidadId = new CompraModalidadId(vResultadoVerificadorNumeroAutorizacion.getModalidad());
            CompraImporteBaseCf vImporteBase = CompraImporteBaseCf.importeBaseCreditoFiscal(pImporteTotalCompra.value(),pImporteTotalCompra.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(), vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
            CompraCreditoFiscal vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(pImporteTotalCompra.value(),pImporteTotalCompra.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(), vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
            CompraMarcaEspecialId vMarcaEspecialId = new CompraMarcaEspecialId(vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());

            CompraIfcProveedorNb vIfcProveedorNb = new CompraIfcProveedorNb(vCompra.ifcProveedorNb().value());
            CompraRazonSocialProveedor vRazonSocialProveedor = new CompraRazonSocialProveedor(vCompra.razonSocialProveedor().value());
            CompraImporteTotalCompra vImporteTotalCompra = new CompraImporteTotalCompra(pImporteTotalCompra.value());
            
            if (!vCompra.nitProveedor().value().equals(pNitProveedor.value())) {
                ContribuyenteResponse vContribuyenteResponse = queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()));
                vIfcProveedorNb = new CompraIfcProveedorNb(vContribuyenteResponse.ifc());
                vRazonSocialProveedor = new CompraRazonSocialProveedor(vContribuyenteResponse.razonSocial());
            }
            
            if (vCompra.nitProveedor().value().equals(pNitProveedor.value())
                    && vCompra.codigoAutorizacion().value().equals(pCodigoAutorizacion.value())
                    && vCompra.numeroFactura().value().equals(pNumeroFactura.value())) {
                vCompra.modificar(pFechaFactura,
                        pNitProveedor,
                        vIfcProveedorNb,
                        vRazonSocialProveedor,
                        pNumeroFactura,
                        pCodigoAutorizacion,
                        vImporteTotalCompra,
                        vImporteBase,
                        pCodigoControl,
                        pOrigenId,
                        pUsuarioUltimaModificacion,
                        vModalidadId,
                        vCreditoFiscal,
                        vMarcaEspecialId);
                try {

                    repository.guardar(vCompra);
                } catch (Exception excepcion) {
                    LOG.error(excepcion.getCause().toString(), excepcion);
                    throw new CompraListaErrores(pId, validador.getValidacionException());
                }
                eventBus.publish(vCompra.pullDomainEvents());
                return;
            }

            else {

                vCompra.modificar(pFechaFactura,
                        pNitProveedor,
                        vIfcProveedorNb,
                        vRazonSocialProveedor,
                        pNumeroFactura,
                        pCodigoAutorizacion,
                        vImporteTotalCompra,
                        vImporteBase,
                        pCodigoControl,
                        pOrigenId,
                        pUsuarioUltimaModificacion,
                        vModalidadId,
                        vCreditoFiscal,
                        vMarcaEspecialId);
                repository.BuscarCompraExistente(vCompra).ifPresentOrElse(compra -> {
                            throw new CompraListaErrores(compra.id(), validador.getValidacionCompraExistente());
                        },
                        () -> {
                            try {
                                repository.guardar(vCompra);
                                eventBus.publish(vCompra.pullDomainEvents());
                            } catch (Exception excepcion) {
                                LOG.error(excepcion.getCause().toString(), excepcion);
                                throw new CompraListaErrores(pId, validador.getValidacionException());

                            }
                        });
            }
        }

    }

}
