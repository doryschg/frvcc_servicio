package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.anular;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class AnularVentaCommand implements Command {
	private final String id;
	private final Long usuarioUltimaModificacion;

	public AnularVentaCommand(String id, Long usuarioUltimaModificacion) {
		this.id = id;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
	}

	public String getId() {
		return id;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}
}
