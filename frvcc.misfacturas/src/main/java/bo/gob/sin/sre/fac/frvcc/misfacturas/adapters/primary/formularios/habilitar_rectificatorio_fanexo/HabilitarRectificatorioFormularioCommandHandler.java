package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.habilitar_rectificatorio_fanexo;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.declarar.FormularioDeclararServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.habilitar_rectificatorio_fanexo.FormularioHabilitaRectificatorioServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class HabilitarRectificatorioFormularioCommandHandler implements CommandHandler<HabilitarRectificatorioFormularioCommand> {
    private final FormularioHabilitaRectificatorioServiceImpl service;

    public HabilitarRectificatorioFormularioCommandHandler(FormularioHabilitaRectificatorioServiceImpl declarar) {
        this.service = declarar;
    }

    @Override
    public void handle(HabilitarRectificatorioFormularioCommand command) {

        service.habilitarFormularioanexoRectificatorio(new FormularioId(command.id()),new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()));

    }
}
