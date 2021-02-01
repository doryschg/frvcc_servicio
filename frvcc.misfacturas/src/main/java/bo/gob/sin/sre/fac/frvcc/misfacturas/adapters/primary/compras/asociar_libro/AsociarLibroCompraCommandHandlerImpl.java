package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asociar_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asociar_libro.CompraAsociadorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class AsociarLibroCompraCommandHandlerImpl implements CommandHandler<AsociarLibroCompraCommandImpl> {
	private final CompraAsociadorLibroServiceImpl service;

	public AsociarLibroCompraCommandHandlerImpl(CompraAsociadorLibroServiceImpl pAsociador) {
		this.service = pAsociador;
	}

	@Override
	public void handle(AsociarLibroCompraCommandImpl command) {
//		try {
//			service.asociarLibro(new CompraId(command.id()), new CompraLibroId(command.libroId()),
//					new CompraUsuarioUltimaModificacion(command.usuarioUltimaModificacion()),
//					new CompraTipoCompraId(command.tipoCompra()));
//		} catch (QueryNotRegisteredError | QueryHandlerExecutionError error) {
//
//		}
	}
}
