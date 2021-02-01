package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asignar;



import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asignar.CompraAsignadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class AsignarCompraCommandHandlerImpl implements CommandHandler<AsignarCompraCommandImpl> {
   private final CompraAsignadorServiceImpl asignador;

    public AsignarCompraCommandHandlerImpl(CompraAsignadorServiceImpl pAsignador) {
        this.asignador = pAsignador;
    }

    @Override
    public void handle(AsignarCompraCommandImpl pCommand) {
//        try {
//            asignador.asignar( new CompraId( command.id()),
//                    new CompraFormularioId(command.formularioId()),
//                    new CompraUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));
//        } catch (QueryNotRegisteredError | QueryHandlerExecutionError error) {

//        }
    }
}
