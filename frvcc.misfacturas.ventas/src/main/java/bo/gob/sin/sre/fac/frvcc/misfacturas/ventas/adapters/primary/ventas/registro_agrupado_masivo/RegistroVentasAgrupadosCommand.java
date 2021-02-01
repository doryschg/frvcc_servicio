package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado_masivo;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado.RegistroVentasAgrupadoCommand;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RegistroVentasAgrupadosCommand implements Command {
	private final List<RegistroVentasAgrupadoCommand> registroVentasAgrupados;

	public RegistroVentasAgrupadosCommand(List<RegistroVentasAgrupadoCommand> pRegistroVentasAgrupados) {
		this.registroVentasAgrupados = pRegistroVentasAgrupados;
	}

	public List<RegistroVentasAgrupadoCommand> getRegistroVentasAgrupados() {
		return registroVentasAgrupados;
	}
}
