package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaConDerechoDf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaDebitoFiscal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaDescuento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaIfcProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteBase;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteExento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteIceIehdTasas;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteNoSujetoDf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTasaCero;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNombreCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaSubTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface IVentaRegistro {
	void registrar(VentaId pId, VentaRecepcionId pRecepcionId, VentaIfcProveedor pIfcProveedor,
			VentaNitProveedor pNitProveedor, VentaRazonSocialProveedor pRazonSocialProveedor,
			VentaNumeroDocumentoCliente pNumeroDocumentoCliente, VentaNombreCliente pNombreCliente,
			VentaNumeroFactura pNumeroFactura, VentaCodigoAutorizacion pCodigoAutorizacion,
			VentaFechaFactura pFechaFactura, VentaImporteTotal pImporteTotalVenta, VentaCodigoControl pCodigoControl,
			VentaImporteBase pImporteBase, VentaOrigenId pOrigenId, VentaUsuarioRegistro pUsuarioRegistro,
			VentaConDerechoDf pVentaConDerechoDf, VentaMarcaEspecialId pVentaMarcaEspecialId,
			VentaDescuento pVentaDescuento, VentaDebitoFiscal pVentaDebitoFiscal,
			VentaImporteIceIehdTasas pVentaImporteIceIehdTasas, VentaImporteTasaCero pVentaImporteTasaCero,
			VentaImporteNoSujetoDf pVentaImporteNoSujetoDf, VentaImporteExento pVentaImporteExento,
			VentaSubTotal pVentaSubTotal) throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
