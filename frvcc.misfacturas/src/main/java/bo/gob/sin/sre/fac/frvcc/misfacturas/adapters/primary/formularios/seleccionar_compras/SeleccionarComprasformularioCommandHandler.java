package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.seleccionar_compras;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.seleccionar_compras.FormularioSeleccionarComprasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class SeleccionarComprasformularioCommandHandler implements CommandHandler<SeleccionarComprasformularioCommand> {
    private final FormularioSeleccionarComprasServiceImpl seleccionarcompras;

    public SeleccionarComprasformularioCommandHandler(FormularioSeleccionarComprasServiceImpl seleccioanar) {
        this.seleccionarcompras = seleccioanar;
    }

    @Override
    public void handle(SeleccionarComprasformularioCommand command)  {

             seleccionarcompras.incrementarImporte(new FormularioId(command.id()),
                    new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
                    command.listaIdsCompras());

    }
}
