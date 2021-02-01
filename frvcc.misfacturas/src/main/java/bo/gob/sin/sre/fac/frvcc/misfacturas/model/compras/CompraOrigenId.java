package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public class CompraOrigenId extends StringValueObject {
    public CompraOrigenId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }

    public CompraOrigenId() {
        super("");
    }

}
