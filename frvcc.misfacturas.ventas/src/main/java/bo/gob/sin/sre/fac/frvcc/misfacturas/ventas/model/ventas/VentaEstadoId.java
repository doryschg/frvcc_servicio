package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

final public class VentaEstadoId extends StringValueObject {
	public VentaEstadoId(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaEstadoId() {
		super("");
	}
}
