package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.buscar_por_id_agregado;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class BuscarEventoDominioPorIdQuery implements Query {
    private String aggregateId;

    public BuscarEventoDominioPorIdQuery(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getAggregateId() {
        return aggregateId;
    }
}
