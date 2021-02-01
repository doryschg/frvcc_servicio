package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class ConsolidacionFechaRegistro extends LocalDateTimeValueObject {
    public ConsolidacionFechaRegistro(LocalDateTime value) {
        super(value);
    }
    public ConsolidacionFechaRegistro(){
        super(null);
    }
}
