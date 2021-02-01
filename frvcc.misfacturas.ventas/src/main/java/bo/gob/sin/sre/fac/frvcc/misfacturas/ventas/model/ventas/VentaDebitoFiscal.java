package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public final class VentaDebitoFiscal extends BigDecimalValueObject {
	public VentaDebitoFiscal(BigDecimal value) {
		super(value);
	}

	public VentaDebitoFiscal() {
		super(null);
	}
}
