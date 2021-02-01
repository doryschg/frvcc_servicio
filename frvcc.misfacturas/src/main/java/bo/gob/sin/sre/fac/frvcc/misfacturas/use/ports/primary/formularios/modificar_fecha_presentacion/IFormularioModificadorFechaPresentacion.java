package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modificar_fecha_presentacion;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioFechaPresentacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;

public interface IFormularioModificadorFechaPresentacion {
	void modificarFechaPresentacion(FormularioId pId, FormularioFechaPresentacion pFechaPresentacion, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) throws CommandNotRegisteredError, CommandHandlerExecutionError;
}
