package bo.gob.sin.sre.fac.frvcc.shared.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class LocalDateValueObject {
    private LocalDate value;
    public LocalDateValueObject(LocalDate value){
        this.value=value;
    }
    public LocalDate value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalDateValueObject that = (LocalDateValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
