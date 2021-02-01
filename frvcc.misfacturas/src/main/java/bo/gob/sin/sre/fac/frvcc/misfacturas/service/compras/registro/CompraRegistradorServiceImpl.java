package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro.ICompraRegistrador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.ICompraContribuyenteCache;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CompraRegistradorServiceImpl implements ICompraRegistrador {
    private static final Logger LOG = LoggerFactory.getLogger(CompraRegistradorServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final CompraValidador validador;
    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;
    private final ICompraContribuyenteCache compraContribuyenteCache;


    public CompraRegistradorServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus, CompraValidador pValidador, VerificaCodigoAutorizacionRepository pVerificadorCodigoAutorizacionRepository, ICompraContribuyenteCache compraContribuyenteCache) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
        this.validador = pValidador;
        this.verificaCodigoAutorizacionRepository = pVerificadorCodigoAutorizacionRepository;

        this.compraContribuyenteCache = compraContribuyenteCache;
    }

    public void registrar(CompraId pId,
                          CompraFechaFactura pFechaFactura,
                          CompraNitProveedor pNitProveedor,
                          CompraNumeroFactura pNumeroFactura,
                          CompraCodigoAutorizacion pCodigoAutorizacion,
                          CompraImporteTotalCompra pImporteTotalCompra,
                          CompraImporteBaseCf pImporteBaseCf,
                          CompraCodigoControl pCodigoControl,
                          CompraUsuarioRegistro pUsuarioRegistro,
                          CompraNombreCliente pNombreCliente,
                          CompraTipoDocumentoCliente pTipoDocumentoCliente,
                          CompraNumeroDocumentoCliente pNumeroDocumentoCliente,
                          CompraComplementoDocumentoCliente pComplementoDocumentoCliente,
                          CompraOrigenId pOrigenId)
            throws QueryNotRegisteredError, QueryHandlerExecutionError {


        ValidationResponse vResultadoValidacion = validador.validarCompra(
                new HashMap<>() {{
                    put("id", pId.value() != null ? pId.value() : "");
                    put("fechaFactura", pFechaFactura.value() != null ? pFechaFactura.value().toString() : "");
                    put("nitProveedor", pNitProveedor.value() != null ? pNitProveedor.value().toString() : "");
                    put("numeroFactura", pNumeroFactura.value() != null ? pNumeroFactura.value().toString() : "");
                    put("codigoAutorizacion", pCodigoAutorizacion.value() != null ? pCodigoAutorizacion.value() : "");
                    put("importeTotalCompra", pImporteTotalCompra.value() != null ? pImporteTotalCompra.value().toString() : "");
                    put("usuarioRegistro", pUsuarioRegistro.value() != null ? pUsuarioRegistro.value().toString() : "");
                    put("nombreCliente", pNombreCliente.value() != null ? pNombreCliente.value() : "");
                    put("tipoDocumentoCliente", pTipoDocumentoCliente.value() != null ? pTipoDocumentoCliente.value() : "");
                    put("numeroDocumentoCliente", pNumeroDocumentoCliente.value() != null ? pNumeroDocumentoCliente.value() : "");
                    put("origenId", pOrigenId.value() != null ? pOrigenId.value() : "");
                }});

        if (vResultadoValidacion.hasErrors()) {
            throw new CompraListaErrores(pId, vResultadoValidacion);
        }

        VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion= null;
        try {
            vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
                    .verificaCodigoAutorizacion(pNitProveedor.value(),
                            pNumeroFactura.value(),
                            pCodigoAutorizacion.value(),
                            pNumeroDocumentoCliente.value(),
                            pFechaFactura.value(),
                            pCodigoControl.value(),
                            pImporteTotalCompra.value());
        } catch (Exception excepcion) {
            LOG.error(excepcion.getCause().toString(), excepcion);
            throw new CompraListaErrores(pId, validador.getValidacionException());

        }
        if (!vResultadoVerificadorNumeroAutorizacion.isValid()) {
            throw new CompraListaErrores(pId, validador.getValidacionNumeroAutorizacionException(vResultadoVerificadorNumeroAutorizacion.getErorres()));
        }

        CompraModalidadId vModalidadId = new CompraModalidadId(vResultadoVerificadorNumeroAutorizacion.getModalidad());
        CompraImporteBaseCf vImporteBaseCf=null;
        if(pOrigenId.value().equals(EnumOrigenId.APLICACION.value()))
        {
            vImporteBaseCf = CompraImporteBaseCf.importeBaseCreditoFiscal(pImporteTotalCompra.value(), pImporteBaseCf.value(),vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
        }
        else
        {
            vImporteBaseCf=pImporteBaseCf;
        }
        CompraCreditoFiscal vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(pImporteTotalCompra.value(), vImporteBaseCf.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(), vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
        CompraMarcaEspecialId vMarcaEspecialId = new CompraMarcaEspecialId(vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());
        CompraConDerechoCf vConDerechoCf = new CompraConDerechoCf(vResultadoVerificadorNumeroAutorizacion.getConDerechoCf());
        CompraTipoSectorId vTipoSectorId= new CompraTipoSectorId(vResultadoVerificadorNumeroAutorizacion.getTipoSector());

        ContribuyenteResponse contribuyenteResponse = null;
        if (!compraContribuyenteCache.isPresent(pNitProveedor.value())) {
            contribuyenteResponse = (ContribuyenteResponse) Optional.ofNullable(queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()))).orElse(null);
        }

        CompraIfcProveedorNb ifcProveedorNb = new CompraIfcProveedorNb(
                compraContribuyenteCache.isPresent(pNitProveedor.value()) ?
                        compraContribuyenteCache.getIfcContribuyenteCache(pNitProveedor.value()) :
                        contribuyenteResponse.ifc()
        );
        CompraRazonSocialProveedor razonSocialProveedor = new CompraRazonSocialProveedor(
                compraContribuyenteCache.isPresent(pNitProveedor.value()) ?
                        compraContribuyenteCache.getRazonSocialContribuyenteCache(pNitProveedor.value()) :
                        contribuyenteResponse.razonSocial()
        );

        Compra vCompra = Compra.registro(pId,
                pFechaFactura,
                ifcProveedorNb,
                pNitProveedor,
                razonSocialProveedor,
                pNumeroFactura,
                pCodigoAutorizacion,
                pImporteTotalCompra,
                vImporteBaseCf,
                pCodigoControl,
                pUsuarioRegistro,
                pNombreCliente,
                pTipoDocumentoCliente,
                pNumeroDocumentoCliente,
                pComplementoDocumentoCliente,
                pOrigenId,
                vModalidadId,
                vCreditoFiscal,
                vMarcaEspecialId,
                vConDerechoCf,
                vTipoSectorId);
        repository.BuscarCompraExistente(vCompra).ifPresentOrElse(compra -> {
                    throw new CompraListaErrores(compra.id(), validador.getValidacionCompraExistente());

                },
                () -> {
                    try {
                        repository.persist(vCompra);
                        eventBus.publish(vCompra.pullDomainEvents());
                    } catch (Exception excepcion) {
                        LOG.error(excepcion.getCause().toString(), excepcion);
                        throw new CompraListaErrores(pId, validador.getValidacionException());

                    }
                });




    }


}


