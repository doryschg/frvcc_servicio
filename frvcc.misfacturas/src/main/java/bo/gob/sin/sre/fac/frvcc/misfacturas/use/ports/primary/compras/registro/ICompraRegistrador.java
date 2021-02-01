package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraRegistrador {
    void registrar(CompraId pId, CompraFechaFactura pFechaFactura,
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
                   CompraOrigenId pOrigenId) throws QueryNotRegisteredError, QueryHandlerExecutionError, ValidatorNotExist;
}
