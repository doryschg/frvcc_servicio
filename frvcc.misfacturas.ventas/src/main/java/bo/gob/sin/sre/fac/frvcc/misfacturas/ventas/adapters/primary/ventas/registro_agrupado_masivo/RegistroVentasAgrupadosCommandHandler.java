package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado_masivo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.procesar_agrupadas_masivo.IProcesarVentasAgrupadasService;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;

@Service
public class RegistroVentasAgrupadosCommandHandler implements CommandHandler<RegistroVentasAgrupadosCommand> {

	private final IProcesarVentasAgrupadasService ventasAgrupadasService;

	public RegistroVentasAgrupadosCommandHandler(IProcesarVentasAgrupadasService pVentasAgrupadasServiceImpl) {
		this.ventasAgrupadasService = pVentasAgrupadasServiceImpl;
	}

	@Override
	public void handle(RegistroVentasAgrupadosCommand pRegistroVentasAgrupadosCommand)
			throws CommandHandlerExecutionError {
		ventasAgrupadasService.procesar(pRegistroVentasAgrupadosCommand);
	}
}
