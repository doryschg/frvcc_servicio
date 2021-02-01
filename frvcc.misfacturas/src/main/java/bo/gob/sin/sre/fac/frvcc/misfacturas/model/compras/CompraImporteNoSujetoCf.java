package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;


import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

import java.math.BigDecimal;

public class CompraImporteNoSujetoCf extends BigDecimalValueObject {
    public CompraImporteNoSujetoCf(BigDecimal value) {
        super(value);
    }

    public CompraImporteNoSujetoCf() {
        super(null);
    }
    public CompraImporteNoSujetoCf(BigDecimal importeTotal, BigDecimal creditoFiscal){
        super(importeTotal.multiply(creditoFiscal.multiply(new BigDecimal(Utils.PORCENTAJE))));
    }
}
