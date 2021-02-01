package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionIfc;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionNit;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionTipoDocumentoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.registro.IRecepcionRegistro;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;

@Service
public final class RegistrarRecepcionCommandHandler implements CommandHandler<RegistrarRecepcionCommand> {
	private final IRecepcionRegistro registrador;

	public RegistrarRecepcionCommandHandler(IRecepcionRegistro registrador) {
		this.registrador = registrador;
	}

	@Override
	public void handle(RegistrarRecepcionCommand command) throws CommandHandlerExecutionError {
		registrador.registrar(new RecepcionId(command.id()), new RecepcionTipoRecepcionId(command.tipoRecepcionId()),
				new RecepcionTipoDocumentoId(command.tipoDocumentoId()), new RecepcionIfc(command.ifc()),
				new RecepcionNit(command.nit()), new RecepcionUsuarioRegistro(command.usuarioRegistro()));

	}
}
