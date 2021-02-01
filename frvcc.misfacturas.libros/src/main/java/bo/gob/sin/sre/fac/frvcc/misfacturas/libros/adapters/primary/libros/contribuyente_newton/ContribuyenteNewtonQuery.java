package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.contribuyente_newton;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class ContribuyenteNewtonQuery implements Query {
    public Long nit() {
        return nit;
    }

    private final Long nit;

    public ContribuyenteNewtonQuery(Long nit) {
        this.nit = nit;
    }


}
