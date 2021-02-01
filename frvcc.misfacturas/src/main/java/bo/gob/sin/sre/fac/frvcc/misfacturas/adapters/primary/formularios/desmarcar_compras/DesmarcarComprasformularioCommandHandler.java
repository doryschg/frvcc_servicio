package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.desmarcar_compras;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.desmarcar_compras.FormularioDesmarcarComprasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.seleccionar_compras.FormularioSeleccionarComprasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class DesmarcarComprasformularioCommandHandler implements CommandHandler<DesmarcarComprasformularioCommand> {
    private final FormularioDesmarcarComprasServiceImpl desmarcarCompras;

    public DesmarcarComprasformularioCommandHandler(FormularioDesmarcarComprasServiceImpl seleccioanar) {
        this.desmarcarCompras = seleccioanar;
    }

    @Override
    public void handle(DesmarcarComprasformularioCommand command) {

        desmarcarCompras.decrementarImporte(new FormularioId(command.id()),
        		new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
        		command.listaIdsCompras());

    }
}
