package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.command;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.*;
import org.springframework.context.ApplicationContext;


@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

        CommandHandler handler = context.getBean(commandHandlerClass);

        handler.handle(command);
    }
}
