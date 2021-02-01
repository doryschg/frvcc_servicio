package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraTipoDocumentoCliente extends StringValueObject {
    public CompraTipoDocumentoCliente() {
        super("");
    }
    public CompraTipoDocumentoCliente(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
