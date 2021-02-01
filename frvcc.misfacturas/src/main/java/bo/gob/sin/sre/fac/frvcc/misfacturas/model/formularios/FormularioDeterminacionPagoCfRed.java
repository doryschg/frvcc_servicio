package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioDeterminacionPagoCfRed extends BigIntegerValueObject {
    public FormularioDeterminacionPagoCfRed(BigInteger value) {
        super(value);
    }
    public FormularioDeterminacionPagoCfRed redondeo(BigDecimal value){
        return new FormularioDeterminacionPagoCfRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioDeterminacionPagoCfRed() {
        super(null);
    }
} 
