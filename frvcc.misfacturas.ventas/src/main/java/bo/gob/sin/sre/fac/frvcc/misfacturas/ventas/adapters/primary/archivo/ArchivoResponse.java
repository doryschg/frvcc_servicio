package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.Archivo;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

public final class ArchivoResponse implements Response {

	private final String id;
	private final String tipoRecepcionId;
	private final String origenId;
	private final String idPadre;
	private final byte[] archivoByte;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;
	private final Long usuarioUltimaModificacion;
	private final LocalDateTime fechaUltimaModificacion;
	private final String estadoId;

	public ArchivoResponse(String id, String tipoRecepcionId, String origenId, String idPadre, byte[] archivoByte,
			Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
			LocalDateTime fechaUltimaModificacion, String estadoId) {
		this.id = id;
		this.tipoRecepcionId = tipoRecepcionId;
		this.origenId = origenId;
		this.idPadre = idPadre;
		this.archivoByte = archivoByte;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
	}

	public static ArchivoResponse fromAggregate(Archivo archivo) {

		return new ArchivoResponse(archivo.id().value(), archivo.tipoRecepcionId().value(),
				archivo.origenId() == null ? null : archivo.origenId().value(),
				archivo.idPadre() == null ? null : archivo.idPadre().value(), archivo.archivoByte().value(),
				archivo.usuarioRegistro() == null ? null : archivo.usuarioRegistro().value(),
				archivo.fechaRegistro() == null ? null : archivo.fechaRegistro().value(),
				archivo.usuarioUltimaModificacion() == null ? null : archivo.usuarioUltimaModificacion().value(),
				archivo.fechaUltimaModificacion() == null ? null : archivo.fechaUltimaModificacion().value(),
				archivo.estadoId() == null ? null : archivo.estadoId().value());
	}

	public String id() {
		return id;
	}

	public String tipoRecepcionId() {
		return tipoRecepcionId;
	}

	public String origenId() {
		return origenId;
	}

	public String idPadre() {
		return idPadre;
	}

	public byte[] archivoByte() {
		return archivoByte;
	}

	public Long usuarioRegistro() {
		return usuarioRegistro;
	}

	public LocalDateTime fechaRegistro() {
		return fechaRegistro;
	}

	public Long usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public LocalDateTime fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public String estadoId() {
		return estadoId;
	}
}
