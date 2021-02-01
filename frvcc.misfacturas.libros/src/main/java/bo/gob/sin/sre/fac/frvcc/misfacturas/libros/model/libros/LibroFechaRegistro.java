package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class LibroFechaRegistro extends LocalDateTimeValueObject {
    public LibroFechaRegistro(LocalDateTime value) {
        super(value);
    }
    public LibroFechaRegistro(){
        super(null);
    }
}
