package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraOrigenId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraOrigenIdMother {
    public static CompraOrigenId create(String value) {
        return new CompraOrigenId(value);
    }

    public static CompraOrigenId random() {
        return create(WordMother.random());
    }

}
