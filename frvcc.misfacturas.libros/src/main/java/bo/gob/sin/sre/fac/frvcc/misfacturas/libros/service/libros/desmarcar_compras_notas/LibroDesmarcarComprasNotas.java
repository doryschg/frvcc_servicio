package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.desmarcar_compras_notas;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.find.FindCompraNotaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary.libros.validadores.LibroValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.desmarcar_compras_notas.ILibroDesmarcarComprasNotas;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class LibroDesmarcarComprasNotas  implements ILibroDesmarcarComprasNotas {
	private static final Logger LOG= LoggerFactory.getLogger(LibroDesmarcarComprasNotas.class);
    private final LibroRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final LibroValidador validador;
    
   
    public LibroDesmarcarComprasNotas(LibroRepository repository, EventBus eventBus,
                              
                              LibroValidador validador,QueryBus queryBus
) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.validador=validador;
        this.queryBus=queryBus;
    }

    public void decrementarImporteNotas(LibroId pLibroId,LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion
    		,List<String> pListaIdsCompras) {
        Libro libro = repository.search(pLibroId).orElseThrow(() -> new LibroListaErrores(pLibroId, validador.crearValidacionLibroNoExistente()));
        
       for (String idCompraNota : pListaIdsCompras) {
		
    	   try {
			CompraNotaResponse compraResponse = queryBus.ask(new FindCompraNotaQuery(idCompraNota));
			CompraNotaResponseGenerico compraNota=compraResponse.getCompraNotaResponse();
			libro.decrementoImporteNotas(compraNota.getImporteTotalNota(),
					compraNota.getCreditoFiscalNota(), 
					pUsuarioUltimaModificacion,
					new CompraNotaId(compraNota.getId()));
			} catch (QueryNotRegisteredError e) {
			LOG.error(e.getCause().toString(), e);
		} catch (QueryHandlerExecutionError e) {
			LOG.error(e.getCause().toString(), e);
		}
    	   
       }
        
        try {
        repository.save(libro);
        } catch (Exception excepcion) {
	  		
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





