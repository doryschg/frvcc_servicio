package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class CompraFechaRegistro  extends LocalDateTimeValueObject {
    public CompraFechaRegistro() {
        super(null);
    }

    public CompraFechaRegistro(LocalDateTime value) {
        super(value);
    }
}
