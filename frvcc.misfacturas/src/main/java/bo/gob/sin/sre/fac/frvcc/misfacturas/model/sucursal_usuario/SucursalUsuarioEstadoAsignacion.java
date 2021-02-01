package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

final public class SucursalUsuarioEstadoAsignacion extends StringValueObject {
    public SucursalUsuarioEstadoAsignacion() {
        super("");
    }

    public SucursalUsuarioEstadoAsignacion(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
