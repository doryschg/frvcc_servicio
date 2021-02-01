package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class ConsolidacionTotalImporteOtrasFacturas extends BigIntegerValueObject {
    public ConsolidacionTotalImporteOtrasFacturas(BigInteger value) {
        super(value);
    }
    public ConsolidacionTotalImporteOtrasFacturas adicion(BigInteger value){
        return new ConsolidacionTotalImporteOtrasFacturas(value.add(value()));
    }

    public ConsolidacionTotalImporteOtrasFacturas substracion(BigInteger value){
        return new ConsolidacionTotalImporteOtrasFacturas(value().subtract(value));
    }
    public ConsolidacionTotalImporteOtrasFacturas() {
        super(null);
    }
}
