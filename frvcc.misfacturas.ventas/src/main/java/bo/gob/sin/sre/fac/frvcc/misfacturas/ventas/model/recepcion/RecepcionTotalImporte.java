package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public final class RecepcionTotalImporte extends BigDecimalValueObject {
    public RecepcionTotalImporte() {
        super(null);
    }

    public RecepcionTotalImporte(BigDecimal value) {
        super(value);
    }
}
