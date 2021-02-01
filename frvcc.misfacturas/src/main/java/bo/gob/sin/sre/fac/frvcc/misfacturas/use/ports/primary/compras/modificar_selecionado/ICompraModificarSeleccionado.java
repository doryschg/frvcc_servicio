package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_selecionado;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;

public interface ICompraModificarSeleccionado {
	 void modificar(CompraId pId,
                    CompraFechaFactura pFechaFactura,
                    CompraImporteTotalCompra pImporteTotalCompra,
                    CompraImporteBaseCf compraImporteBaseCf, CompraCreditoFiscal compraCreditoFiscal, CompraCodigoControl pCodigoControl,
                    CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                    CompraOrigenId pOrigenId);
}
