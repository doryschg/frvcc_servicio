package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.registro_masivo.IVentasRegistro;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public final class RegistroVentasCommandHandler implements CommandHandler<RegistroVentasCommand> {
	private final IVentasRegistro registrador;

	public RegistroVentasCommandHandler(IVentasRegistro pRegistrador) {
		this.registrador = pRegistrador;
	}

	@Override
	public void handle(RegistroVentasCommand command) {
		registrador.registrar(command);
	}
}
