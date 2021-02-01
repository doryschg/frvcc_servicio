package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public class VentaConDerechoDf  extends StringValueObject {
	public VentaConDerechoDf(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaConDerechoDf() {
		super("");
	}
}