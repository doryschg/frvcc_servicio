package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.eliminar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.eliminar.CompraEliminadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public class EliminarCompraCommandHandler implements CommandHandler<EliminarCompraCommand> {
private final CompraEliminadorServiceImpl eliminador;

    public EliminarCompraCommandHandler(CompraEliminadorServiceImpl eliminador) {
        this.eliminador = eliminador;
    }

    @Override
    public void handle(EliminarCompraCommand command)  {
              eliminador.eliminar( new CompraId(command.id()),
                     new CompraUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));

    }
}
