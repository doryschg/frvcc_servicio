package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command;

public interface CommandHandler<T extends Command> {
    void handle(T command) throws CommandHandlerExecutionError;

}
