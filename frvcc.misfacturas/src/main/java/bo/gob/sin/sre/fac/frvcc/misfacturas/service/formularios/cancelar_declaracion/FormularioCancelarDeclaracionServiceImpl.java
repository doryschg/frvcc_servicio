package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.cancelar_declaracion;


import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.cancelar_declaracion.IFormularioCancelarDeclaracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class FormularioCancelarDeclaracionServiceImpl implements IFormularioCancelarDeclaracion {
	private static final Logger LOG= LoggerFactory.getLogger(FormularioCancelarDeclaracionServiceImpl.class);
    private final FormularioRepository repository;
    private final EventBus eventBus;
    private final FormularioValidador validador;

	public FormularioCancelarDeclaracionServiceImpl(FormularioRepository pRepository, EventBus pEventBus,
			FormularioValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador=pValidador;
       
    }

    public void cancelarDeclarcion(FormularioId pFormularioId, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        Formulario vFormulario = repository.search(pFormularioId).orElseThrow(() -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));
        vFormulario.cancelarDeclaracionFormulario(pUsuarioUltimaModificacion);
       try {
		
        repository.save(vFormulario);
       } catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
            throw new FormularioListaErrores(pFormularioId, crearValidacionException());
   	}
        eventBus.publish(vFormulario.pullDomainEvents());
    }
    
    private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_CANCELAR_DECLARACION.getId()));
        }});
    }

}





