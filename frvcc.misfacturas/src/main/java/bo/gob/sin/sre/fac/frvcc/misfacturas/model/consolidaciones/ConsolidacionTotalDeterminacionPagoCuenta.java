package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class ConsolidacionTotalDeterminacionPagoCuenta extends BigIntegerValueObject {
    public ConsolidacionTotalDeterminacionPagoCuenta(BigInteger value) {
        super(value);
    }
    public ConsolidacionTotalDeterminacionPagoCuenta adicion(BigInteger value){
        return new ConsolidacionTotalDeterminacionPagoCuenta(value.add(value()));
    }

    public ConsolidacionTotalDeterminacionPagoCuenta substracion(BigInteger value){
        return new ConsolidacionTotalDeterminacionPagoCuenta(value().subtract(value));
    }
    public ConsolidacionTotalDeterminacionPagoCuenta() {
        super(null);
    }
}
