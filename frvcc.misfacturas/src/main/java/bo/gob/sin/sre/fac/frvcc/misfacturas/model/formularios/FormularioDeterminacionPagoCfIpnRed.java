package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioDeterminacionPagoCfIpnRed extends BigIntegerValueObject {
    public FormularioDeterminacionPagoCfIpnRed(BigInteger value) {
        super(value);
    }
    public FormularioDeterminacionPagoCfIpnRed redondeo(BigDecimal value){
        return new FormularioDeterminacionPagoCfIpnRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioDeterminacionPagoCfIpnRed() {
        super(null);
    }
} 
