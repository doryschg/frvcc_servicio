package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import java.time.LocalDate;
import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

public class FormularioFechaPresentacion extends LocalDateValueObject {
    public FormularioFechaPresentacion(LocalDate value) {
        super(value);
    }
    public FormularioFechaPresentacion(){
        super(null);
    }
}
