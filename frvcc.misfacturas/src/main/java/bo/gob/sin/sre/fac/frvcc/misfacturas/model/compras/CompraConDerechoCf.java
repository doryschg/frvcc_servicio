package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraConDerechoCf extends StringValueObject {
    public CompraConDerechoCf() {
        super("");
    }

    public CompraConDerechoCf(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
