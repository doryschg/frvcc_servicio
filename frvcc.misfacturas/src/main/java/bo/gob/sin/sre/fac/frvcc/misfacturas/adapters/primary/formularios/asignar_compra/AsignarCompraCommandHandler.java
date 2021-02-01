package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.asignar_compra;


import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asignar.CompraAsignadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
public class AsignarCompraCommandHandler implements CommandHandler<AsignarCompraFormularioCommand> {
   private final CompraAsignadorServiceImpl asignador;

    public AsignarCompraCommandHandler(CompraAsignadorServiceImpl asignador) {
        this.asignador = asignador;
    }



    @Override
    public void handle(AsignarCompraFormularioCommand command) throws CommandHandlerExecutionError {

    }
}
