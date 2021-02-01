package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.consolidar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.consolidar.CompraConsolidarServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class ConsolidarCompraCommandHandlerImpl implements CommandHandler<ConsolidarCompraCommandImpl> {
	   private final CompraConsolidarServiceImpl apropiador;

	    public ConsolidarCompraCommandHandlerImpl(CompraConsolidarServiceImpl pApropiador) {
	        this.apropiador = pApropiador;
	    }


	    @Override
	    public void handle(ConsolidarCompraCommandImpl pCommand) {
	        apropiador.consolidar( new CompraId( pCommand.getId()),
					new CompraUsuarioUltimaModificacion(pCommand.getUsuarioUltimaModificacion()));
	    }
	}
