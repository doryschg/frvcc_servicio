package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;

@FunctionalInterface
public interface IFormularioRegistrador {
   void registro(FormularioId pId, FormularioTipoFormularioId pTipoFormularioId,
                 FormularioNombreFormulario pNombreFormulario, FormularioMesPeriodo pMesPeriodo,
                 FormularioAnioPeriodo pAnioPeriodo, FormularioFechaPresentacion pFechaPresentacion,
                 FormularioPeriodicidadId pPeriodicidadId, FormularioCantidadPeriodicidad pCantidadPeriodicidad,
                 FormularioTipoPresentacionId pTipoPresentacionId, FormularioLugarDepartamento pLugarDepartamento,
                 FormularioNitCi pNitCi, FormularioExpedicionCi pExpedicionCi, FormularioIfc pIfc,
                 FormularioRazonSocial pRazonSocial, FormularioDireccion pDireccion,
                 FormularioCodigoDependiente pCodigoDependiente, FormularioNitEmpleador pNitEmpleador,
                 FormularioNombreEmpleador pNombreEmpleador, FormularioDireccionEmpleador pDireccionEmpleador,
                 FormularioUsuarioRegistro pUsuarioRegistro, FormularioNumeroSucursal numeroSucursal, DatosEspecificos pDatosEspecificos, FormularioTipoUsoId esExDependiente);
}
