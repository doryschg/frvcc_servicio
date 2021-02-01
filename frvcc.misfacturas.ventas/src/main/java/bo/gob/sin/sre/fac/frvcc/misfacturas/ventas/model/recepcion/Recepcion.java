package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.str.constantes.estado.ConstEstado;

public final class Recepcion extends AggregateRoot {

	private RecepcionId id;
	private RecepcionTipoRecepcionId tipoRecepcionId;
	private RecepcionTipoDocumentoId tipoDocumentoId;
	private RecepcionIfc ifc;
	private RecepcionNit nit;
	private RecepcionTotalImporte totalImporte;
	private RecepcionCantidad cantidad;
	private RecepcionAccionId accionId;
	private RecepcionArchivoId archivoId;
	private RecepcionFechaRecepcion fechaRecepcion;
	private RecepcionEstadoRecepcionId estadoRecepcionId;
	private RecepcionFechaValidacion fechaValidacion;
	private RecepcionUsuarioRegistro usuarioRegistro;
	private RecepcionFechaRegistro fechaRegistro;
	private RecepcionUsuarioUltimaModificacion usuarioUltimaModificacion;
	private RecepcionFechaUltimaModificacion fechaUltimaModificacion;
	private RecepcionEstadoId estadoId;
	
	private RecepcionErrores errores;

	public Recepcion() {
		this.id = null;
		this.tipoRecepcionId = null;
		this.tipoDocumentoId = null;
		this.ifc = null;
		this.nit = null;
		this.totalImporte = null;
		this.cantidad = null;
		this.accionId = null;
		this.archivoId = null;
		this.fechaRecepcion = null;
		this.estadoRecepcionId = null;
		this.fechaValidacion = null;
		this.usuarioRegistro = null;
		this.fechaRegistro = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
		this.estadoId = null;
		this.errores = null;

	}

	public Recepcion(RecepcionId id, RecepcionTipoRecepcionId tipoRecepcionId, RecepcionTipoDocumentoId tipoDocumentoId,
			RecepcionIfc ifc, RecepcionNit nit, RecepcionTotalImporte totalImporte, RecepcionCantidad cantidad,
			RecepcionAccionId accionId, RecepcionArchivoId archivoId, RecepcionFechaRecepcion fechaRecepcion,
			RecepcionEstadoRecepcionId estadoRecepcionId, RecepcionFechaValidacion fechaValidacion,
			RecepcionUsuarioRegistro usuarioRegistro, RecepcionFechaRegistro fechaRegistro,
			RecepcionUsuarioUltimaModificacion usuarioUltimaModificacion,
			RecepcionFechaUltimaModificacion fechaUltimaModificacion, RecepcionEstadoId estadoId, RecepcionErrores errores) {
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
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
		
		this.errores = errores;
	}

	public static Recepcion Registrar(RecepcionId id, RecepcionTipoRecepcionId tipoRecepcionId,
			RecepcionTipoDocumentoId tipoDocumentoId, RecepcionIfc ifc, RecepcionNit nit,
			RecepcionUsuarioRegistro usuarioRegistro) {
		RecepcionTotalImporte totalImporte = new RecepcionTotalImporte(BigDecimal.ZERO);
		RecepcionCantidad cantidad = new RecepcionCantidad(INTEGER_ZERO);
		RecepcionAccionId accionId = new RecepcionAccionId(AccionRecepcionId.NORMAL.value());
		RecepcionFechaRecepcion fechaRecepcion = new RecepcionFechaRecepcion(LocalDateTime.now());
		RecepcionEstadoRecepcionId estadoRecepcionId = new RecepcionEstadoRecepcionId(
				EstadoRecepcionId.REGISTRADO.value());
		RecepcionArchivoId archivoId = new RecepcionArchivoId(null);
		RecepcionFechaValidacion fechaValidacion = new RecepcionFechaValidacion(null);
		RecepcionFechaRegistro fechaRegistro = new RecepcionFechaRegistro(LocalDateTime.now());
		RecepcionUsuarioUltimaModificacion usuarioUltimaModificacion = new RecepcionUsuarioUltimaModificacion(null);
		RecepcionFechaUltimaModificacion fechaUltimaModificacion = new RecepcionFechaUltimaModificacion(null);
		RecepcionEstadoId estadoId = new RecepcionEstadoId(ConstEstado.ESTADO_ACTIVO);
		RecepcionErrores errores = new RecepcionErrores(null);

		Recepcion recepcion = new Recepcion(id, tipoRecepcionId, tipoDocumentoId, ifc, nit, totalImporte, cantidad,
				accionId, archivoId, fechaRecepcion, estadoRecepcionId, fechaValidacion, usuarioRegistro, fechaRegistro,
				usuarioUltimaModificacion, fechaUltimaModificacion, estadoId, errores);

		return recepcion;
	}

	public void registarErrores(RecepcionUsuarioUltimaModificacion pUsuarioUltimaModificacion,
			RecepcionErrores pRecepcionErrores) {
		//this.recepcionErrores = new RecepcionErrores(pRecepcionErrores);
		this.estadoId = new RecepcionEstadoId(ConstEstado.ESTADO_ATENDIDO);
		this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
		this.fechaUltimaModificacion = new RecepcionFechaUltimaModificacion(LocalDateTime.now());
		this.errores = pRecepcionErrores;
	}

	public RecepcionId id() {
		return id;
	}

	public RecepcionTipoRecepcionId tipoRecepcionId() {
		return tipoRecepcionId;
	}

	public RecepcionTipoDocumentoId tipoDocumentoId() {
		return tipoDocumentoId;
	}

	public RecepcionIfc ifc() {
		return ifc;
	}

	public RecepcionNit nit() {
		return nit;
	}

	public RecepcionTotalImporte totalImporte() {
		return totalImporte;
	}

	public RecepcionCantidad cantidad() {
		return cantidad;
	}

	public RecepcionAccionId accionId() {
		return accionId;
	}

	public RecepcionArchivoId archivoId() {
		return archivoId;
	}

	public RecepcionFechaRecepcion fechaRecepcion() {
		return fechaRecepcion;
	}

	public RecepcionEstadoRecepcionId estadoRecepcionId() {
		return estadoRecepcionId;
	}

	public RecepcionFechaValidacion fechaValidacion() {
		return fechaValidacion;
	}

	public RecepcionUsuarioRegistro usuarioRegistro() {
		return usuarioRegistro;
	}

	public RecepcionFechaRegistro fechaRegistro() {
		return fechaRegistro;
	}

	public RecepcionUsuarioUltimaModificacion usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public RecepcionFechaUltimaModificacion fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public RecepcionEstadoId estadoId() {
		return estadoId;
	}
	
	public RecepcionErrores errores() {
		return errores;
	}

	public void asignarArchivo(RecepcionArchivoId archivoId) {
		this.archivoId = new RecepcionArchivoId(archivoId.value());
	}

}
