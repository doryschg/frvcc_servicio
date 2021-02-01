package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class VentaRazonSocialProveedor extends StringValueObject {
	public VentaRazonSocialProveedor(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaRazonSocialProveedor() {
		super("");
	}
}
