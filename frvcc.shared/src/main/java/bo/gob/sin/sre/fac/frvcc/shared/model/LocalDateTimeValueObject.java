package bo.gob.sin.sre.fac.frvcc.shared.model;

import java.time.LocalDateTime;

public abstract class LocalDateTimeValueObject  {
    private final LocalDateTime value;

    public LocalDateTimeValueObject(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value(){return value;}

}
