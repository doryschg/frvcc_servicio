package bo.gob.sin.sre.fac.frvcc.shared.test.domain;

import java.math.BigDecimal;

public final class BigDecimalMother {
    public static BigDecimal random() {
        return new BigDecimal(MotherCreator.random().number().randomDouble(2,10,1000));
    }
}
