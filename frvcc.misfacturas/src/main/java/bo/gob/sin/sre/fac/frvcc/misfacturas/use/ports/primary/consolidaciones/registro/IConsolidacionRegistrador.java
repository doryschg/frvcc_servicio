package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;

@FunctionalInterface
public interface IConsolidacionRegistrador {
   void registro(ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
				 ConsolidacionRazonSocialAgente razonSocialAgente,
				 ConsolidacionSucursal sucursal, ConsolidacionDireccionSucursal direccionSucursal,
				 ConsolidacionDepartamentoSucursal departamentoSucursal, ConsolidacionAdministracion administracion,
				 ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
				 ConsolidacionCantidadFormularios cantidadFormularios, ConsolidacionTotalCantidadFacturas totalCantidadFacturas,
				 ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas, ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas,
				 ConsolidacionTotalImporteFacturas totalImporteFacturas, ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas,
				 ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas, ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta,
				 ConsolidacionTotalPagoCuenta totalPagoCuenta, ConsolidacionUsuarioConsolidador usuarioConsolidador,
				 ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador, ConsolidacionNombreConsolidador	 nombreConsolidador,
				 ConsolidacionUsuarioRegistro usuarioRegistro);
}
