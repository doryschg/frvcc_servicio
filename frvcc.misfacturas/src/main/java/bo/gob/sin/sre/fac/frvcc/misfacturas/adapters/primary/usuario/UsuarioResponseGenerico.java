package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario.DatosPersona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class UsuarioResponseGenerico implements Serializable, Cloneable {

	private Long usuarioId;
	private Integer tipoUsuarioId;
	private Integer perfilId;
	private Integer oficinaId;
	private Long personaId;
	private Long usuarioOvId;
	private String login;
	private DatosPersona datosPersona;

	public UsuarioResponseGenerico(Long usuarioId, Integer tipoUsuarioId, Integer perfilId, Integer oficinaId, Long personaId, Long usuarioOvId, String login) {
		this.usuarioId = usuarioId;
		this.tipoUsuarioId = tipoUsuarioId;
		this.perfilId = perfilId;
		this.oficinaId = oficinaId;
		this.personaId = personaId;
		this.usuarioOvId = usuarioOvId;
		this.login = login;
	}
	public UsuarioResponseGenerico()
	{

	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getTipoUsuarioId() {
		return tipoUsuarioId;
	}

	public void setTipoUsuarioId(Integer tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	public Integer getOficinaId() {
		return oficinaId;
	}

	public void setOficinaId(Integer oficinaId) {
		this.oficinaId = oficinaId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Long getUsuarioOvId() {
		return usuarioOvId;
	}

	public void setUsuarioOvId(Long usuarioOvId) {
		this.usuarioOvId = usuarioOvId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public DatosPersona getDatosPersona() {
		return datosPersona;
	}

	public void setDatosPersona(DatosPersona datosPersona) {
		this.datosPersona = datosPersona;
	}
}
