package bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class HFormularioFechaRegistro extends LocalDateTimeValueObject {
    public HFormularioFechaRegistro(LocalDateTime value) {
        super(value);
    }
    public HFormularioFechaRegistro(){
        super(null);
    }
}
