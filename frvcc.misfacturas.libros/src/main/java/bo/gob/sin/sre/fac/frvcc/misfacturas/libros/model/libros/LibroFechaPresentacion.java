package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.time.LocalDate;
import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

public class LibroFechaPresentacion extends LocalDateTimeValueObject {
    public LibroFechaPresentacion(LocalDateTime value) {
        super(value);
    }
    public LibroFechaPresentacion(){
        super(null);
    }
}
