package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.des_asignar;



import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.des_asignar.CompraDesAsignadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class DesAsignarCompraCommandHandlerImpl implements CommandHandler<DesAsignarCompraCommandImpl> {
   private final CompraDesAsignadorServiceImpl asignador;

    public DesAsignarCompraCommandHandlerImpl(CompraDesAsignadorServiceImpl pAsignador) {
        this.asignador = pAsignador;
    }

    @Override
    public void handle(DesAsignarCompraCommandImpl pCommand) {
//        asignador.desAsignar( new CompraId( command.id()),
//                new CompraFormularioId(command.formularioId()),
//                new CompraUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));
    }
}
