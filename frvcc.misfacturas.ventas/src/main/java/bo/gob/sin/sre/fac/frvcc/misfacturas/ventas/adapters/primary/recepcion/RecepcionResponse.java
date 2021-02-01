package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

public final class RecepcionResponse implements Response {
	private final String id;
	private final String tipoRecepcionId;
	private final String tipoDocumentoId;
	private final Long ifc;
	private final Long nit;
	private final BigDecimal totalImporte;
	private final Integer cantidad;
	private final String accionId;
	private final String archivoId;
	private final LocalDateTime fechaRecepcion;
	private final String estadoRecepcionId;
	private final LocalDateTime fechaValidacion;
	private final String errores;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;
	private final Long usuarioUltimaModificacion;
	private final LocalDateTime fechaUltimaModificacion;
	private final String estadoId;

	public RecepcionResponse(String id, String tipoRecepcionId, String tipoDocumentoId, Long ifc, Long nit,
			BigDecimal totalImporte, Integer cantidad, String accionId, String archivoId, LocalDateTime fechaRecepcion,
			String estadoRecepcionId, LocalDateTime fechaValidacion, String errores, Long usuarioRegistro,
			LocalDateTime fechaRegistro, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion,
			String estadoId) {
		this.id = id;
		this.tipoRecepcionId = tipoRecepcionId;
		this.tipoDocumentoId = tipoDocumentoId;
		this.ifc = ifc;
		this.nit = nit;
		this.totalImporte = totalImporte;
		this.cantidad = cantidad;
		this.accionId = accionId;
		this.archivoId = archivoId;
		this.fechaRecepcion = fechaRecepcion;
		this.estadoRecepcionId = estadoRecepcionId;
		this.fechaValidacion = fechaValidacion;
		this.errores = errores;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
	}

	public static RecepcionResponse fromAggregate(Recepcion recepcion) {
		return new RecepcionResponse(recepcion.id() != null ? recepcion.id().value() : null,
				recepcion.tipoRecepcionId() != null ? recepcion.tipoRecepcionId().value() : null,
				recepcion.tipoDocumentoId() != null ? recepcion.tipoDocumentoId().value() : null,
				recepcion.ifc() != null ? recepcion.ifc().value() : null,
				recepcion.nit() != null ? recepcion.nit().value() : null,
				recepcion.totalImporte() != null ? recepcion.totalImporte().value() : null,
				recepcion.cantidad() != null ? recepcion.cantidad().value() : null,
				recepcion.accionId() != null ? recepcion.accionId().value() : null,
				recepcion.archivoId() != null ? recepcion.archivoId().value() : null,
				recepcion.fechaRecepcion() != null ? recepcion.fechaRecepcion().value() : null,
				recepcion.estadoRecepcionId() != null ? recepcion.estadoRecepcionId().value() : null,
				recepcion.fechaValidacion() != null ? recepcion.fechaValidacion().value() : null,
				// TODO
				null, recepcion.usuarioRegistro() != null ? recepcion.usuarioRegistro().value() : null,
				recepcion.fechaRegistro() != null ? recepcion.fechaRegistro().value() : null,
				recepcion.usuarioUltimaModificacion() != null ? recepcion.usuarioUltimaModificacion().value() : null,
				recepcion.fechaUltimaModificacion() != null ? recepcion.fechaUltimaModificacion().value() : null,
				recepcion.estadoId() != null ? recepcion.estadoId().value() : null);
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

	public BigDecimal totalImporte() {
		return totalImporte;
	}

	public Integer cantidad() {
		return cantidad;
	}

	public String accionId() {
		return accionId;
	}

	public String archivoId() {
		return archivoId;
	}

	public LocalDateTime fechaRecepcion() {
		return fechaRecepcion;
	}

	public String estadoRecepcionId() {
		return estadoRecepcionId;
	}

	public LocalDateTime fechaValidacion() {
		return fechaValidacion;
	}

	public String errores() {
		return errores;
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
