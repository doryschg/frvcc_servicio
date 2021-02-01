package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class FormularioFechaRegistro extends LocalDateTimeValueObject {
    public FormularioFechaRegistro(LocalDateTime value) {
        super(value);
    }
    public FormularioFechaRegistro(){
        super(null);
    }
}
