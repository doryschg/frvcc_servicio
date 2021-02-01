package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.apropiacion;



import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.apropiacion.CompraApropiadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class ApropiarCompraCommandHandlerImpl implements CommandHandler<ApropiarCompraCommandImpl> {
   private final CompraApropiadorServiceImpl apropiador;

    public ApropiarCompraCommandHandlerImpl(CompraApropiadorServiceImpl pApropiador) {
        this.apropiador = pApropiador;
    }


    @Override
    public void handle(ApropiarCompraCommandImpl pCommand) {
        apropiador.apropiar( new CompraId( pCommand.id()));
    }
}
