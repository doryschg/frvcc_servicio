package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class VentaCodigoControl extends StringValueObject {
	public VentaCodigoControl(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaCodigoControl() {
		super("");
	}
}
