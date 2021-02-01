package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public final class FormularioFechaEstado extends LocalDateValueObject {
    public FormularioFechaEstado() {
        super(null);
    }

    public FormularioFechaEstado(LocalDate value) {
        super(value);
    }
}
