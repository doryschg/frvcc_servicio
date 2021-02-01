package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public final class RecepcionFechaValidacion extends LocalDateTimeValueObject {
    public RecepcionFechaValidacion() {
        super(null);
    }

    public RecepcionFechaValidacion(LocalDateTime value) {
        super(value);
    }
}
