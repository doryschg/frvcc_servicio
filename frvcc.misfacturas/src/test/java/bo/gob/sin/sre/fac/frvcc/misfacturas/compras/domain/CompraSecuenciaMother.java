package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraSecuencia;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;

public final class CompraSecuenciaMother {
    public static CompraSecuencia create(Long value) {
        return new CompraSecuencia(value);
    }
    public static CompraSecuencia random() {
        return create(LongMother.random());
    }
}
