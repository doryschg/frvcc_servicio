package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraEstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;



public final class CompraEstadoUsoIdMother {
    public static CompraEstadoUsoId create(String value) {
        return new CompraEstadoUsoId(value);
    }

    public static CompraEstadoUsoId random() {
        return create(WordMother.random());
    }
}
