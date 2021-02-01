package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.UuidMother;

public class CompraIdMother {
    public static CompraId create(String value) {
        return new CompraId(value);
    }

    public static CompraId random() {
        return create(UuidMother.random());
    }
}
