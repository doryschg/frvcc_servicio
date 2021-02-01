package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraComplementoDocumentoCliente extends StringValueObject {
    public CompraComplementoDocumentoCliente() {
        super("");
    }

    public CompraComplementoDocumentoCliente(String value) {

        super( value ==null ? null: value.strip().toUpperCase());


    }
}
