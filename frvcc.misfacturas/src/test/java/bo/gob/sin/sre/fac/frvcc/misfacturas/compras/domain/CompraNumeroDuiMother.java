package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDui;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;



public final class CompraNumeroDuiMother {
    public static CompraNumeroDui create(String value) {
        return new CompraNumeroDui(value);
    }

    public static CompraNumeroDui random() {
        return create(LongMother.random().toString());
    }

}
