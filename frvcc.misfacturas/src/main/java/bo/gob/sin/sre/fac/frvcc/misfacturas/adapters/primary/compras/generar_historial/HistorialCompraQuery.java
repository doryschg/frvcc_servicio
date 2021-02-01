package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.generar_historial;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class HistorialCompraQuery implements Query {
    public String id() {
        return id;
    }

    private String id;
    public HistorialCompraQuery(String id) {
        this.id = id;
    }
}
