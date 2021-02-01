package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.consolidar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.aceptar.FormularioAceptarServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class AceptarFormularioCommandHandler implements CommandHandler<AceptarFormularioCommand> {
	  private final FormularioAceptarServiceImpl consolidacion;

	    public AceptarFormularioCommandHandler(FormularioAceptarServiceImpl consolidacion) {
	        this.consolidacion = consolidacion;
	    }

	    @Override
	    public void handle(AceptarFormularioCommand command) {
	    	try {
				consolidacion.aceptar(new FormularioId(command.id()),
						new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
						new FormularioNombreReceptor(command.nombreReceptor()),
						new FormularioLoginUsuarioReceptor(command.loginUsuarioReceptor()),
						new FormularioTipoUsoId(command.esExDependiente()));
			} catch (CommandNotRegisteredError | CommandHandlerExecutionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
