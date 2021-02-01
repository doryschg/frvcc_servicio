package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.modificar_fecha_presentacion;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioFechaPresentacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modificar_fecha_presentacion.IFormularioModificadorFechaPresentacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;

@Service
public class FormularioModificadorFechaPresentacionServiceImpl implements IFormularioModificadorFechaPresentacion {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioModificadorFechaPresentacionServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final CommandBus commandBus;
	private final FormularioValidador validador;

	public FormularioModificadorFechaPresentacionServiceImpl(FormularioRepository pRepository, EventBus pEventBus,
			QueryBus pQueryBus, CommandBus pCommandBus, FormularioValidador pValidador) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.commandBus = pCommandBus;
		this.validador = pValidador;

	}

	public void modificarFechaPresentacion(FormularioId pId, FormularioFechaPresentacion pFechaPresentacion,
			FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
       Formulario vFormulario = repository.search(pId).orElseThrow(() ->  new FormularioListaErrores(pId, validador.crearValidacionFormularioNoExistente()));
			vFormulario.modificarFechaPresentacion(pFechaPresentacion, pUsuarioUltimaModificacion);
			try {
				repository.save(vFormulario);
			} catch (Exception excepcion) {
				LOG.error(excepcion.getCause().toString(), excepcion);
				throw new FormularioListaErrores(pId, crearValidacionException());
			}
			eventBus.publish(vFormulario.pullDomainEvents());
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_MODIFICACION_FECHA_PRESENTACION.getId()));
			}
		});
	}
}
