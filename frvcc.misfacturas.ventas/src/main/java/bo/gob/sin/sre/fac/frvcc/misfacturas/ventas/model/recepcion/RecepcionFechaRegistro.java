package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public final class RecepcionFechaRegistro extends LocalDateTimeValueObject {
    public RecepcionFechaRegistro() {
        super(null);
    }

    public RecepcionFechaRegistro(LocalDateTime value) {
        super(value);
    }
}
