package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.registro;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroAdministracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroAnioPeriodo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadPeriodicidad;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCodigoAdministracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroIfc;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroMesPeriodo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroNit;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroNombreLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroPeriodicidadId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroRazonSocial;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTipoPresentacionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;


@Service
public final class LibroRegistrador {
	private static final Logger LOG= LoggerFactory.getLogger(LibroRegistrador.class);
    private final LibroRepository repository;
    private final EventBus eventBus;

    public LibroRegistrador(LibroRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void registro(LibroId id,
                         LibroNombreLibro nombreLibro,
                         LibroMesPeriodo mesPeriodo,
                         LibroAnioPeriodo anioPeriodo,
                         LibroPeriodicidadId periodicidadId,
                         LibroCantidadPeriodicidad cantidadPeriodicidad,
                         LibroTipoPresentacionId tipoPresentacionId,
                         LibroNit nit,
                         LibroIfc ifc,
                         LibroRazonSocial razonSocial,
                         LibroCodigoAdministracion codAdministracion,
             			LibroAdministracion administracion,
                         LibroUsuarioRegistro usuarioRegistro) {
    	
    	Criteria criteria = new Criteria (
                new Filters(Arrays.asList(
                        Filter.create("mesPeriodo", "=",mesPeriodo.value()+"")
                		,Filter.create("anioPeriodo", "=", anioPeriodo.value()+"")
                		,Filter.create("nit", "=", nit.value()+"")
                		,Filter.create("estadoId", "=", "AC")
                		)), Order.none()
        );
        if (repository.BuscarPorCriteria(criteria).getTotalElementos()==0) {
            Libro libro = Libro.registro(
                    id,
                    nombreLibro,
                    mesPeriodo,
                    anioPeriodo,
                    periodicidadId,
                    cantidadPeriodicidad,
                    tipoPresentacionId,
                    nit,
                    ifc,
                    razonSocial,codAdministracion,
                    administracion,
                    usuarioRegistro);
            try {
                repository.save(libro);
                eventBus.publish(libro.pullDomainEvents());
			} catch (Exception excepcion) {
    	  		LOG.error(excepcion.getCause().toString(), excepcion);
                throw new LibroListaErrores(id, crearValidacionException());

			}

        }
        else
        {
        	throw new LibroListaErrores(id, crearValidacionExistencia());
        }
    }
    private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_LIBRO.getId()));
        }});
    }
    private ValidationResponse crearValidacionExistencia(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.LIBRO_EXISTE_PERIODO.getId()));
        }});
    }
}
