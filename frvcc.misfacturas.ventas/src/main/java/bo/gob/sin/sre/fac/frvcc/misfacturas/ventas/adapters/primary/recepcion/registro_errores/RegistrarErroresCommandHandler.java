package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro_errores;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.registro_errores.IRecepcionRegistroErrores;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;

@Service
public class RegistrarErroresCommandHandler implements CommandHandler<RegistrarErroresCommand> {
	private final IRecepcionRegistroErrores registradorErroresService;

	public RegistrarErroresCommandHandler(IRecepcionRegistroErrores pRegistradorErroresService) {
		this.registradorErroresService = pRegistradorErroresService;
	}

	@Override
	public void handle(RegistrarErroresCommand command) throws CommandHandlerExecutionError {
		this.registradorErroresService.registrar(new RecepcionId(command.id()),
				new RecepcionUsuarioUltimaModificacion(command.usuarioUltimaModificacion()), command.errores());
	}
}
