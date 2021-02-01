package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraEstadoUsoId extends StringValueObject {
    public CompraEstadoUsoId(String value) {

        super( value ==null ? null: value.strip().toUpperCase());
    }

    public CompraEstadoUsoId() {
        super("");
    }
}
