package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query;

public interface QueryHandler<Q extends Query, R extends Response> {
    R handle(Q query) throws QueryHandlerExecutionError;

}
