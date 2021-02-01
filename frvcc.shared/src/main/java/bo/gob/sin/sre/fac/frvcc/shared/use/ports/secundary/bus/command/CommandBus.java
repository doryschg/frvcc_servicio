package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command;

public interface CommandBus {
    void dispatch(Command command)  throws CommandNotRegisteredError,  CommandHandlerExecutionError;
}
