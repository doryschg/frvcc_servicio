package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

public final class VentaResponse implements Response {
	private final String id;
	private final String recepcionId;
	private final Long secuencia;
	private final Long ifcProveedor;
	private final Long nitProveedor;
	private final String razonSocialProveedor;
	private final String numeroDocumentoCliente;
	private final String nombreCliente;
	private final Long numeroFactura;
	private final String codigoAutorizacion;
	private final LocalDate fechaFactura;
	private final BigDecimal importeTotalVenta;
	private final BigDecimal importeIceIehdTasas;
	private final BigDecimal importeExtento;
	private final BigDecimal importeTasaCero;
	private final BigDecimal subTotal;
	private final BigDecimal descuento;
	private final BigDecimal importeBaseDf;
	private final BigDecimal debitoFiscal;
	private final String codigoControl;
	private final String origenId;
	private final String estadoVentaId;
	private final String estadoUsoId;
	private final String impuestoUsoId;
	private final Integer periodoUso;
	private final String nombreArchivo;
	private final String formularioId;
	private final Long usuarioRegistro;
	private final LocalDateTime fechaRegistro;
	private final Long usuarioUltimaModificacion;
	private final LocalDateTime fechaUltimaModificacion;
	private final String estadoId;

	public VentaResponse(String id, String recepcionId, Long secuencia, Long ifcProveedor, Long nitProveedor,
			String razonSocialProveedor, String numeroDocumentoCliente, String nombreCliente, Long numeroFactura,
			String codigoAutorizacion, LocalDate fechaFactura, BigDecimal importeTotalVenta,
			BigDecimal importeIceIehdTasas, BigDecimal importeExtento, BigDecimal importeTasaCero, BigDecimal subTotal,
			BigDecimal descuento, BigDecimal importeBaseDf, BigDecimal debitoFiscal, String codigoControl,
			String origenId, String estadoVentaId, String estadoUsoId, String impuestoUsoId, Integer periodoUso,
			String nombreArchivo, String formularioId, Long usuarioRegistro, LocalDateTime fechaRegistro,
			Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId) {
		this.id = id;
		this.recepcionId = recepcionId;
		this.secuencia = secuencia;
		this.ifcProveedor = ifcProveedor;
		this.nitProveedor = nitProveedor;
		this.razonSocialProveedor = razonSocialProveedor;
		this.numeroDocumentoCliente = numeroDocumentoCliente;
		this.nombreCliente = nombreCliente;
		this.numeroFactura = numeroFactura;
		this.codigoAutorizacion = codigoAutorizacion;
		this.fechaFactura = fechaFactura;
		this.importeTotalVenta = importeTotalVenta;
		this.importeIceIehdTasas = importeIceIehdTasas;
		this.importeExtento = importeExtento;
		this.importeTasaCero = importeTasaCero;
		this.subTotal = subTotal;
		this.descuento = descuento;
		this.importeBaseDf = importeBaseDf;
		this.debitoFiscal = debitoFiscal;
		this.codigoControl = codigoControl;
		this.origenId = origenId;
		this.estadoVentaId = estadoVentaId;
		this.estadoUsoId = estadoUsoId;
		this.impuestoUsoId = impuestoUsoId;
		this.periodoUso = periodoUso;
		this.nombreArchivo = nombreArchivo;
		this.formularioId = formularioId;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
	}

	public String id() {
		return id;
	}

	public String recepcionId() {
		return recepcionId;
	}

	public Long secuencia() {
		return secuencia;
	}

	public Long ifcProveedor() {
		return ifcProveedor;
	}

	public Long nitProveedor() {
		return nitProveedor;
	}

	public String razonSocialProveedor() {
		return razonSocialProveedor;
	}

	public String numeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public String nombreCliente() {
		return nombreCliente;
	}

	public Long numeroFactura() {
		return numeroFactura;
	}

	public String codigoAutorizacion() {
		return codigoAutorizacion;
	}

	public LocalDate fechaFactura() {
		return fechaFactura;
	}

	public BigDecimal importeTotalVenta() {
		return importeTotalVenta;
	}

	public BigDecimal importeIceIehdTasas() {
		return importeIceIehdTasas;
	}

	public BigDecimal importeExtento() {
		return importeExtento;
	}

	public BigDecimal importeTasaCero() {
		return importeTasaCero;
	}

	public BigDecimal subTotal() {
		return subTotal;
	}

	public BigDecimal descuento() {
		return descuento;
	}

	public BigDecimal importeBaseDf() {
		return importeBaseDf;
	}

	public BigDecimal debitoFiscal() {
		return debitoFiscal;
	}

	public String codigoControl() {
		return codigoControl;
	}

	public String origenId() {
		return origenId;
	}

	public String estadoVentaId() {
		return estadoVentaId;
	}

	public String estadoUsoId() {
		return estadoUsoId;
	}

	public String impuestoUsoId() {
		return impuestoUsoId;
	}

	public Integer periodoUso() {
		return periodoUso;
	}

	public String nombreArchivo() {
		return nombreArchivo;
	}

	public String formularioId() {
		return formularioId;
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

	public static VentaResponse fromAggregate(Venta venta) {
		return new VentaResponse(venta.id() != null ? venta.id().value() : null,
				venta.recepcionId() != null ? venta.recepcionId().value() : null,
				venta.secuencia() != null ? venta.secuencia().value() : null,
				venta.ifcProveedor() != null ? venta.ifcProveedor().value() : null,
				venta.nitProveedor() != null ? venta.nitProveedor().value() : null,
				venta.razonSocialProveedor() != null ? venta.razonSocialProveedor().value() : null,
				venta.numeroDocumentoCliente() != null ? venta.numeroDocumentoCliente().value() : null,
				venta.nombreCliente() != null ? venta.nombreCliente().value() : null,
				venta.numeroFactura() != null ? venta.numeroFactura().value() : null,
				venta.codigoAutorizacion() != null ? venta.codigoAutorizacion().value() : null,
				venta.fechaFactura() != null ? venta.fechaFactura().value() : null,
				venta.importeTotal() != null ? venta.importeTotal().value() : null,
				venta.importeIceIehdTasas() != null ? venta.importeIceIehdTasas().value() : null,
				venta.importeExento() != null ? venta.importeExento().value() : null,
				venta.importeTasaCero() != null ? venta.importeTasaCero().value() : null,
				venta.subtotal() != null ? venta.subtotal().value() : null,
				venta.descuento() != null ? venta.descuento().value() : null,
				venta.importeBase() != null ? venta.importeBase().value() : null,
				venta.debitoFiscal() != null ? venta.debitoFiscal().value() : null,
				venta.codigoControl() != null ? venta.codigoControl().value() : null,
				venta.origenId() != null ? venta.origenId().value() : null,
				venta.estadoVentaId() != null ? venta.estadoVentaId().value() : null,
				venta.estadoUsoId() != null ? venta.estadoUsoId().value() : null,
				venta.impuestoUsoId() != null ? venta.impuestoUsoId().value() : null,
				venta.periodoUso() != null ? venta.periodoUso().value() : null,
				venta.nombreArchivoUso() != null ? venta.nombreArchivoUso().value() : null,
				venta.formularioId() != null ? venta.formularioId().value() : null,
				venta.usuarioRegistro() != null ? venta.usuarioRegistro().value() : null,
				venta.fechaRegistro() != null ? venta.fechaRegistro().value() : null,
				venta.usuarioUltimaModificacion() != null ? venta.usuarioUltimaModificacion().value() : null,
				venta.fechaUltimaModificacion() != null ? venta.fechaUltimaModificacion().value() : null,
				venta.estadoId() != null ? venta.estadoId().value() : null);
	}
}
