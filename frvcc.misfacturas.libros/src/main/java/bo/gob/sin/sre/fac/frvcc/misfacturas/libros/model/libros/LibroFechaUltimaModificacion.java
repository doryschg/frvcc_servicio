package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class LibroFechaUltimaModificacion extends LocalDateTimeValueObject {
    public LibroFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
    public LibroFechaUltimaModificacion(){
        super(null);
    }
}
