package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class RegistroVentasCommand implements Command {
	private final List<RegistroVentaCommand> registroVentas;

	public RegistroVentasCommand(List<RegistroVentaCommand> pRegistroVentas) {
		this.registroVentas = pRegistroVentas;
	}

	public List<RegistroVentaCommand> getRegistroVentas() {
		return registroVentas;
	}
}
