package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraTipoCompraId extends StringValueObject {
    public CompraTipoCompraId() {
        super("");
    }

    public CompraTipoCompraId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
