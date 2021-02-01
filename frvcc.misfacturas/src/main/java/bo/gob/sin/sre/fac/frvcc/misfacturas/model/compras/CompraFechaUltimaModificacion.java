package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class CompraFechaUltimaModificacion extends LocalDateTimeValueObject {
    public CompraFechaUltimaModificacion() {
        super(null);
    }

    public CompraFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
}
