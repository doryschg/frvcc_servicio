package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoDocumentoId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;


public class CompraTipoDocumentoIdMother {
    public static CompraTipoDocumentoId create(String value) {
        return new CompraTipoDocumentoId(value);
    }

    public static CompraTipoDocumentoId random() {
        return create(WordMother.random());
    }
}
