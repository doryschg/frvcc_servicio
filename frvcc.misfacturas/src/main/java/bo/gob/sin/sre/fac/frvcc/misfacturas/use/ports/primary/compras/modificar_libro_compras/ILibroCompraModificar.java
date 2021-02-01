package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_libro_compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraDescuento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteBaseCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteNoSujetoCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteTotalCompra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDui;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ILibroCompraModificar {
	void modificar(CompraId pId, CompraNitProveedor pNitProveedor, CompraNumeroFactura pNumeroFactura,
			CompraNumeroDui pNumeroDui, CompraCodigoAutorizacion pCodigoAutorizacion, CompraFechaFactura pFechaFactura,
			CompraImporteTotalCompra pImporteTotalCompra, CompraImporteNoSujetoCf pimporteNoSujetoCf,
			CompraDescuento pDescuento, CompraImporteBaseCf pImporteBaseCf, CompraCodigoControl pCodigoControl,
			CompraNumeroDocumentoCliente pNumeroDocumentoCliente, CompraOrigenId pOrigenId,
			CompraTipoCompraId pTipoCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion)
			throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
