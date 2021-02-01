package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraIfcProveedorNb;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;


public final class CompraIfcProveedorNbMother {
    public static CompraIfcProveedorNb create(Long value) {
        return new CompraIfcProveedorNb(value);
    }

    public static CompraIfcProveedorNb random() {
        return create(LongMother.random());
    }

}
