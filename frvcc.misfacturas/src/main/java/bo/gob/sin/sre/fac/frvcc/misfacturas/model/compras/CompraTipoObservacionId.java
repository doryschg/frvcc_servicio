package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraTipoObservacionId extends StringValueObject {
    public CompraTipoObservacionId() {
        super("");
    }

    public CompraTipoObservacionId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
