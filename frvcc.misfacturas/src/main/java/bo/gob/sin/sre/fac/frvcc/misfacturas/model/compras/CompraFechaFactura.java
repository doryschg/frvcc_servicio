package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public final class CompraFechaFactura extends LocalDateValueObject {
    public CompraFechaFactura(LocalDate value) {
        super(value);
    }

    public CompraFechaFactura() {
        super(null);
    }
}
