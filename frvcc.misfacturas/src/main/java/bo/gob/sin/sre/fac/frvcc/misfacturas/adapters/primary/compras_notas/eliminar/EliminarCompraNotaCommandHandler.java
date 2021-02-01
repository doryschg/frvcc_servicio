package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.eliminar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.eliminar.CompraNotaEliminadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public class EliminarCompraNotaCommandHandler implements CommandHandler<EliminarCompraNotaCommand> {
private final CompraNotaEliminadorServiceImpl eliminador;

    public EliminarCompraNotaCommandHandler(CompraNotaEliminadorServiceImpl eliminador) {
        this.eliminador = eliminador;
    }

    @Override
    public void handle(EliminarCompraNotaCommand command)  {
              eliminador.eliminar( new CompraNotaId(command.id()),
                     new CompraNotaUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));

    }
}
