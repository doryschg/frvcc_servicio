package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado;

import java.math.BigDecimal;
import java.time.LocalDate;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RegistroVentasAgrupadoCommand implements Command {
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

	private RegistroVentasAgrupadoCommand(Builder builder) {
		this.fila = builder.fila;
		this.id = builder.id;
		this.recepcionId = builder.recepcionId;
		this.ifcProveedor = builder.ifcProveedor;
		this.nitProveedor = builder.nitProveedor;
		this.codigoAutorizacion = builder.codigoAutorizacion;
		this.importeTotalVenta = builder.importeTotalVenta;
		this.fechaFactura = builder.fechaFactura;

		this.numeroFacturaDel = builder.numeroFacturaDel;
		this.numeroFacturaHasta = builder.numeroFacturaHasta;

		this.origenId = builder.origenId;
		this.usuarioRegistro = builder.usuarioRegistro;
	}

	public String getId() {
		return id;
	}

	public String getRecepcionId() {
		return recepcionId;
	}

	public Long getIfcProveedor() {
		return ifcProveedor;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public LocalDate getFechaFactura() {
		return fechaFactura;
	}

	public BigDecimal getImporteTotalVenta() {
		return importeTotalVenta;
	}

	public String getOrigenId() {
		return origenId;
	}

	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public static Builder newRegistroVentaCommand() {
		return new Builder();
	}

	public Long getFila() {
		return fila;
	}

	public Long getNumeroFacturaDel() {
		return numeroFacturaDel;
	}

	public Long getNumeroFacturaHasta() {
		return numeroFacturaHasta;
	}

	public static final class Builder {
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

		private Builder() {
		}

		public RegistroVentasAgrupadoCommand build() {
			return new RegistroVentasAgrupadoCommand(this);
		}

		public Builder fila(Long fila) {
			this.fila = fila;
			return this;
		}

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder ifcProveedor(Long ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
			return this;
		}

		public Builder fechaFactura(LocalDate fechaFactura) {
			this.fechaFactura = fechaFactura;
			return this;
		}

		public Builder nitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
			return this;
		}

		public Builder numeroFacturaDel(Long numeroFacturaDel) {
			this.numeroFacturaDel = numeroFacturaDel;
			return this;
		}

		public Builder numeroFacturaHasta(Long numeroFacturaHasta) {
			this.numeroFacturaHasta = numeroFacturaHasta;
			return this;
		}

		public Builder codigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			return this;
		}

		public Builder importeTotalVenta(BigDecimal importeTotalVenta) {
			this.importeTotalVenta = importeTotalVenta;
			return this;
		}

		public Builder usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public Builder recepcionId(String recepcionId) {
			this.recepcionId = recepcionId;
			return this;
		}
	}

}
