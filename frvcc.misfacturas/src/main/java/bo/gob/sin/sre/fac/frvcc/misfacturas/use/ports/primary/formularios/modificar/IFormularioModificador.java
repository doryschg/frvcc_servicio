package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;

public interface IFormularioModificador {
	void modificar(FormularioId pId,
            FormularioDireccion pDireccion,
            FormularioDireccionEmpleador pDireccionEmpleador,
            FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion,
            FormularioLugarDepartamento pLugarDepartamento,
            FormularioFechaPresentacion pFechaPresentacion,
            FormularioNumeroSucursal pNumeroSucursal,
            DatosEspecificos pDatosespecificos,
			FormularioTipoUsoId pEsExDependiente);
}
