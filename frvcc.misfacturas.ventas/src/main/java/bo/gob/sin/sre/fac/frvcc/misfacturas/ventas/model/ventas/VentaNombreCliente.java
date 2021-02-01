package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public class VentaNombreCliente extends StringValueObject {
	public VentaNombreCliente(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaNombreCliente() {
		super("");
	}

}
