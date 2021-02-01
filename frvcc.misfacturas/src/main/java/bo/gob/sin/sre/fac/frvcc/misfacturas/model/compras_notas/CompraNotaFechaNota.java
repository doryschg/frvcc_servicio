package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public final class CompraNotaFechaNota extends LocalDateValueObject {
    public CompraNotaFechaNota(LocalDate value) {
        super(value);
    }

    public CompraNotaFechaNota() {
        super(null);
    }
}
