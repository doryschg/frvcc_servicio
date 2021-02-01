package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.find;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class FindSucursalUsuarioQuery implements Query {
    private final String id ;

    public FindSucursalUsuarioQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
