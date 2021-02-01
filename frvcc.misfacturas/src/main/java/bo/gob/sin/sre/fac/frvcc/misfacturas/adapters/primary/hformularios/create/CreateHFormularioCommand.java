package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.hformularios.create;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class CreateHFormularioCommand implements Command {
    private final String id;
    private final String idFormulario;
    private final String estadoFormularioId;
    private final Long numeroOrden;
    private final String compras;
    private final Long usuarioRegistro;
    private final Long usuarioUltimaModificacion;
	public CreateHFormularioCommand(String id, String idFormulario, String estadoFormularioId, Long numeroOrden,
			String compras, Long usuarioRegistro, Long usuarioUltimaModificacion) {
		super();
		this.id = id;
		this.idFormulario = idFormulario;
		this.estadoFormularioId = estadoFormularioId;
		this.numeroOrden = numeroOrden;
		this.compras = compras;
		this.usuarioRegistro = usuarioRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
	}
	public String id() {
		return id;
	}
	public String idFormulario() {
		return idFormulario;
	}
	public String estadoFormularioId() {
		return estadoFormularioId;
	}
	public Long numeroOrden() {
		return numeroOrden;
	}
	public String compras() {
		return compras;
	}
	public Long usuarioRegistro() {
		return usuarioRegistro;
	}
	public Long usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}
 



}
