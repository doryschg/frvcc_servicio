package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigIntegerValueObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class ConsolidacionTotalImporteIpnFacturas extends BigIntegerValueObject {
    public ConsolidacionTotalImporteIpnFacturas(BigInteger value) {
        super(value);
    }
    public ConsolidacionTotalImporteIpnFacturas adicion(BigInteger value){
        return new ConsolidacionTotalImporteIpnFacturas(value.add(value()));
    }

    public ConsolidacionTotalImporteIpnFacturas substracion(BigInteger value){
        return new ConsolidacionTotalImporteIpnFacturas(value().subtract(value));
    }
    public ConsolidacionTotalImporteIpnFacturas() {
        super(null);
    }
}
