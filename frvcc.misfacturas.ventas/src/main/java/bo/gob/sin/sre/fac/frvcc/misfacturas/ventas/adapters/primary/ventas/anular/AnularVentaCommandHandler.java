package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.anular;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.anular.VentaAnularServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class AnularVentaCommandHandler implements CommandHandler<AnularVentaCommand> {
	private final VentaAnularServiceImpl service;

	public AnularVentaCommandHandler(VentaAnularServiceImpl service) {
		this.service = service;
	}

	@Override
	public void handle(AnularVentaCommand command) {

		service.anular(new VentaId(command.getId()),
				new VentaUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion()));
	}
}
