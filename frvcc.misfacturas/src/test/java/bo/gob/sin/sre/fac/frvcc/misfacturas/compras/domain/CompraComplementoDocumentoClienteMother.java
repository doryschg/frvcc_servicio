package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraComplementoDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;


public final class CompraComplementoDocumentoClienteMother {
    public static CompraComplementoDocumentoCliente create(String value) {
        return new CompraComplementoDocumentoCliente(value);
    }

    public static CompraComplementoDocumentoCliente random() {
        return create(WordMother.random());
    }

}
