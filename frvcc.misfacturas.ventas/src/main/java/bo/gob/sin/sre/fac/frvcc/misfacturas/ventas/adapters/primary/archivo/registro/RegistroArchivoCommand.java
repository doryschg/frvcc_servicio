package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.registro;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RegistroArchivoCommand implements Command {
	private final String id;
	private final String tipoRecepcionId;
	private final String origenId;
	private final String idPadre;
	private final byte[] archivoByte;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;

	private Long usuarioUltimaModificacion;
	private LocalDateTime fechaUltimaModificacion;
	private String estadoId;

	public String getId() {
		return id;
	}

	public String getTipoRecepcionId() {
		return tipoRecepcionId;
	}

	public String getOrigenId() {
		return origenId;
	}

	public String getIdPadre() {
		return idPadre;
	}

	public byte[] getArchivoByte() {
		return archivoByte;
	}

	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public RegistroArchivoCommand(Builder builder) {
		this.id = builder.id;
		this.tipoRecepcionId = builder.tipoRecepcionId;
		this.origenId = builder.origenId;
		this.idPadre = builder.idPadre;
		this.archivoByte = builder.archivoByte;
		this.usuarioRegistro = builder.usuarioRegistro;
		this.fechaRegistro = builder.fechaRegistro;
		this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
		this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
		this.estadoId = builder.estadoId;
	}

	public static Builder newRegistroArchivoCommand() {
		return new Builder();
	}

	public static final class Builder {
		private String id;
		private String tipoRecepcionId;
		private String origenId;
		private String idPadre;
		private byte[] archivoByte;
		private Long usuarioRegistro;

		private Long usuarioUltimaModificacion;
		private LocalDateTime fechaRegistro;
		private LocalDateTime fechaUltimaModificacion;
		private String estadoId;

		private Builder() {
		}

		public RegistroArchivoCommand build() {
			return new RegistroArchivoCommand(this);
		}

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder tipoRecepcionId(String tipoRecepcionId) {
			this.tipoRecepcionId = tipoRecepcionId;
			return this;
		}

		public Builder origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public Builder idPadre(String idPadre) {
			this.idPadre = idPadre;
			return this;
		}

		public Builder archivoByte(byte[] archivoByte) {
			this.archivoByte = archivoByte;
			return this;
		}

		public Builder usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public Builder usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public Builder fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public Builder estadoId(String estadoId) {
			this.estadoId = estadoId;
			return this;
		}
	}
}
