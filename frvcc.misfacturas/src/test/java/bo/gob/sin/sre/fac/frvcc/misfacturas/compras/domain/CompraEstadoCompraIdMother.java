package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraEstadoCompraId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraEstadoCompraIdMother {
    public static CompraEstadoCompraId create(String value) {
        return new CompraEstadoCompraId(value);
    }

    public static CompraEstadoCompraId random() {
        return create(WordMother.random());
    }

}
