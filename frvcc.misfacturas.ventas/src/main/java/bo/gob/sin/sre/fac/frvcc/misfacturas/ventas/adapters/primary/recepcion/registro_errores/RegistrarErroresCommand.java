package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro_errores;

import org.json.JSONObject;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RegistrarErroresCommand implements Command {
	private final String id;
	private final JSONObject errores;
	private final Long usuarioUltimaModificacion;

	public RegistrarErroresCommand(String pId, JSONObject pErrores, Long pUsuarioUltimaModificacion) {
		this.id = pId;
		this.errores = pErrores;
		this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
	}

	public String id() {
		return id;
	}

	public JSONObject errores() {
		return errores;
	}

	public Long usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

}
