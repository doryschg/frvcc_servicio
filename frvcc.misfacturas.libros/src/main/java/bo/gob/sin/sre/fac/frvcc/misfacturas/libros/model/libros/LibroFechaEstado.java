package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.time.LocalDate;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

public class LibroFechaEstado extends LocalDateValueObject {
    public LibroFechaEstado(LocalDate value) {
        super(value);
    }
    public LibroFechaEstado(){
        super(null);
    }
}