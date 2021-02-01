package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;

@Service
public class RegistroVentasAgrupadoCommandHandler implements CommandHandler<RegistroVentasAgrupadoCommand> {

	@Override
	public void handle(RegistroVentasAgrupadoCommand command) throws CommandHandlerExecutionError {
		// TODO Auto-generated method stub
		
	}

}
