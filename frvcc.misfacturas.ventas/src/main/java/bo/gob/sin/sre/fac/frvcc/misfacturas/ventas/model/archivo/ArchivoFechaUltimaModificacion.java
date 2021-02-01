package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo;


import java.time.LocalDateTime;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;


public class ArchivoFechaUltimaModificacion extends LocalDateTimeValueObject {
    public ArchivoFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
    private ArchivoFechaUltimaModificacion() {
        super(null);
    }
}
