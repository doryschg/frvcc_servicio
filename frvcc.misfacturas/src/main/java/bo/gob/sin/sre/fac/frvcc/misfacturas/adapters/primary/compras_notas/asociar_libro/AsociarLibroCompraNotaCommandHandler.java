package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.asociar_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.asociar_libro.CompraNotaAsociadorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class AsociarLibroCompraNotaCommandHandler implements CommandHandler<AsociarLibroCompraNotaCommand> {
	private final CompraNotaAsociadorLibroServiceImpl service;

	public AsociarLibroCompraNotaCommandHandler(CompraNotaAsociadorLibroServiceImpl asociador) {
		this.service = asociador;
	}

	@Override
	public void handle(AsociarLibroCompraNotaCommand command) {
//		try {
//			service.asociarLibro(new CompraNotaId(command.id()), new CompraNotaLibroId(command.libroId()),
//					new CompraNotaUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));
//		} catch (QueryNotRegisteredError | QueryHandlerExecutionError error) {
//
//		}
	}
}
