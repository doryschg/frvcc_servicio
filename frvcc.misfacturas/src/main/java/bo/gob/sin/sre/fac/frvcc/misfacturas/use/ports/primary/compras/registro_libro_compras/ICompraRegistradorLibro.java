package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro_libro_compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraRegistradorLibro {
	void registrar(CompraId pId, 
			CompraNitProveedor pNitProveedor,
			CompraNumeroFactura pNumeroFactura,
			CompraNumeroDui numeroDui,
			CompraCodigoAutorizacion pCodigoAutorizacion,
			CompraFechaFactura pFechaFactura,
			CompraImporteTotalCompra pImporteTotalCompra,
			CompraImporteNoSujetoCf pimporteNoSujetoCf,
			CompraDescuento pDescuento, 
			CompraImporteBaseCf pImporteBaseCf,
			CompraCodigoControl pCodigoControl, 
			CompraTipoDocumentoCliente pTipoDocumentoCliente,
			CompraNumeroDocumentoCliente pNumeroDocumentoCliente,
			CompraComplementoDocumentoCliente pComplementoDocumentoCliente, 
			CompraNombreCliente pNombreCliente,
			CompraOrigenId pOrigenId,
			CompraUsuarioRegistro pUsuarioRegistro)
			throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
