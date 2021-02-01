package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;



public final class CompraTipoDocumentoClienteMother {
    public static CompraTipoDocumentoCliente create(String value) {
        return new CompraTipoDocumentoCliente(value);
    }

    public static CompraTipoDocumentoCliente random() {
        return create(WordMother.random());
    }


}
