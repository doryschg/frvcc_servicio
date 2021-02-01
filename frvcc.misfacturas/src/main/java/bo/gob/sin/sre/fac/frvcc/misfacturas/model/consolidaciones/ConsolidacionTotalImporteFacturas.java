package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class ConsolidacionTotalImporteFacturas extends BigIntegerValueObject {
    public ConsolidacionTotalImporteFacturas(BigInteger value) {
        super(value);
    }
    public ConsolidacionTotalImporteFacturas adicion(BigInteger value){
        return new ConsolidacionTotalImporteFacturas(value.add(value()));
    }

    public ConsolidacionTotalImporteFacturas substracion(BigInteger value){
        return new ConsolidacionTotalImporteFacturas(value().subtract(value));
    }
    public ConsolidacionTotalImporteFacturas() {
        super(null);
    }
}
