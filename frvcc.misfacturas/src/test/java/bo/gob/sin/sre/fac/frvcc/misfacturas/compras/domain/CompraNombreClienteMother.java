package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreCliente;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraNombreClienteMother {
    public static CompraNombreCliente create(String value) {
        return new CompraNombreCliente(value);
    }

    public static CompraNombreCliente random() {
        return create(WordMother.random());
    }

}
