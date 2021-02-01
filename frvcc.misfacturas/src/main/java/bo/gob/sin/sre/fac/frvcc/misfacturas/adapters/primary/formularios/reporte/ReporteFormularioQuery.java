package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.reporte;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class ReporteFormularioQuery implements Query {

	public String id() {
        return id;
    }

    private final String id;

    public ReporteFormularioQuery(String id) {
        this.id = id;
    }


}
