package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class VentaDescuento extends BigDecimalValueObject {
    public VentaDescuento(BigDecimal value) {
        super(value);
    }

    public VentaDescuento() {
        super(null);
    }
}
