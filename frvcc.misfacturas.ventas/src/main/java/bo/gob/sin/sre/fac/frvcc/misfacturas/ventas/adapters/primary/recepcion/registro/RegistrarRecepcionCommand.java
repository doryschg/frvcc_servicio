package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class RegistrarRecepcionCommand implements Command {

	private final String id;
	private final String tipoRecepcionId;
	private final String tipoDocumentoId;
	private final Long ifc;
	private final Long nit;
	private final Long usuarioRegistro;

	public RegistrarRecepcionCommand(String id, String tipoRecepcionId, String tipoDocumentoId, Long ifc, Long nit,
			Long usuarioRegistro) {
		this.id = id;
		this.tipoRecepcionId = tipoRecepcionId;
		this.tipoDocumentoId = tipoDocumentoId;
		this.ifc = ifc;
		this.nit = nit;
		this.usuarioRegistro = usuarioRegistro;
	}

	public String id() {
		return id;
	}

	public String tipoRecepcionId() {
		return tipoRecepcionId;
	}

	public String tipoDocumentoId() {
		return tipoDocumentoId;
	}

	public Long ifc() {
		return ifc;
	}

	public Long nit() {
		return nit;
	}

	public Long usuarioRegistro() {
		return usuarioRegistro;
	}
}
