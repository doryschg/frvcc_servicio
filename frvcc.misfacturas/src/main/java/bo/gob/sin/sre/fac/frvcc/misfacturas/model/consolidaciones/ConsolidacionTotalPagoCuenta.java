package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class ConsolidacionTotalPagoCuenta extends BigIntegerValueObject {
    public ConsolidacionTotalPagoCuenta(BigInteger value) {
        super(value);
    }
    public ConsolidacionTotalPagoCuenta adicion(BigInteger value){
        return new ConsolidacionTotalPagoCuenta(value.add(value()));
    }

    public ConsolidacionTotalPagoCuenta substracion(BigInteger value){
        return new ConsolidacionTotalPagoCuenta(value().subtract(value));
    }
    public ConsolidacionTotalPagoCuenta() {
        super(null);
    }
}
