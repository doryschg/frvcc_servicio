package bo.gob.sin.sre.fac.frvcc.shared.model;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class BigDecimalValueObject {
    private BigDecimal value;

    public BigDecimalValueObject(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value(){return this.value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigDecimalValueObject that = (BigDecimalValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
