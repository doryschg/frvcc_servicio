package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring;



import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.caut.security.jwt.model.JwtUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;


public abstract class ApiController {
    private final QueryBus queryBus;
    private final CommandBus commandBus;


    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    public Long usuarioId() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication authorization = ctx.getAuthentication();
        JwtUserDetails detalleUsuario = (JwtUserDetails) authorization.getPrincipal();
        return detalleUsuario.getId();
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError, CommandNotRegisteredError {

        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError, QueryNotRegisteredError {

        return queryBus.ask(query);

    }

    public String token() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication authorization = ctx.getAuthentication();
        JwtUserDetails detalleUsuario = (JwtUserDetails) authorization.getPrincipal();
        return detalleUsuario.getToken();
    }
    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();


}
