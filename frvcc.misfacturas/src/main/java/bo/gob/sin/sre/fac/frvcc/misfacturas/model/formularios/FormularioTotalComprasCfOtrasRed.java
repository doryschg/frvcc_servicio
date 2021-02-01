package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioTotalComprasCfOtrasRed extends BigIntegerValueObject {
    public FormularioTotalComprasCfOtrasRed(BigInteger value) {
        super(value);
    }
    public FormularioTotalComprasCfOtrasRed redondeo(BigDecimal value){
        return new FormularioTotalComprasCfOtrasRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioTotalComprasCfOtrasRed() {
        super(null);
    }
}
