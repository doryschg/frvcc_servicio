package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

import java.util.List;

public class SearchComprasListaIds implements Query {
 private List<String> idsCompra;

    public SearchComprasListaIds(List<String> idsCompra) {
        this.idsCompra = idsCompra;
    }

    public List<String> getIdsCompra() {
        return idsCompra;
    }
}
