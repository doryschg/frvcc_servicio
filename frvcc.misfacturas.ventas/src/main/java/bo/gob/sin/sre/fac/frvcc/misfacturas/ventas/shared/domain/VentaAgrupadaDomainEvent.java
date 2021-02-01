package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class VentaAgrupadaDomainEvent extends DomainEvent {
	private final Long fila;
	private final String id;
	private final String recepcionId;
	private final Long ifcProveedor;
	private final Long nitProveedor;

	private final LocalDate fechaFactura;
	private final Long numeroFacturaDel;
	private final Long numeroFacturaHasta;
	private final String codigoAutorizacion;
	private final BigDecimal importeTotalVenta;

	private final String origenId;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;
	private final Long usuarioUltimaModificacion;
	private final LocalDateTime fechaUltimaModificacion;
	private final String estadoVentaId;

	public VentaAgrupadaDomainEvent(String aggregateId, String eventId, String occurredOn, Long fila, String id,
			String recepcionId, Long ifcProveedor, Long nitProveedor, LocalDate fechaFactura, Long numeroFacturaDel,
			Long numeroFacturaHasta, String codigoAutorizacion, BigDecimal importeTotalVenta, String origenId,
			Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
			LocalDateTime fechaUltimaModificacion, String estadoVentaId) {
		super(aggregateId, eventId, occurredOn);
		this.fila = fila;
		this.id = id;
		this.recepcionId = recepcionId;
		this.ifcProveedor = ifcProveedor;
		this.nitProveedor = nitProveedor;
		this.fechaFactura = fechaFactura;
		this.numeroFacturaDel = numeroFacturaDel;
		this.numeroFacturaHasta = numeroFacturaHasta;
		this.codigoAutorizacion = codigoAutorizacion;
		this.importeTotalVenta = importeTotalVenta;
		this.origenId = origenId;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoVentaId = estadoVentaId;
	}

	public VentaAgrupadaDomainEvent() {
		this.fila = null;
		this.id = null;
		this.recepcionId = null;
		this.ifcProveedor = null;
		this.nitProveedor = null;
		this.fechaFactura = null;
		this.numeroFacturaDel = null;
		this.numeroFacturaHasta = null;
		this.codigoAutorizacion = null;
		this.importeTotalVenta = null;
		this.origenId = null;
		this.usuarioRegistro = null;
		this.fechaRegistro = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
		this.estadoVentaId = null;
	}

	public VentaAgrupadaDomainEvent(String aggregateId, Long fila, String id, String recepcionId, Long ifcProveedor,
			Long nitProveedor, LocalDate fechaFactura, Long numeroFacturaDel, Long numeroFacturaHasta,
			String codigoAutorizacion, BigDecimal importeTotalVenta, String origenId, Long usuarioRegistro,
			LocalDateTime fechaRegistro, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion,
			String estadoVentaId) {
		super(aggregateId);
		this.fila = fila;
		this.id = id;
		this.recepcionId = recepcionId;
		this.ifcProveedor = ifcProveedor;
		this.nitProveedor = nitProveedor;
		this.fechaFactura = fechaFactura;
		this.numeroFacturaDel = numeroFacturaDel;
		this.numeroFacturaHasta = numeroFacturaHasta;
		this.codigoAutorizacion = codigoAutorizacion;
		this.importeTotalVenta = importeTotalVenta;
		this.origenId = origenId;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoVentaId = estadoVentaId;
	}

	@Override
	public String eventName() {
		return "registar_venta_agrupada";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return new HashMap<String, Serializable>() {
			{
				put("recepcionId", recepcionId());
				put("ifcProveedor", ifcProveedor());
				put("nitProveedor", nitProveedor());
				put("fechaFactura", fechaFactura());
				put("usuarioRegistro", usuarioRegistro());
				put("numeroFacturaDel", numeroFacturaDel());
				put("numeroFacturaHasta", numeroFacturaHasta());
				put("importeTotalVenta", importeTotalVenta());
				put("id", id());
				put("estadoVentaId", estadoVentaId());
				put("fila", fila());
				put("codigoAutorizacion", codigoAutorizacion());
				put("usuarioUltimaModificacion", usuarioUltimaModificacion());
				put("origenId", origenId());
			}
		};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
			String occurredOn) throws IOException {
		return new VentaAgrupadaDomainEvent(aggregateId, eventId, occurredOn,
				Long.parseLong(body.get("fila").toString()), (String) body.get("id"), (String) body.get("recepcionId"),
				Long.parseLong(body.get("ifcProveedor").toString()),
				Long.parseLong(body.get("nitProveedor").toString()), LocalDate.now(),
				Long.parseLong(body.get("numeroFacturaDel").toString()),
				Long.parseLong(body.get("numeroFacturaHasta").toString()), (String) body.get("codigoAutorizacion"),
				new BigDecimal(body.get("importeTotalVenta").toString()), (String) body.get("origenId"),
				Long.parseLong(body.get("usuarioRegistro").toString()), LocalDateTime.now(),
				Long.parseLong(body.get("usuarioUltimaModificacion").toString()), LocalDateTime.now(),
				(String) body.get("estadoVentaId"));
	}

	public Long fila() {
		return fila;
	}

	public String id() {
		return id;
	}

	public String recepcionId() {
		return recepcionId;
	}

	public Long ifcProveedor() {
		return ifcProveedor;
	}

	public Long nitProveedor() {
		return nitProveedor;
	}

	public LocalDate fechaFactura() {
		return fechaFactura;
	}

	public Long numeroFacturaDel() {
		return numeroFacturaDel;
	}

	public Long numeroFacturaHasta() {
		return numeroFacturaHasta;
	}

	public String codigoAutorizacion() {
		return codigoAutorizacion;
	}

	public BigDecimal importeTotalVenta() {
		return importeTotalVenta;
	}

	public String origenId() {
		return origenId;
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

	public String estadoVentaId() {
		return estadoVentaId;
	}

	public class BuilderVentaAgrupadaDomainEvent {
		private Long fila;
		private String id;
		private String recepcionId;
		private Long ifcProveedor;
		private Long nitProveedor;

		private LocalDate fechaFactura;
		private Long numeroFacturaDel;
		private Long numeroFacturaHasta;
		private String codigoAutorizacion;
		private BigDecimal importeTotalVenta;

		private String origenId;
		private Long usuarioRegistro;
		private LocalDateTime fechaRegistro;
		private Long usuarioUltimaModificacion;
		private LocalDateTime fechaUltimaModificacion;
		private String estadoVentaId;

		public BuilderVentaAgrupadaDomainEvent fila(Long fila) {
			this.fila = fila;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent id(String id) {
			this.id = id;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent recepcionId(String recepcionId) {
			this.recepcionId = recepcionId;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent fechaFactura(LocalDate fechaFactura) {
			this.fechaFactura = fechaFactura;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent ifcProveedor(Long ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent nitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent codigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent numeroFacturaHasta(Long numeroFacturaHasta) {
			this.numeroFacturaHasta = numeroFacturaHasta;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent numeroFacturaDel(Long numeroFacturaDel) {
			this.numeroFacturaDel = numeroFacturaDel;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent importeTotalVenta(BigDecimal importeTotalVenta) {
			this.importeTotalVenta = importeTotalVenta;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public BuilderVentaAgrupadaDomainEvent estadoVentaId(String estadoVentaId) {
			this.estadoVentaId = estadoVentaId;
			return this;
		}
	}

}
