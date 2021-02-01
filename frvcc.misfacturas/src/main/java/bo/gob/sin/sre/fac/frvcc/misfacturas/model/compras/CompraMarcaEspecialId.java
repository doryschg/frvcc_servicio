package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraMarcaEspecialId extends StringValueObject {
    public CompraMarcaEspecialId() {
        super("");
    }

    public CompraMarcaEspecialId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
