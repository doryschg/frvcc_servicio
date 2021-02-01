package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraEstadoCompraId extends StringValueObject {
    public CompraEstadoCompraId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }

    public CompraEstadoCompraId() {
        super(null);
    }
}
