package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;

public final class CompraUsuarioRegistroMother {
    public static CompraUsuarioRegistro create(Long value) {
        return new CompraUsuarioRegistro(value);
    }

    public static CompraUsuarioRegistro random() {
        return create(LongMother.random());
    }

}
