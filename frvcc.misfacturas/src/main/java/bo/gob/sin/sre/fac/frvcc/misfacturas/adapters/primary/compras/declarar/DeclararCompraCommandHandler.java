package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.declarar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar.CompraDeclaradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class DeclararCompraCommandHandler implements CommandHandler<DeclararCompraCommand> {
   private final CompraDeclaradorServiceImpl service;

    public DeclararCompraCommandHandler(CompraDeclaradorServiceImpl pService) {
        this.service = pService;
    }

    @Override
    public void handle(DeclararCompraCommand pCommand) {
        service.declarar( new CompraId( pCommand.getId()), new CompraUsuarioUltimaModificacion(pCommand.getUsuarioUltimaModificacion()));
    }
}
