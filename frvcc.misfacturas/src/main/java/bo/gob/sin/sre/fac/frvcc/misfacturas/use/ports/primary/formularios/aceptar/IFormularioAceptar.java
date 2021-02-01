package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.aceptar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;

public interface IFormularioAceptar {
	public void aceptar(FormularioId pFormularioId, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, FormularioNombreReceptor pNombreReceptor,
						FormularioLoginUsuarioReceptor pLoginUsuarioReceptor, FormularioTipoUsoId pEsExDependiente) throws CommandNotRegisteredError, CommandHandlerExecutionError;
}


