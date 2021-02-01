package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class VentaRegistradaDomainEvent extends DomainEvent {
	private final String tipoRecepcionId;
	private final String origenId;
	private final String idPadre;
	private final byte[] archivoByte;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;
	private final Long usuarioUltimaModificacion;
	private final LocalDateTime fechaUltimaModificacion;
	private final String estadoId;

	public VentaRegistradaDomainEvent(String aggregateId, String tipoRecepcionId, String origenId, String idPadre,
			byte[] archivoByte, Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
			LocalDateTime fechaUltimaModificacion, String estadoId) {
		super(aggregateId);
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

	private VentaRegistradaDomainEvent(BuilderVentaRegistradaDomainEvent builder) {
		super(builder.id);
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

	public VentaRegistradaDomainEvent(String aggregateId, String eventId, String occurredOn, String tipoRecepcionId,
			String origenId, String idPadre, byte[] archivoByte, Long usuarioRegistro, LocalDateTime fechaRegistro,
			Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId) {
		super(aggregateId, eventId, occurredOn);
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

	public VentaRegistradaDomainEvent(String aggregateId, String eventId, String occurredOn,
			BuilderVentaRegistradaDomainEvent builder) {
		super(aggregateId, eventId, occurredOn);
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

	public VentaRegistradaDomainEvent() {
		this.tipoRecepcionId = null;
		this.origenId = null;
		this.idPadre = null;
		this.archivoByte = null;
		this.usuarioRegistro = null;
		this.fechaRegistro = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
		this.estadoId = null;
	}

	@Override
	public String eventName() {
		return "recepcion_archivo_ventas";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {
			{
				put("tipoRecepcionId", tipoRecepcionId());
				put("origenId", origenId());
				put("idPadre", idPadre());
				put("archivoByte", archivoByte());
				put("usuarioRegistro", usuarioRegistro());
				put("fechaRegistro", fechaRegistro());
				put("usuarioUltimaModificacion", usuarioUltimaModificacion());
				put("fechaUltimaModificacion", fechaUltimaModificacion());
				put("estadoId", estadoId());
			}
		};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
			String occurredOn) {

		return new VentaRegistradaDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("tipoRecepcionId"),
				(String) body.get("origenId"), (String) body.get("idPadre"), (byte[]) body.get("archivoByte"),
				Long.parseLong(body.get("usuarioRegistro").toString()), LocalDateTime.now(),
				Long.parseLong(body.get("usuarioUltimaModificacion").toString()), LocalDateTime.now(),
				(String) body.get("estadoId"));
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

	public class BuilderVentaRegistradaDomainEvent {
		private String id;
		private String tipoRecepcionId;
		private String origenId;
		private String idPadre;
		private byte[] archivoByte;
		private Long usuarioRegistro;
		private LocalDateTime fechaRegistro;
		private Long usuarioUltimaModificacion;
		private LocalDateTime fechaUltimaModificacion;
		private String estadoId;

		public BuilderVentaRegistradaDomainEvent id(String id) {
			this.id = id;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent tipoRecepcionId(String tipoRecepcionId) {
			this.tipoRecepcionId = tipoRecepcionId;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent idPadre(String idPadre) {
			this.idPadre = idPadre;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent archivoByte(byte[] archivoByte) {
			this.archivoByte = archivoByte;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public BuilderVentaRegistradaDomainEvent estadoId(String estadoId) {
			this.estadoId = estadoId;
			return this;
		}

	}
}
