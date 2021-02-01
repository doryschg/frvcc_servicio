package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraEstadoId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraEstadoIdMother {
    public static CompraEstadoId create(String value) {
        return new CompraEstadoId(value);
    }

    public static CompraEstadoId random() {
        return create(WordMother.random());
    }

}
