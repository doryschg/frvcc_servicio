package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class FormularioFechaUltimaModificacion extends LocalDateTimeValueObject {
    public FormularioFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
    public FormularioFechaUltimaModificacion(){
        super(null);
    }
}
