package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraRecepcionId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.UuidMother;



public final class CompraRecepcionIdMother {
    public static CompraRecepcionId create(String value) {
        return new CompraRecepcionId(value);
    }

    public static CompraRecepcionId random() {
        return create(UuidMother.random());
    }

}
