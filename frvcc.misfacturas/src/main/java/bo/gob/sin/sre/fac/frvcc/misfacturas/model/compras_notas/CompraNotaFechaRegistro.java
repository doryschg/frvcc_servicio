package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class CompraNotaFechaRegistro  extends LocalDateTimeValueObject {
    public CompraNotaFechaRegistro() {
        super(null);
    }

    public CompraNotaFechaRegistro(LocalDateTime value) {
        super(value);
    }
}
