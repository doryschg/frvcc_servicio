package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class CompraImporteTotalCompra extends BigDecimalValueObject {
    public CompraImporteTotalCompra(BigDecimal value) {
        super(value);
    }

    public CompraImporteTotalCompra() {
        super(null);
    }
}
