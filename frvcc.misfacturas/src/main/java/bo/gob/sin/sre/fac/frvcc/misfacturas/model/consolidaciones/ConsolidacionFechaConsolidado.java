package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;
import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;
import java.time.LocalDateTime;

public final class ConsolidacionFechaConsolidado extends LocalDateTimeValueObject {
    public ConsolidacionFechaConsolidado() {
        super(null);
    }

    public ConsolidacionFechaConsolidado(LocalDateTime value) {
        super(value);
    }
}
