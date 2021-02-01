package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNitProveedor;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;


public final class CompraNitProveedorMother {
    public static CompraNitProveedor create(Long value) {
        return new CompraNitProveedor(value);
    }

    public static CompraNitProveedor random() {
        return create(LongMother.random());
    }

}
