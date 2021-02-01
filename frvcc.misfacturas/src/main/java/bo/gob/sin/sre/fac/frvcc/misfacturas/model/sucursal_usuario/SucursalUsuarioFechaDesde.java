package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public final class SucursalUsuarioFechaDesde extends LocalDateValueObject {
    public SucursalUsuarioFechaDesde(LocalDate value) {
        super(value);
    }

    public SucursalUsuarioFechaDesde() {
        super(null);
    }
}
