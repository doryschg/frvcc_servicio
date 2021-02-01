package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.rectificar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.rectificar.FormularioRectificarServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class RectificarFormularioCommandHandler implements CommandHandler<RectificarFormularioCommand> {
    private final FormularioRectificarServiceImpl rectificar;

    public RectificarFormularioCommandHandler(FormularioRectificarServiceImpl declarar) {
        this.rectificar = declarar;
    }

    @Override
    public void handle(RectificarFormularioCommand command) {

        rectificar.rectificar(new FormularioId(command.id()), command.codAdmin(),
        		new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()));

    }
}
