package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class ConsolidacionFechaUltimaModificacion extends LocalDateTimeValueObject {
    public ConsolidacionFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
    public ConsolidacionFechaUltimaModificacion(){
        super(null);
    }
}
