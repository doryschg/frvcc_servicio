package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.rechazar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.rechazar.CompraRechazarServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class RechazarCompraCommandHandler implements CommandHandler<RechazarCompraCommand> {
	   private final CompraRechazarServiceImpl serviceRechazo;

	    public RechazarCompraCommandHandler(CompraRechazarServiceImpl serviceRechazo) {
	        this.serviceRechazo = serviceRechazo;
	    }


	    @Override
	    public void handle(RechazarCompraCommand command) {

	    	serviceRechazo.rechazar( new CompraId( command.getId()),
					new CompraUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion()));
	    }
	}
