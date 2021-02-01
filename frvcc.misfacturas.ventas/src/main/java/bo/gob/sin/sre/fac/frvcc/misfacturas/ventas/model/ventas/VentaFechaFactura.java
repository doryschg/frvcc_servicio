package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.time.LocalDate;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

public final class VentaFechaFactura extends LocalDateValueObject {
    public VentaFechaFactura(LocalDate value) {
        super(value);
    }

    public VentaFechaFactura() {
        super(null);
    }
}
