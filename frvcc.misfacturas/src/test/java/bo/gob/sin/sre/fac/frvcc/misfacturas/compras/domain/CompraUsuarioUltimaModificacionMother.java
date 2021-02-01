package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;

public final class CompraUsuarioUltimaModificacionMother {
    public static CompraUsuarioUltimaModificacion create(Long value) {
        return new CompraUsuarioUltimaModificacion(value);
    }

    public static CompraUsuarioUltimaModificacion random() {
        return create(LongMother.random());
    }

}
