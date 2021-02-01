package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.rechazar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioLoginUsuarioReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNombreReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;

public interface IFormularioRechazo {
	void rechazar(FormularioId pFormularioId, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, FormularioNombreReceptor pNombreReceptor,
				  FormularioLoginUsuarioReceptor pLoginUsuarioReceptor) throws CommandNotRegisteredError, CommandHandlerExecutionError;
}
