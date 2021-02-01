package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompraReporte implements Serializable {

	private static final long serialVersionUID = -6388175730406017184L;
	private String codigoControl;
	private String codigoAutorizacion;
	private Long nitProveedor;
	private String fechaFacturaCadena;
	private Long numeroFactura;
	private BigDecimal importeTotalCompra;
	private String marcaEspecialId;
	public String getCodigoControl() {
		return codigoControl;
	}
	

	public CompraReporte(String codigoControl, String codigoAutorizacion, Long nitProveedor, String fechaFacturaCadena,
			Long numeroFactura, BigDecimal importeTotalCompra, String marcaEspecialId) {
		this.codigoControl = codigoControl;
		this.codigoAutorizacion = codigoAutorizacion;
		this.nitProveedor = nitProveedor;
		this.fechaFacturaCadena = fechaFacturaCadena;
		this.numeroFactura = numeroFactura;
		this.importeTotalCompra = importeTotalCompra;
		this.marcaEspecialId = marcaEspecialId;
	}



	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public Long getNitProveedor() {
		return nitProveedor;
	}
	public String getFechaFacturaCadena() {
		return fechaFacturaCadena;
	}
	public Long getNumeroFactura() {
		return numeroFactura;
	}
	public BigDecimal getImporteTotalCompra() {
		return importeTotalCompra;
	}
	public String getMarcaEspecialId() {
		return marcaEspecialId;
	}
	public void setCodigoControl(String codigoControl) {
		this.codigoControl = codigoControl;
	}
	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public void setFechaFacturaCadena(String fechaFacturaCadena) {
		this.fechaFacturaCadena = fechaFacturaCadena;
	}
	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public void setImporteTotalCompra(BigDecimal importeTotalCompra) {
		this.importeTotalCompra = importeTotalCompra;
	}
	public void setMarcaEspecialId(String marcaEspecialId) {
		this.marcaEspecialId = marcaEspecialId;
	}
	
	
}
