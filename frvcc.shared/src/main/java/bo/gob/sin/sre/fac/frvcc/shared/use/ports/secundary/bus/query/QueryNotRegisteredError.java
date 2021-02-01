package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query;

public final class QueryNotRegisteredError extends Exception {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("El query <%s> no esta asociado a un query handlerd", query.toString()));
    }
}
