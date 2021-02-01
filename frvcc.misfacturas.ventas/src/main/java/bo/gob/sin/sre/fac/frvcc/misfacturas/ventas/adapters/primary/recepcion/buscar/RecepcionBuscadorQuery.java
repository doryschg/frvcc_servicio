package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.buscar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class RecepcionBuscadorQuery implements Query {
    private final String id;

    public RecepcionBuscadorQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}

