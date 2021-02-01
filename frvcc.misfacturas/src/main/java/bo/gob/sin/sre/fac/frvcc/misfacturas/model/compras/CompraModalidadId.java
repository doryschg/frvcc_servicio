package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraModalidadId extends StringValueObject {
    public CompraModalidadId() {
        super("");
    }

    public CompraModalidadId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
