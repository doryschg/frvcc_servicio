package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class FindCompraQuery implements Query {
    private final String id ;

    public FindCompraQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
