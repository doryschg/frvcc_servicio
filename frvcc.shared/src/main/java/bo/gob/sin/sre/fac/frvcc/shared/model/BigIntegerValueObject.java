package bo.gob.sin.sre.fac.frvcc.shared.model;
import java.math.BigInteger;
import java.util.Objects;

public abstract class BigIntegerValueObject {
    private BigInteger value;

    public BigIntegerValueObject(BigInteger value) {
        this.value = value;
    }

    public BigInteger value(){return this.value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigIntegerValueObject that = (BigIntegerValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
