package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoByte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoIdPadre;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.archivo.registro.ArchivoServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class RegistroArchivoCommandHandler implements CommandHandler<RegistroArchivoCommand> {
	private final ArchivoServiceImpl recepcionArchivoService;

	public RegistroArchivoCommandHandler(ArchivoServiceImpl pRecepcionArchivoService) {
		this.recepcionArchivoService = pRecepcionArchivoService;
	}

	@Override
	public void handle(RegistroArchivoCommand pCommand) {
		try {
			this.recepcionArchivoService.registrar(new ArchivoId(pCommand.getId()),
					new ArchivoOrigenId(pCommand.getOrigenId()), new ArchivoIdPadre(pCommand.getIdPadre()),
					new ArchivoByte(pCommand.getArchivoByte()),
					new ArchivoUsuarioRegistro(pCommand.getUsuarioRegistro()),
					new ArchivoTipoRecepcionId(pCommand.getTipoRecepcionId()));
		} catch (QueryNotRegisteredError | QueryHandlerExecutionError | ValidatorNotExist error) {

		}
	}

}
