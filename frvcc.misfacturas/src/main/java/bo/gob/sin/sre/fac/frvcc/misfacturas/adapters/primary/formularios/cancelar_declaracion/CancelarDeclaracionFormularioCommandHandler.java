package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.cancelar_declaracion;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.cancelar_declaracion.FormularioCancelarDeclaracionServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.declarar.FormularioDeclararServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CancelarDeclaracionFormularioCommandHandler implements CommandHandler<CancelarDeclaracionFormularioCommand> {
    private final FormularioCancelarDeclaracionServiceImpl cancelarDeclaracionService;

    public CancelarDeclaracionFormularioCommandHandler(FormularioCancelarDeclaracionServiceImpl declarar) {
        this.cancelarDeclaracionService = declarar;
    }

    @Override
    public void handle(CancelarDeclaracionFormularioCommand command) {

        cancelarDeclaracionService.cancelarDeclarcion((new FormularioId(command.id())),(new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacion())));

    }
}
