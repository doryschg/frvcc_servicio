package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormularioTotalComprasCfIpnRed extends BigIntegerValueObject {
    public FormularioTotalComprasCfIpnRed(BigInteger value) {
        super(value);
    }
    public FormularioTotalComprasCfIpnRed redondeo(BigDecimal value){
        return new FormularioTotalComprasCfIpnRed(value.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
    }
    public FormularioTotalComprasCfIpnRed() {
        super(null);
    }
}
