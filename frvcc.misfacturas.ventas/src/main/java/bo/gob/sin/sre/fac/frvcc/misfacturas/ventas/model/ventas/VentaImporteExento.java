package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class VentaImporteExento extends BigDecimalValueObject {
    public VentaImporteExento(BigDecimal value) {
        super(value);
    }

    public VentaImporteExento() {
        super(null);
    }
}
