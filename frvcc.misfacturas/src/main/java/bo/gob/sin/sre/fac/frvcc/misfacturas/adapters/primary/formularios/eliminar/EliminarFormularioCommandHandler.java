package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.eliminar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.eliminar.CompraEliminadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.eliminar.FormularioEliminadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public class EliminarFormularioCommandHandler implements CommandHandler<EliminarFormularioCommand> {
private final FormularioEliminadorServiceImpl eliminador;

    public EliminarFormularioCommandHandler(FormularioEliminadorServiceImpl eliminador) {
        this.eliminador = eliminador;
    }

    @Override
    public void handle(EliminarFormularioCommand command)  {
              eliminador.eliminar( new FormularioId(command.id()),
                     new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));

    }
}
