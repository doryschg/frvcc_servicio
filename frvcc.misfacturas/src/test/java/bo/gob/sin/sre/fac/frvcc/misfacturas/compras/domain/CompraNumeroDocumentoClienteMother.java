package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;



public final class CompraNumeroDocumentoClienteMother {
    public static CompraNumeroDocumentoCliente create(String value) {
        return new CompraNumeroDocumentoCliente(value);
    }

    public static CompraNumeroDocumentoCliente random() {
        return create(WordMother.random());
    }


}
