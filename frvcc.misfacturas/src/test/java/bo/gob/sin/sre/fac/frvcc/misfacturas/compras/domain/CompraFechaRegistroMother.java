package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaRegistro;

import java.time.LocalDateTime;

public final class CompraFechaRegistroMother {
    public static CompraFechaRegistro create(LocalDateTime value) {
        return new CompraFechaRegistro(value);
    }

    public static CompraFechaRegistro random() {
        return create(LocalDateTime.now());
    }

}
