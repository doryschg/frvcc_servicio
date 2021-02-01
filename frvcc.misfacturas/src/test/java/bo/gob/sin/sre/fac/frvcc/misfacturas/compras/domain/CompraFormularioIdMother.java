package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraFormularioIdMother {
    public static CompraFormularioId create(String value) {
        return new CompraFormularioId(value);
    }

    public static CompraFormularioId random() {
        return create(WordMother.random());
    }

}
