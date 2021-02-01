package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.declarar;


import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary.libros.validadores.LibroValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroNumeroOrden;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.declarar.ILibroDeclarar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.GeneraNumeroOrdenRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class LibroDeclarar  implements ILibroDeclarar {
	private static final Logger LOG= LoggerFactory.getLogger(LibroDeclarar.class);
    private final LibroRepository repository;
    private final EventBus eventBus;
    private final GeneraNumeroOrdenRepository generaNumeroOrden;
    private final LibroValidador validador;


    public LibroDeclarar(LibroRepository repository, EventBus eventBus,
                              GeneraNumeroOrdenRepository generaNumeroOrden,LibroValidador validador
) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.generaNumeroOrden = generaNumeroOrden;
        this.validador=validador;
    }

    public void declarar(LibroId pLibroId, Integer pCodAdmin,LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        Libro libro = repository.search(pLibroId).orElseThrow(() -> new LibroListaErrores(pLibroId, validador.crearValidacionLibroNoExistente()));
        libro.declararLibro(new LibroNumeroOrden(generaNumeroOrden.obtenerNumeroOrden(pCodAdmin)),pUsuarioUltimaModificacion);
        try {
        repository.save(libro);
        } catch (Exception excepcion) {
	  		LOG.error(excepcion.getCause().toString(), excepcion);
            throw new LibroListaErrores(pLibroId, crearValidacionException());

		}
        eventBus.publish(libro.pullDomainEvents());
    }
    private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DECLARAR_FORMULARIO.getId()));
        }});
    }

}





