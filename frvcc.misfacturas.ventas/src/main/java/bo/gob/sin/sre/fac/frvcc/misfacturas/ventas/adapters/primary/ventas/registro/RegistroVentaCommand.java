package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro;

import java.math.BigDecimal;
import java.time.LocalDate;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RegistroVentaCommand implements Command {
	private final Long fila;
	private final String id;
	private final String recepcionId;
	private final Long ifcProveedor;
	private final Long nitProveedor;
	private final String razonSocialProveedor;
	private final String numeroDocumentoCliente;
	private final String tipoDocumentoCliente;
	private final String nombreCliente;

	private final Long numeroFactura;
	private final String codigoAutorizacion;
	private final LocalDate fechaFactura;
	private final BigDecimal importeTotalVenta;
	private final BigDecimal importeBase;
	private final String codigoControl;
	private final String origenId;
	private final Long usuarioRegistro;

	private final String conDerechoDf;
	private final String marcaEspecialId;
	private final BigDecimal descuento;
	private final BigDecimal debitoFiscal;
	private final BigDecimal importeIceIehdTasas;
	private final BigDecimal importeTasaCero;
	private final BigDecimal importeNoSujetoDf;
	private final BigDecimal importeExento;
	private final BigDecimal subTotal;

	private RegistroVentaCommand(Builder builder) {
		this.fila = builder.fila;
		this.id = builder.id;
		this.recepcionId = builder.recepcionId;
		this.ifcProveedor = builder.ifcProveedor;
		this.nitProveedor = builder.nitProveedor;
		this.razonSocialProveedor = builder.razonSocialProveedor;
		this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
		this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
		this.nombreCliente = builder.nombreCliente;
		this.numeroFactura = builder.numeroFactura;
		this.codigoAutorizacion = builder.codigoAutorizacion;
		this.fechaFactura = builder.fechaFactura;
		this.importeTotalVenta = builder.importeTotalVenta;
		this.importeBase = builder.importeBase;
		this.codigoControl = builder.codigoControl;
		this.origenId = builder.origenId;
		this.usuarioRegistro = builder.usuarioRegistro;

		this.conDerechoDf = builder.conDerechoDf;
		this.marcaEspecialId = builder.marcaEspecialId;
		this.descuento = builder.descuento;
		this.debitoFiscal = builder.debitoFiscal;
		this.importeIceIehdTasas = builder.importeIceIehdTasas;
		this.importeTasaCero = builder.importeTasaCero;
		this.importeNoSujetoDf = builder.importeNoSujetoDf;
		this.importeExento = builder.importeExento;
		this.subTotal = builder.subTotal;
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

	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	public String getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public Long getNumeroFactura() {
		return numeroFactura;
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

	public String getCodigoControl() {
		return codigoControl;
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

	public BigDecimal getImporteBase() {
		return importeBase;
	}

	public String getTipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}

	public String getConDerechoDf() {
		return conDerechoDf;
	}

	public String getMarcaEspecialId() {
		return marcaEspecialId;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public BigDecimal getImporteIceIehdTasas() {
		return importeIceIehdTasas;
	}

	public BigDecimal getImporteTasaCero() {
		return importeTasaCero;
	}

	public BigDecimal getImporteNoSujetoDf() {
		return importeNoSujetoDf;
	}

	public BigDecimal getImporteExento() {
		return importeExento;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public BigDecimal getDebitoFiscal() {
		return debitoFiscal;
	}

	public Long getFila() {
		return fila;
	}

	public static final class Builder {
		private Long fila;
		private String id;
		private String recepcionId;
		private LocalDate fechaFactura;
		private Long nitProveedor;
		private Long ifcProveedor;
		private String razonSocialProveedor;
		private Long numeroFactura;
		private String codigoAutorizacion;
		private String codigoControl;
		private Long usuarioRegistro;
		private String nombreCliente;
		private String numeroDocumentoCliente;
		private String tipoDocumentoCliente;
		private String origenId;
		private BigDecimal importeTotalVenta;
		private BigDecimal importeBase;

		private String conDerechoDf;
		private String marcaEspecialId;
		private BigDecimal descuento;
		private BigDecimal debitoFiscal;
		private BigDecimal importeIceIehdTasas;
		private BigDecimal importeTasaCero;
		private BigDecimal importeNoSujetoDf;
		private BigDecimal importeExento;
		private BigDecimal subTotal;

		private Builder() {
		}

		public RegistroVentaCommand build() {
			return new RegistroVentaCommand(this);
		}

		public Builder fila(Long fila) {
			this.fila = fila;
			return this;
		}

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder conDerechoDf(String conDerechoDf) {
			this.conDerechoDf = conDerechoDf;
			return this;
		}

		public Builder marcaEspecialId(String marcaEspecialId) {
			this.marcaEspecialId = marcaEspecialId;
			return this;
		}

		public Builder descuento(BigDecimal descuento) {
			this.descuento = descuento;
			return this;
		}

		public Builder debitoFiscal(BigDecimal debitoFiscal) {
			this.debitoFiscal = debitoFiscal;
			return this;
		}

		public Builder importeIceIehdTasas(BigDecimal importeIceIehdTasas) {
			this.importeIceIehdTasas = importeIceIehdTasas;
			return this;
		}

		public Builder importeTasaCero(BigDecimal importeTasaCero) {
			this.importeTasaCero = importeTasaCero;
			return this;
		}

		public Builder importeExento(BigDecimal importeExento) {
			this.importeExento = importeExento;
			return this;
		}

		public Builder importeNoSujetoDf(BigDecimal importeNoSujetoDf) {
			this.importeNoSujetoDf = importeNoSujetoDf;
			return this;
		}

		public Builder subTotal(BigDecimal subTotal) {
			this.subTotal = subTotal;
			return this;
		}

		public Builder ifcProveedor(Long ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
			return this;
		}

		public Builder razonSocialProveedor(String razonSocialProveedor) {
			this.razonSocialProveedor = razonSocialProveedor;
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

		public Builder numeroFactura(Long numeroFactura) {
			this.numeroFactura = numeroFactura;
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

		public Builder importeBase(BigDecimal importeBase) {
			this.importeBase = importeBase;
			return this;
		}

		public Builder codigoControl(String codigoControl) {
			this.codigoControl = codigoControl;
			return this;
		}

		public Builder usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder nombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
			return this;
		}

		public Builder numeroDocumentoCliente(String numeroDocumentoCliente) {
			this.numeroDocumentoCliente = numeroDocumentoCliente;
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
