package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

final public class CompraEstadoId extends StringValueObject {
    public CompraEstadoId() {
        super("");
    }

    public CompraEstadoId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
