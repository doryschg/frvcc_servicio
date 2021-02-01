package bo.gob.sin.sre.fac.frvcc.shared.model;

import java.time.LocalDateTime;

public final class FechaRegistro extends LocalDateTimeValueObject {
    public FechaRegistro() {
        super(null);
    }

    public FechaRegistro(LocalDateTime value) {
        super(value);
    }
}
