package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class VentaFormularioId extends StringValueObject {
	public VentaFormularioId(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaFormularioId() {
		super("");
	}
}
