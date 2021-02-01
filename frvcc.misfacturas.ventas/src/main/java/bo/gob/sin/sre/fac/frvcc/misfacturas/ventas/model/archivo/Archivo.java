package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo;

import java.time.LocalDateTime;
import java.util.Objects;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain.ArchivoRegistradoDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain.VentaRegistradaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.str.constantes.estado.ConstEstado;

public class Archivo extends AggregateRoot {
	private final ArchivoId id;
	private ArchivoTipoRecepcionId tipoRecepcionId;
	private ArchivoOrigenId origenId;
	private ArchivoIdPadre idPadre;
	private ArchivoByte archivoByte;
	private ArchivoUsuarioRegistro usuarioRegistro;
	private ArchivoFechaRegistro fechaRegistro;

	private ArchivoUsuarioUltimaModificacion usuarioUltimaModificacion;
	private ArchivoFechaUltimaModificacion fechaUltimaModificacion;
	private ArchivoEstadoId estadoId;

	public Archivo(Builder buldier) {
		this.id = buldier.id;
		this.tipoRecepcionId = buldier.tipoRecepcionId;
		this.origenId = buldier.origenId;
		this.idPadre = buldier.idPadre;
		this.archivoByte = buldier.archivoByte;
		this.usuarioRegistro = buldier.usuarioRegistro;
		this.fechaRegistro = buldier.fechaRegistro;
		this.usuarioUltimaModificacion = buldier.usuarioUltimaModificacion;
		this.fechaUltimaModificacion = buldier.fechaUltimaModificacion;
		this.estadoId = buldier.estadoId;
	}

	public static Builder newArchivo() {
		return new Builder();
	}

	public static Builder registro() {
		return new Builder();
	}

	public Archivo() {
		this.id = null;
	}

	public ArchivoId id() {
		return id;
	}

	public ArchivoByte archivoByte() {
		return archivoByte;
	}

	public ArchivoUsuarioRegistro usuarioRegistro() {
		return usuarioRegistro;
	}

	public ArchivoUsuarioUltimaModificacion usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public ArchivoFechaRegistro fechaRegistro() {
		return fechaRegistro;
	}

	public ArchivoTipoRecepcionId tipoRecepcionId() {
		return tipoRecepcionId;
	}

	public ArchivoOrigenId origenId() {
		return origenId;
	}

	public ArchivoIdPadre idPadre() {
		return idPadre;
	}

	public ArchivoFechaUltimaModificacion fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public ArchivoEstadoId estadoId() {
		return estadoId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Archivo archivo = (Archivo) o;
		return Objects.equals(id, archivo.id) && Objects.equals(tipoRecepcionId, archivo.tipoRecepcionId)
				&& Objects.equals(origenId, archivo.origenId) && Objects.equals(idPadre, archivo.idPadre)
				&& Objects.equals(archivoByte, archivo.archivoByte)
				&& Objects.equals(usuarioRegistro, archivo.usuarioRegistro)
				&& Objects.equals(fechaRegistro, archivo.fechaRegistro)
				&& Objects.equals(usuarioUltimaModificacion, archivo.usuarioUltimaModificacion)
				&& Objects.equals(fechaUltimaModificacion, archivo.fechaUltimaModificacion)
				&& Objects.equals(estadoId, archivo.estadoId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoRecepcionId, origenId, idPadre, archivoByte, usuarioRegistro, fechaRegistro,
				usuarioUltimaModificacion, fechaUltimaModificacion, estadoId);
	}

	public static Archivo registro(ArchivoId pId, ArchivoOrigenId pOrigenId, ArchivoIdPadre pIdPadre,
			ArchivoByte pArchivoByte, ArchivoUsuarioRegistro pUsuarioRegistro,
			ArchivoTipoRecepcionId pTipoRecepcionId) {
		ArchivoEstadoId vEstadoId = new ArchivoEstadoId(ConstEstado.ESTADO_ACTIVO);
		ArchivoFechaRegistro vFechaRegistro = new ArchivoFechaRegistro(LocalDateTime.now());
		ArchivoUsuarioUltimaModificacion vUsuarioUltimaModificacion = new ArchivoUsuarioUltimaModificacion(
				pUsuarioRegistro.value());

		ArchivoFechaUltimaModificacion vFechaUltimaModificacion = new ArchivoFechaUltimaModificacion(
				LocalDateTime.now());
		ArchivoTipoRecepcionId vTipoRecepcion = new ArchivoTipoRecepcionId(EnumTipoRecepcion.RECEPCION_VENTA.value());

		Archivo archivo = newArchivo().id(pId).idPadre(pIdPadre).origenId(pOrigenId).archivoByte(pArchivoByte)
				.usuarioRegistro(pUsuarioRegistro).usuarioUltimaModificacion(vUsuarioUltimaModificacion)
				.fechaRegistro(vFechaRegistro).fechaUltimaModificacion(vFechaUltimaModificacion).estadoId(vEstadoId)
				.tipoRecepcionId(vTipoRecepcion).build();
		return archivo;
	}

	public static Archivo registrar(ArchivoId pId, ArchivoOrigenId pOrigenId, ArchivoIdPadre pIdPadre,
			ArchivoByte pArchivoByte, ArchivoUsuarioRegistro pUsuarioRegistro,
			ArchivoTipoRecepcionId pTipoRecepcionId) {

		ArchivoFechaRegistro fechaRegistro = new ArchivoFechaRegistro(LocalDateTime.now());
		ArchivoFechaUltimaModificacion vFechaUltimaModificacion = new ArchivoFechaUltimaModificacion(
				LocalDateTime.now());
		ArchivoFechaRegistro vFechaRegistro = new ArchivoFechaRegistro(LocalDateTime.now());
		ArchivoUsuarioUltimaModificacion vUsuarioUltimaModificacion = new ArchivoUsuarioUltimaModificacion(
				pUsuarioRegistro.value());

		ArchivoTipoRecepcionId vTipoRecepcion = new ArchivoTipoRecepcionId(EnumTipoRecepcion.RECEPCION_VENTA.value());
		ArchivoEstadoId vEstadoId = new ArchivoEstadoId(ConstEstado.ESTADO_ACTIVO);

		Archivo archivo = newArchivo().id(pId).idPadre(pIdPadre).origenId(pOrigenId).archivoByte(pArchivoByte)
				.usuarioRegistro(pUsuarioRegistro).usuarioUltimaModificacion(vUsuarioUltimaModificacion)
				.fechaRegistro(vFechaRegistro).fechaUltimaModificacion(vFechaUltimaModificacion).estadoId(vEstadoId)
				.tipoRecepcionId(vTipoRecepcion).build();

		return archivo;
	}

	public void recepcionArchivo(ArchivoId pId, ArchivoOrigenId pOrigenId, ArchivoIdPadre pIdPadre,
			ArchivoByte pAchivoByte, ArchivoUsuarioRegistro pUsuarioRegistro, ArchivoTipoRecepcionId pTipoRecepcionId) {

		this.usuarioUltimaModificacion = new ArchivoUsuarioUltimaModificacion(pUsuarioRegistro.value());
		this.fechaUltimaModificacion = new ArchivoFechaUltimaModificacion(LocalDateTime.now());

		this.record(new ArchivoRegistradoDomainEvent(pId.value(), pTipoRecepcionId.value(), pOrigenId.value(),
				pIdPadre.value(), pUsuarioRegistro.value(), fechaRegistro.value(),
				this.usuarioUltimaModificacion.value(), this.fechaUltimaModificacion.value(), null));
		
		this.record(new VentaRegistradaDomainEvent(pId.value(), pTipoRecepcionId.value(), pOrigenId.value(),
				pIdPadre.value(), null, pUsuarioRegistro.value(), fechaRegistro.value(),
				this.usuarioUltimaModificacion.value(), this.fechaUltimaModificacion.value(), null));
	}

	public static final class Builder {
		private ArchivoId id;
		private ArchivoTipoRecepcionId tipoRecepcionId;
		private ArchivoOrigenId origenId;
		private ArchivoIdPadre idPadre;
		private ArchivoByte archivoByte;
		private ArchivoUsuarioRegistro usuarioRegistro;

		private ArchivoUsuarioUltimaModificacion usuarioUltimaModificacion;
		private ArchivoFechaRegistro fechaRegistro;
		private ArchivoFechaUltimaModificacion fechaUltimaModificacion;
		private ArchivoEstadoId estadoId;

		private Builder() {
		}

		public Archivo build() {
			return new Archivo(this);
		}

		public Builder id(ArchivoId id) {
			this.id = id;
			return this;
		}

		public Builder tipoRecepcionId(ArchivoTipoRecepcionId tipoRecepcionId) {
			this.tipoRecepcionId = tipoRecepcionId;
			return this;
		}

		public Builder origenId(ArchivoOrigenId origenId) {
			this.origenId = origenId;
			return this;
		}

		public Builder idPadre(ArchivoIdPadre idPadre) {
			this.idPadre = idPadre;
			return this;
		}

		public Builder archivoByte(ArchivoByte archivoByte) {
			this.archivoByte = archivoByte;
			return this;
		}

		public Builder usuarioRegistro(ArchivoUsuarioRegistro usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder fechaRegistro(ArchivoFechaRegistro fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public Builder usuarioUltimaModificacion(ArchivoUsuarioUltimaModificacion usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public Builder fechaUltimaModificacion(ArchivoFechaUltimaModificacion fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public Builder estadoId(ArchivoEstadoId estadoId) {
			this.estadoId = estadoId;
			return this;
		}
	}
}
