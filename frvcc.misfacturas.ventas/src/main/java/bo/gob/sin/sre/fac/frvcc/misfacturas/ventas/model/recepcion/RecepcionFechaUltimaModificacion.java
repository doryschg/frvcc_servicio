package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public final class RecepcionFechaUltimaModificacion extends LocalDateTimeValueObject {
    public RecepcionFechaUltimaModificacion() {
        super(null);
    }

    public RecepcionFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
}
