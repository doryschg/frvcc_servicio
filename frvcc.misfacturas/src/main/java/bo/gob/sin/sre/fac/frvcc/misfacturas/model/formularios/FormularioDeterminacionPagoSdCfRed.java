package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioDeterminacionPagoSdCfRed extends BigIntegerValueObject {
    public FormularioDeterminacionPagoSdCfRed(BigInteger value) {
        super(value);
    }
    public FormularioDeterminacionPagoSdCfRed redondeo(BigDecimal value){
        return new FormularioDeterminacionPagoSdCfRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioDeterminacionPagoSdCfRed() {
        super(null);
    }
} 
