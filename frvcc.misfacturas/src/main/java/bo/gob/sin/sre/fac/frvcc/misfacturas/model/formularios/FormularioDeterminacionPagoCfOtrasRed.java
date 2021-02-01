package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioDeterminacionPagoCfOtrasRed extends BigIntegerValueObject {
    public FormularioDeterminacionPagoCfOtrasRed(BigInteger value) {
        super(value);
    }
    public FormularioDeterminacionPagoCfOtrasRed redondeo(BigDecimal value){
        return new FormularioDeterminacionPagoCfOtrasRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioDeterminacionPagoCfOtrasRed() {
        super(null);
    }
} 
