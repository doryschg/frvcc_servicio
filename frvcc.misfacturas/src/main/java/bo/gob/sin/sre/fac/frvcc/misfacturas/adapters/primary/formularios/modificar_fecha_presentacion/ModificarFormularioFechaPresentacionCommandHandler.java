package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modificar_fecha_presentacion;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioFechaPresentacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.modificar_fecha_presentacion.FormularioModificadorFechaPresentacionServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.rectificar.FormularioRectificarServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ModificarFormularioFechaPresentacionCommandHandler implements CommandHandler<ModificarFormularioFechaPresentacionCommand>  {
	private static final Logger LOG = LoggerFactory.getLogger(ModificarFormularioFechaPresentacionCommandHandler.class);

	private final FormularioModificadorFechaPresentacionServiceImpl modificador;

    public ModificarFormularioFechaPresentacionCommandHandler(FormularioModificadorFechaPresentacionServiceImpl modificador) {
        this.modificador = modificador;
    }
	
	@Override
	public void handle(ModificarFormularioFechaPresentacionCommand command){

			modificador.modificarFechaPresentacion(
					new FormularioId(command.id()),
					new FormularioFechaPresentacion(command.fechaPresentacion()),
					new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()));

		
	}

}
