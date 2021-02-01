package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo;

import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

public class ArchivoFechaRegistro extends LocalDateTimeValueObject {
    public ArchivoFechaRegistro(LocalDateTime value) {
        super(value);
    }
    private ArchivoFechaRegistro() {
        super(null);
    }
}
