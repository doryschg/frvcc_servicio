package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public final class SucursalUsuarioFechaHasta extends LocalDateValueObject {
    public SucursalUsuarioFechaHasta(LocalDate value) {
        super(value);
    }

    public SucursalUsuarioFechaHasta() {
        super(null);
    }
}
