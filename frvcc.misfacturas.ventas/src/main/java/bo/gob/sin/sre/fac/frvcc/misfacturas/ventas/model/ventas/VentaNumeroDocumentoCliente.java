package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class VentaNumeroDocumentoCliente extends StringValueObject {
	public VentaNumeroDocumentoCliente(String value) {
		super(value == null ? null : value.strip().toUpperCase());
	}

	public VentaNumeroDocumentoCliente() {
		super("");
	}
}
