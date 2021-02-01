package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public class CompraCodigoAutorizacion extends StringValueObject {
    public CompraCodigoAutorizacion(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }

    public CompraCodigoAutorizacion() {
        super(null);
    }
}
