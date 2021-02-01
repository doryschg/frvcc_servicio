package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaFactura;

import java.time.LocalDate;

public final class CompraFechaFacturaMother {
    public static CompraFechaFactura create(LocalDate value) {
        return new CompraFechaFactura(value);
    }

    public static CompraFechaFactura random() {
        return create(LocalDate.now());
    }

}
