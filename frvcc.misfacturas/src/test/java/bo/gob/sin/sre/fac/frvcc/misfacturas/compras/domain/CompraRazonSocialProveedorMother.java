package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;



public final class CompraRazonSocialProveedorMother {
    public static CompraRazonSocialProveedor create(String value) {
        return new CompraRazonSocialProveedor(value);
    }

    public static CompraRazonSocialProveedor random() {
        return create(WordMother.random());
    }

}
