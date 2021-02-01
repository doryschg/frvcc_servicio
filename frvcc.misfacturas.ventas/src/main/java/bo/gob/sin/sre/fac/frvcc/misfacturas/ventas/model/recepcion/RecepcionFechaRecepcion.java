package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public final class RecepcionFechaRecepcion extends LocalDateTimeValueObject {
    public RecepcionFechaRecepcion() {
        super(null);
    }

    public RecepcionFechaRecepcion(LocalDateTime value) {
        super(value);
    }
}
