package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.rechazar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioLoginUsuarioReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNombreReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.rechazar.FormularioRechazoServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class RechazarFormularioCommandHandler implements CommandHandler<RechazarFormularioCommand> {
	  private final FormularioRechazoServiceImpl serviceRechazo;

	    public RechazarFormularioCommandHandler(FormularioRechazoServiceImpl serviceRechazo) {
	        this.serviceRechazo = serviceRechazo;
	    }

	    @Override
	    public void handle(RechazarFormularioCommand command) {
	    	try {
	    		serviceRechazo.rechazar(new FormularioId(command.id()),
	    				new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
						new FormularioNombreReceptor(command.nombreReceptor()),
						new FormularioLoginUsuarioReceptor(command.loginUsuarioReceptor()));
			} catch (CommandNotRegisteredError | CommandHandlerExecutionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
