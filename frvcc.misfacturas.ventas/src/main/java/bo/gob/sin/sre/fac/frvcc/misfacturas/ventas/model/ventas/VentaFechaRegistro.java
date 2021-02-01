package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public final class VentaFechaRegistro  extends LocalDateTimeValueObject {
    public VentaFechaRegistro() {
        super(null);
    }

    public VentaFechaRegistro(LocalDateTime value) {
        super(value);
    }
}
