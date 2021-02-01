package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.habilita_rectificatorio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary.libros.validadores.LibroValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;


@Service
public final class LibroHabilitaRectificatorio {
	private static final Logger LOG= LoggerFactory.getLogger(LibroHabilitaRectificatorio.class);
    private final LibroRepository repository;
    private final EventBus eventBus;
    private final LibroValidador validador;


    public LibroHabilitaRectificatorio(LibroRepository repository, EventBus eventBus,
    		LibroValidador validador) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.validador=validador;
    }

    public void habilitarLibroRectificatorio(LibroId pLibroId,LibroUsuarioUltimaModificacion pUsuarioultimaModificacion) {
        	Libro libroAnterior = repository.search(pLibroId).orElseThrow(() ->new LibroListaErrores(pLibroId, validador.crearValidacionLibroNoExistente()));
        	String vIdnuevoLibro=UUID.randomUUID().toString();
            Libro libroNuevo = Libro.habilitarRectificatorio(libroAnterior, pUsuarioultimaModificacion,vIdnuevoLibro);
            libroAnterior.inhabilitaFormulario(pUsuarioultimaModificacion,vIdnuevoLibro);
            LOG.info("notas libro anterior {}",libroAnterior.comprasNotas());
            try {
            repository.save(libroNuevo);
            
            	eventBus.publish(libroNuevo.pullDomainEvents());
            	repository.save(libroAnterior);
                eventBus.publish(libroAnterior.pullDomainEvents());
                
			} catch (Exception excepcion) {
    	  		LOG.error(excepcion.getCause().toString(), excepcion);
                throw new LibroListaErrores(pLibroId, crearValidacionException());

			}

        
    }
    @SuppressWarnings("serial")
	private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_HABILITAR_RECTIFICACION_LIBRO.getId()));
        }});
    }
}
