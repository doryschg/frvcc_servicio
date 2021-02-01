package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public final class VentaFechaUltimaModificacion extends LocalDateTimeValueObject {
    public VentaFechaUltimaModificacion() {
        super(null);
    }

    public VentaFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
}
