package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command;

public final class CommandNotRegisteredError extends Exception {
    public CommandNotRegisteredError(Class<? extends Command> command) {
        super(String.format("El command <%s> no esta command  asociado a un handler ", command.toString()));
    }

}
