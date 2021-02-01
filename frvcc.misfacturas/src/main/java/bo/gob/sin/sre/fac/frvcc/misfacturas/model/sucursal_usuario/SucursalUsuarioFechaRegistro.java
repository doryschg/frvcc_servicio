package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;

public final class SucursalUsuarioFechaRegistro  extends LocalDateTimeValueObject {
    public SucursalUsuarioFechaRegistro() {
        super(null);
    }

    public SucursalUsuarioFechaRegistro(LocalDateTime value) {
        super(value);
    }
}
