package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class CompraNotaFechaUltimaModificacion extends LocalDateTimeValueObject {
    public CompraNotaFechaUltimaModificacion() {
        super(null);
    }

    public CompraNotaFechaUltimaModificacion(LocalDateTime value) {
        super(value);
    }
}
