package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteBaseCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteTotalCompra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraModificar  {
	 void modificar(CompraId pId,
             CompraFechaFactura pFechaFactura,
             CompraNitProveedor pNitProveedor,
             CompraNumeroFactura pNumeroFactura,
             CompraCodigoAutorizacion pCodigoAutorizacion,
             CompraImporteTotalCompra pImporteTotalCompra,
             CompraImporteBaseCf pImporteBaseCf,
             CompraCodigoControl pCodigoControl,
             CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
             CompraOrigenId pOrigenId) throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
