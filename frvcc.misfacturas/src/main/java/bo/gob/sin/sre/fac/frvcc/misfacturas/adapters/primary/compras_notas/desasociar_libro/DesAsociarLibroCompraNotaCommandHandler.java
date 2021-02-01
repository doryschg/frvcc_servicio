package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.desasociar_libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.desasociar_libro.CompraNotaDesAsociadorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class DesAsociarLibroCompraNotaCommandHandler implements CommandHandler<DesAsociarLibroCompraNotaCommand> {
   private final CompraNotaDesAsociadorLibroServiceImpl service;

    public DesAsociarLibroCompraNotaCommandHandler(CompraNotaDesAsociadorLibroServiceImpl asignador) {
        this.service = asignador;
    }

    @Override
    public void handle(DesAsociarLibroCompraNotaCommand command) {
//        service.desAsociarLibro(new CompraNotaId( command.id()),
//                new CompraNotaLibroId(command.libroId()),
//                new CompraNotaUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));
    }
}
