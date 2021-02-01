package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones.consolidar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface IConsolidacionConsolidar {
	 void consolidar(ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
					ConsolidacionRazonSocialAgente razonSocialAgente,
					ConsolidacionAdministracion administracion,
					ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
					ConsolidacionUsuarioConsolidador usuarioConsolidador,
					ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador, ConsolidacionNombreConsolidador	 nombreConsolidador,
					ConsolidacionUsuarioRegistro usuarioRegistro) throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
