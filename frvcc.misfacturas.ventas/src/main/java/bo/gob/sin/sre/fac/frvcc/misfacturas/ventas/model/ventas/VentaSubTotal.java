package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class VentaSubTotal extends BigDecimalValueObject {
	public VentaSubTotal(BigDecimal value) {
		super(value);
	}

	public static VentaSubTotal subTotal(BigDecimal pImporteTotalCompra, BigDecimal pImporteNoSujetoCf) {

		BigDecimal subTotal = pImporteTotalCompra.subtract(pImporteNoSujetoCf);
		return new VentaSubTotal(subTotal);
	}

	public VentaSubTotal() {
		super(null);
	}
}
