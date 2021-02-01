package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.desasociar_libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.desasociar_libro.CompraDesAsociadorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class DesAsociarLibroCompraCommandHandler implements CommandHandler<DesAsociarLibroCompraCommand> {
   private final CompraDesAsociadorLibroServiceImpl service;

    public DesAsociarLibroCompraCommandHandler(CompraDesAsociadorLibroServiceImpl asignador) {
        this.service = asignador;
    }

    @Override
    public void handle(DesAsociarLibroCompraCommand command) {
        service.desAsociarLibro(new CompraId( command.id()),
                new CompraLibroId(command.libroId()),
                new CompraUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));
    }
}
