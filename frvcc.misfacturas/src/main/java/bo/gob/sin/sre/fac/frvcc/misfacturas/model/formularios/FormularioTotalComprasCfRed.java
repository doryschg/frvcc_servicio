package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioTotalComprasCfRed extends BigIntegerValueObject {
    public FormularioTotalComprasCfRed(BigInteger value) {
        super(value);
    }

    public FormularioTotalComprasCfRed redondeo(BigDecimal value){
        return new FormularioTotalComprasCfRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }

    public FormularioTotalComprasCfRed() {
        super(null);
    }
}
