package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class CompraDescuento extends BigDecimalValueObject {
    public CompraDescuento(BigDecimal value) {
        super(value);
    }

    public CompraDescuento() {
        super(null);
    }
}
