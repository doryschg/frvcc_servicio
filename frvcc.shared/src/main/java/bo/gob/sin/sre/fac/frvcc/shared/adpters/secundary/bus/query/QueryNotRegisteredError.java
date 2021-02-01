package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class QueryNotRegisteredError extends Exception {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The query <%s> hasn't a query handler associated", query.toString()));
    }
}
