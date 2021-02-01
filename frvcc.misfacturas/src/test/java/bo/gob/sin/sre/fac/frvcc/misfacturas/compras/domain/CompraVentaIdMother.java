package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraVentaId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraVentaIdMother {
    public static CompraVentaId create(String value) {
        return new CompraVentaId(value);
    }

    public static CompraVentaId random() {
        return create(WordMother.random());
    }

}
