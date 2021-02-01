package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.reporte;

import java.io.Serializable;
import java.util.List;

public class ParametrosReporte implements Serializable {

	public List<CompraReporte> facturasConDerechoCf;
	public List<CompraReporte> facturas7g;
	
	public List<CompraReporte> getFacturasConDerechoCf() {
		return facturasConDerechoCf;
	}
	public List<CompraReporte> getFacturas7g() {
		return facturas7g;
	}
	public void setFacturasConDerechoCf(List<CompraReporte> facturasConDerechoCf) {
		this.facturasConDerechoCf = facturasConDerechoCf;
	}
	public void setFacturas7g(List<CompraReporte> facturas7g) {
		this.facturas7g = facturas7g;
	}
	
}
