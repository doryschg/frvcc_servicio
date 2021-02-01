package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.archivo.registro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.Archivo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoByte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoIdPadre;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.archivo.extraer_ventas.ArchivoExtraerVentasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.registro.IArchivoRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.archivo.IArchivoRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class ArchivoServiceImpl implements IArchivoRegistro {
	private static final Logger LOG = LoggerFactory.getLogger(ArchivoServiceImpl.class);
	private final IArchivoRepository repository;
	private final EventBus eventBus;

	public ArchivoServiceImpl(IArchivoRepository pRepository, @Qualifier("ApachePulsarEventBus") EventBus pEventBus,
			QueryBus pQueryBus, CommandBus pCommandBus, ArchivoExtraerVentasServiceImpl pExtraerVentas) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	@Override
	public void registrar(ArchivoId pId, ArchivoOrigenId pOrigenId, ArchivoIdPadre pIdPadre, ArchivoByte pArchivoByte,
			ArchivoUsuarioRegistro pUsuarioRegistro, ArchivoTipoRecepcionId pTipoRecepcionId)
			throws QueryNotRegisteredError, QueryHandlerExecutionError, ValidatorNotExist {

		if (!repository.findById(pId).isPresent()) {
			Archivo vArchivo = Archivo.registrar(pId, pOrigenId, pIdPadre, pArchivoByte, pUsuarioRegistro,
					pTipoRecepcionId);
			repository.guardar(vArchivo);

			vArchivo.recepcionArchivo(pId, pOrigenId, pIdPadre, pArchivoByte, pUsuarioRegistro, pTipoRecepcionId);
			eventBus.publish(vArchivo.pullDomainEvents());
		}
	}
}
