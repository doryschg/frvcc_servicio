package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class ArchivoRegistradoDomainEvent extends DomainEvent {
	private final String tipoRecepcionId;
	private final String origenId;
	private final String idPadre;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;
	private final Long usuarioUltimaModificacion;
	private final LocalDateTime fechaUltimaModificacion;
	private final String estadoId;

	public ArchivoRegistradoDomainEvent(String aggregateId, String tipoRecepcionId, String origenId, String idPadre,
			Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
			LocalDateTime fechaUltimaModificacion, String estadoId) {
		super(aggregateId);
		this.tipoRecepcionId = tipoRecepcionId;
		this.origenId = origenId;
		this.idPadre = idPadre;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
	}

	private ArchivoRegistradoDomainEvent(BuilderArchivoRegistradoDomainEvent builder) {
		super(builder.id);
		this.tipoRecepcionId = builder.tipoRecepcionId;
		this.origenId = builder.origenId;
		this.idPadre = builder.idPadre;
		this.usuarioRegistro = builder.usuarioRegistro;
		this.fechaRegistro = builder.fechaRegistro;
		this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
		this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
		this.estadoId = builder.estadoId;
	}

	public ArchivoRegistradoDomainEvent(String aggregateId, String eventId, String occurredOn, String tipoRecepcionId,
			String origenId, String idPadre, Long usuarioRegistro, LocalDateTime fechaRegistro,
			Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId) {
		super(aggregateId, eventId, occurredOn);
		this.tipoRecepcionId = tipoRecepcionId;
		this.origenId = origenId;
		this.idPadre = idPadre;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
	}

	public ArchivoRegistradoDomainEvent(String aggregateId, String eventId, String occurredOn,
			BuilderArchivoRegistradoDomainEvent builder) {
		super(aggregateId, eventId, occurredOn);
		this.tipoRecepcionId = builder.tipoRecepcionId;
		this.origenId = builder.origenId;
		this.idPadre = builder.idPadre;
		this.usuarioRegistro = builder.usuarioRegistro;
		this.fechaRegistro = builder.fechaRegistro;
		this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
		this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
		this.estadoId = builder.estadoId;
	}

	public ArchivoRegistradoDomainEvent() {
		this.tipoRecepcionId = null;
		this.origenId = null;
		this.idPadre = null;
		this.usuarioRegistro = null;
		this.fechaRegistro = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
		this.estadoId = null;
	}

	@Override
	public String eventName() {
		// TODO Auto-generated method stub
		return "procesar_archivo_ventas";
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
			String occurredOn) {
		BuilderArchivoRegistradoDomainEvent builder = new BuilderArchivoRegistradoDomainEvent().id(aggregateId)
				.origenId((String) body.get("origenId")).tipoRecepcionId((String) body.get("tipoRecepcionId"))
				.idPadre((String) body.get("idPadre"))
				.usuarioRegistro(Long.parseLong(body.get("usuarioRegistro").toString()))
				.fechaRegistro(LocalDateTime.now())
				.usuarioUltimaModificacion(Long.parseLong(body.get("usuarioUltimaModificacion").toString()))
				.fechaUltimaModificacion(LocalDateTime.now()).estadoId((String) body.get("estadoId"));
		return new ArchivoRegistradoDomainEvent(aggregateId, eventId, occurredOn, builder);
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

	public class BuilderArchivoRegistradoDomainEvent {
		private String id;
		private String tipoRecepcionId;
		private String origenId;
		private String idPadre;
		private Long usuarioRegistro;
		private LocalDateTime fechaRegistro;
		private Long usuarioUltimaModificacion;
		private LocalDateTime fechaUltimaModificacion;
		private String estadoId;

		public BuilderArchivoRegistradoDomainEvent id(String id) {
			this.id = id;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent tipoRecepcionId(String tipoRecepcionId) {
			this.tipoRecepcionId = tipoRecepcionId;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent idPadre(String idPadre) {
			this.idPadre = idPadre;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public BuilderArchivoRegistradoDomainEvent estadoId(String estadoId) {
			this.estadoId = estadoId;
			return this;
		}

	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {
			{
				put("tipoRecepcionId", tipoRecepcionId());
				put("origenId", origenId());
				put("idPadre", idPadre());
				put("usuarioRegistro", usuarioRegistro());
				put("fechaRegistro", fechaRegistro());
				put("usuarioUltimaModificacion", usuarioUltimaModificacion());
				put("fechaUltimaModificacion", fechaUltimaModificacion());
				put("estadoId", estadoId());
			}
		};
	}

}
