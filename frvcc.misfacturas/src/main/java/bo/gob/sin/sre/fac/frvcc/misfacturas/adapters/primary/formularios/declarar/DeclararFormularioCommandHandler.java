package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.declarar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.declarar.FormularioDeclararServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class DeclararFormularioCommandHandler implements CommandHandler<DeclararFormularioCommand> {
    private final FormularioDeclararServiceImpl declarar;

    public DeclararFormularioCommandHandler(FormularioDeclararServiceImpl declarar) {
        this.declarar = declarar;
    }

    @Override
    public void handle(DeclararFormularioCommand command) {

        declarar.declarar(new FormularioId(command.id()), command.codAdmin(),new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()));

    }
}
