package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.find;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class FindFormularioQuery implements Query {
    public String id() {
        return id;
    }

    private final String id;

    public FindFormularioQuery(String id) {
        this.id = id;
    }


}
