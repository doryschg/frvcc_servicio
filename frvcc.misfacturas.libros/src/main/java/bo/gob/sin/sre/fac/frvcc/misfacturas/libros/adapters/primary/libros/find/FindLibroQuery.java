package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.find;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class FindLibroQuery implements Query {
    public String id() {
        return id;
    }

    private final String id;

    public FindLibroQuery(String id) {
        this.id = id;
    }


}
