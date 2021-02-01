package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

final public class SucursalUsuarioEstadoId extends StringValueObject {
    public SucursalUsuarioEstadoId() {
        super("");
    }

    public SucursalUsuarioEstadoId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
