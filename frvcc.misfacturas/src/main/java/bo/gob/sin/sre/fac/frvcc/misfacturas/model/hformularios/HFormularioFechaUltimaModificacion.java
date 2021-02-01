package bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class HFormularioFechaUltimaModificacion extends LocalDateTimeValueObject {
    public HFormularioFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
    public HFormularioFechaUltimaModificacion(){
        super(null);
    }
}
