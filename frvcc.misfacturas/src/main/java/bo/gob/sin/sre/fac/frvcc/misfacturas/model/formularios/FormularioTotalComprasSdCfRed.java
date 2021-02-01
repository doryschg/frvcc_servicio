package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioTotalComprasSdCfRed extends BigIntegerValueObject {
    public FormularioTotalComprasSdCfRed(BigInteger value) {
        super(value);
    }
    public FormularioTotalComprasSdCfRed redondeo(BigDecimal value){
        return new FormularioTotalComprasSdCfRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioTotalComprasSdCfRed() {
        super(null);
    }
}
