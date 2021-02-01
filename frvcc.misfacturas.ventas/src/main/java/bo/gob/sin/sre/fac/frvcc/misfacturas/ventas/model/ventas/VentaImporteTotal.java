package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class VentaImporteTotal extends BigDecimalValueObject {
    public VentaImporteTotal(BigDecimal value) {
        super(value);
    }

    public VentaImporteTotal() {
        super(null);
    }
}
