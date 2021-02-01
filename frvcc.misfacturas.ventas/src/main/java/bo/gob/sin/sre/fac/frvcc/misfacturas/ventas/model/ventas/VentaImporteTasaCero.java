package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class VentaImporteTasaCero extends BigDecimalValueObject {
    public VentaImporteTasaCero(BigDecimal value) {
        super(value);
    }

    public VentaImporteTasaCero() {
        super(null);
    }
}
