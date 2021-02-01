package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class ConsolidacionTotalImporte7rgFacturas extends BigIntegerValueObject {
    public ConsolidacionTotalImporte7rgFacturas(BigInteger value) {
        super(value);
    }
    public ConsolidacionTotalImporte7rgFacturas adicion(BigInteger value){
        return new ConsolidacionTotalImporte7rgFacturas(value.add(value()));
    }

    public ConsolidacionTotalImporte7rgFacturas substracion(BigInteger value){
        return new ConsolidacionTotalImporte7rgFacturas(value().subtract(value));
    }
    public ConsolidacionTotalImporte7rgFacturas() {
        super(null);
    }
}
