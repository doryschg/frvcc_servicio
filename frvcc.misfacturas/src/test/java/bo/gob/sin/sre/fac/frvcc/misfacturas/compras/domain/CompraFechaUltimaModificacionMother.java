package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaUltimaModificacion;

import java.time.LocalDateTime;

public final class CompraFechaUltimaModificacionMother {
    public static CompraFechaUltimaModificacion create(LocalDateTime value) {
        return new CompraFechaUltimaModificacion(value);
    }

    public static CompraFechaUltimaModificacion random() {
        return create(LocalDateTime.now());
    }

}
