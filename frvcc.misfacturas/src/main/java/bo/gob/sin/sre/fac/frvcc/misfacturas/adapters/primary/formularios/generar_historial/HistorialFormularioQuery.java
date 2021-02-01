package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.generar_historial;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class HistorialFormularioQuery implements Query {
    public String id() {
        return id;
    }

    private String id;
    public HistorialFormularioQuery(String id) {
        this.id = id;
    }
}
