package bo.gob.sin.sre.fac.frvcc.shared.model;

import java.time.LocalDateTime;

public final class FechaUltimaModificacion extends LocalDateTimeValueObject {
    public FechaUltimaModificacion() {
        super(null);
    }

    public FechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
}
