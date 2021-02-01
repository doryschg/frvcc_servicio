package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.find;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class FindCompraNotaQuery implements Query {
    private final String id ;

    public FindCompraNotaQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
