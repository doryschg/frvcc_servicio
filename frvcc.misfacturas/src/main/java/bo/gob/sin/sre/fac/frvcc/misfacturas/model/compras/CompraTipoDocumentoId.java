package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraTipoDocumentoId extends StringValueObject {
    public CompraTipoDocumentoId(String  value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }

    public CompraTipoDocumentoId() {
        super(null);
    }
}
