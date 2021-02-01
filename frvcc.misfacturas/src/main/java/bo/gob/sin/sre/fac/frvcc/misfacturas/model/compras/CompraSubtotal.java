package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class CompraSubtotal extends BigDecimalValueObject {
    public CompraSubtotal(BigDecimal value) {
        super(value);
    }

	public static CompraSubtotal subTotal(BigDecimal pImporteTotalCompra, BigDecimal pImporteNoSujetoCf) {

		BigDecimal subTotal = pImporteTotalCompra.subtract(pImporteNoSujetoCf);
		return new CompraSubtotal(subTotal);
	}
    public CompraSubtotal() {
        super(null);
    }
}
