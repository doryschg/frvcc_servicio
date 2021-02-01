package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.habilitar_rectificatorio_fanexo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.habilitar_rectificatorio_fanexo.IFormularioHabilitaRectificatorio;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public final class FormularioHabilitaRectificatorioServiceImpl implements IFormularioHabilitaRectificatorio {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioHabilitaRectificatorioServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;
	private final FormularioValidador validador;

	public FormularioHabilitaRectificatorioServiceImpl(FormularioRepository pRepository, EventBus pEventBus,
			FormularioValidador pValidador) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.validador = pValidador;
	}

	public void habilitarFormularioanexoRectificatorio(FormularioId pFormularioId,
			FormularioUsuarioUltimaModificacion pUsuarioultimaModificacion) {
		Formulario vFormularioAnterior = repository.search(pFormularioId).orElseThrow(
				() -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));
		String vIdnuevoFormulario = UUID.randomUUID().toString();
		Formulario vFormularioNuevo = Formulario.habilitarRectificatorio(vFormularioAnterior, pUsuarioultimaModificacion,
				vIdnuevoFormulario);
		vFormularioAnterior.inhabilitaFormulario(pUsuarioultimaModificacion, vIdnuevoFormulario);
		try {
			repository.save(vFormularioNuevo);

			eventBus.publish(vFormularioNuevo.pullDomainEvents());
			repository.save(vFormularioAnterior);
			eventBus.publish(vFormularioAnterior.pullDomainEvents());

		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
			throw new FormularioListaErrores(pFormularioId, crearValidacionException());

		}

	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_HABILITAR_RECTIFICACION_FORMULARIO.getId()));
			}
		});
	}
}
