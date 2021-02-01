package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;



public final class BuscarContribuyentePorNitQueryDto implements Query {
    private final Long nit;

    public BuscarContribuyentePorNitQueryDto(Long nit) {
        this.nit = nit;
    }

    public Long nit() {
        return nit;
    }
}
