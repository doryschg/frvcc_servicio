package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query;

public interface QueryBus {
    <R> R ask(Query query) throws QueryHandlerExecutionError, QueryNotRegisteredError;

}
