package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;

public class VentaResponseGenerico implements Serializable, Cloneable {
	private String id;
	private String recepcionId;
	private Long secuencia;
	private Long ifcProveedor;
	private Long nitProveedor;
	private String razonSocialProveedor;
	private String numeroDocumentoCliente;
	private String nombreCliente;
	private Long numeroFactura;
	private String codigoAutorizacion;
	private String modalidadId;
	private LocalDate fechaFactura;
	private BigDecimal importeTotalVenta;
	private BigDecimal importeIceIehdTasas;
	private BigDecimal importeExtento;
	private BigDecimal importeTasaCero;
	private BigDecimal subTotal;
	private BigDecimal descuento;
	private BigDecimal importeBaseDf;
	private BigDecimal debitoFiscal;
	private String codigoControl;
	private String origenId;
	private String estadoVentaId;
	private String estadoUsoId;
	private String impuestoUsoId;
	private Integer periodoUso;
	private String nombreArchivo;
	private String formularioId;
	private Long usuarioRegistro;
	private LocalDateTime fechaRegistro;
	private Long usuarioUltimaModificacion;
	private LocalDateTime fechaUltimaModificacion;
	private String estadoId;

	public static VentaResponseGenerico fromAggregate(Venta venta) {
		VentaResponseGenerico ventaResponseGenerico = new VentaResponseGenerico(
				venta.id() != null ? venta.id().value() : null,
				venta.recepcionId() != null ? venta.recepcionId().value() : null,
				venta.secuencia() != null ? venta.secuencia().value() : null,
				venta.ifcProveedor() != null ? venta.ifcProveedor().value() : null,
				venta.nitProveedor() != null ? venta.nitProveedor().value() : null,
				venta.razonSocialProveedor() != null ? venta.razonSocialProveedor().value() : null,
				venta.numeroDocumentoCliente() != null ? venta.numeroDocumentoCliente().value() : null,
				venta.nombreCliente() != null ? venta.nombreCliente().value() : null,
				venta.numeroFactura() != null ? venta.numeroFactura().value() : null,
				venta.codigoAutorizacion() != null ? venta.codigoAutorizacion().value() : null,
				venta.modalidadId() != null ? venta.modalidadId().value() : null,
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
		return ventaResponseGenerico;
	}

	
	public VentaResponseGenerico() {
		this.id = null;
		this.recepcionId = null;
		this.secuencia = null;
		this.ifcProveedor = null;
		this.nitProveedor = null;
		this.razonSocialProveedor = null;
		this.numeroDocumentoCliente = null;
		this.nombreCliente = null;
		this.numeroFactura = null;
		this.codigoAutorizacion = null;
		this.fechaFactura = null;
		this.importeTotalVenta = null;
		this.importeIceIehdTasas = null;
		this.importeExtento = null;
		this.importeTasaCero = null;
		this.subTotal = null;
		this.descuento = null;
		this.importeBaseDf = null;
		this.debitoFiscal = null;
		this.codigoControl = null;
		this.origenId = null;
		this.estadoVentaId = null;
		this.estadoUsoId = null;
		this.impuestoUsoId = null;
		this.periodoUso = null;
		this.nombreArchivo = null;
		this.formularioId = null;
		this.usuarioRegistro = null;
		this.fechaRegistro = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
		this.estadoId = null;
		this.modalidadId = null;
	}


	public VentaResponseGenerico(String id, String recepcionId, Long secuencia, Long ifcProveedor, Long nitProveedor,
			String razonSocialProveedor, String numeroDocumentoCliente, String nombreCliente, Long numeroFactura,
			String codigoAutorizacion, String modalidadId, LocalDate fechaFactura, BigDecimal importeTotalVenta,
			BigDecimal importeIceIehdTasas, BigDecimal importeExtento, BigDecimal importeTasaCero, BigDecimal subTotal,
			BigDecimal descuento, BigDecimal importeBaseDf, BigDecimal debitoFiscal, String codigoControl,
			String origenId, String estadoVentaId, String estadoUsoId, String impuestoUsoId, Integer periodoUso,
			String nombreArchivo, String formularioId, Long usuarioRegistro, LocalDateTime fechaRegistro,
			Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId) {
		super();
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
		this.modalidadId = modalidadId;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecepcionId() {
		return recepcionId;
	}

	public void setRecepcionId(String recepcionId) {
		this.recepcionId = recepcionId;
	}

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	//public Long getIfcProveedor() {
	//	return ifcProveedor;
	//}

	public void setIfcProveedor(Long ifcProveedor) {
		this.ifcProveedor = ifcProveedor;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}

	public String getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
		this.numeroDocumentoCliente = numeroDocumentoCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Long getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public LocalDate getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getImporteTotalVenta() {
		return importeTotalVenta;
	}

	public void setImporteTotalVenta(BigDecimal importeTotalVenta) {
		this.importeTotalVenta = importeTotalVenta;
	}

	public BigDecimal getImporteIceIehdTasas() {
		return importeIceIehdTasas;
	}

	public void setImporteIceIehdTasas(BigDecimal importeIceIehdTasas) {
		this.importeIceIehdTasas = importeIceIehdTasas;
	}

	public BigDecimal getImporteExtento() {
		return importeExtento;
	}

	public void setImporteExtento(BigDecimal importeExtento) {
		this.importeExtento = importeExtento;
	}

	public BigDecimal getImporteTasaCero() {
		return importeTasaCero;
	}

	public void setImporteTasaCero(BigDecimal importeTasaCero) {
		this.importeTasaCero = importeTasaCero;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getImporteBaseDf() {
		return importeBaseDf;
	}

	public void setImporteBaseDf(BigDecimal importeBaseDf) {
		this.importeBaseDf = importeBaseDf;
	}

	public BigDecimal getDebitoFiscal() {
		return debitoFiscal;
	}

	public void setDebitoFiscal(BigDecimal debitoFiscal) {
		this.debitoFiscal = debitoFiscal;
	}

	public String getCodigoControl() {
		return codigoControl;
	}

	public void setCodigoControl(String codigoControl) {
		this.codigoControl = codigoControl;
	}

	public String getOrigenId() {
		return origenId;
	}

	public void setOrigenId(String origenId) {
		this.origenId = origenId;
	}

	public String getEstadoVentaId() {
		return estadoVentaId;
	}

	public void setEstadoVentaId(String estadoVentaId) {
		this.estadoVentaId = estadoVentaId;
	}

	public String getEstadoUsoId() {
		return estadoUsoId;
	}

	public void setEstadoUsoId(String estadoUsoId) {
		this.estadoUsoId = estadoUsoId;
	}

	public String getImpuestoUsoId() {
		return impuestoUsoId;
	}

	public void setImpuestoUsoId(String impuestoUsoId) {
		this.impuestoUsoId = impuestoUsoId;
	}

	public Integer getPeriodoUso() {
		return periodoUso;
	}

	public void setPeriodoUso(Integer periodoUso) {
		this.periodoUso = periodoUso;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getFormularioId() {
		return formularioId;
	}

	public void setFormularioId(String formularioId) {
		this.formularioId = formularioId;
	}

	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(Long usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public void setUsuarioUltimaModificacion(Long usuarioUltimaModificacion) {
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getModalidadId() {
		return modalidadId;
	}

	public void setModalidadId(String modalidadId) {
		this.modalidadId = modalidadId;
	}

}
