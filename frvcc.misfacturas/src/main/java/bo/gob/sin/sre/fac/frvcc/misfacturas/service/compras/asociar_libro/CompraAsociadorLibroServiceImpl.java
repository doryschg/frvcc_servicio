package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asociar_libro;


import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.libros.LibroResponse;
//import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.libros.LibroRespuesta;
//import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.libros.find.FindLibroQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.asociar_libro.ICompraAsociarLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class CompraAsociadorLibroServiceImpl  implements ICompraAsociarLibro {
	private static final Logger LOG= LoggerFactory.getLogger(CompraAsociadorLibroServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;


    public CompraAsociadorLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
    }
    
    @Override
    public void asociarLibro(CompraId pId,
                        CompraLibroId pLibroId,
                        CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                        CompraPeriodoUso pPeriodoUso,
                        CompraGestionUso pGestionUso,
                        CompraNombreFormularioUso pNombreFormulrioUso
                        ) throws QueryNotRegisteredError, QueryHandlerExecutionError {
    	LOG.info("compra id {}. formulario id {}. usuario {}.", pId,pLibroId,pUsuarioUltimaModificacion);
        Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
         
        try {
        vCompra.asociarALibro(pLibroId,pUsuarioUltimaModificacion,pPeriodoUso,pGestionUso,pNombreFormulrioUso);
        LOG.info("creditoFiscal {}", vCompra.creditoFiscal().value());
        LOG.info("importe credito fiscal {}", vCompra.importeBaseCf().value());

        repository.guardar(vCompra);
        } catch (Exception excepcion) {
        	excepcion.printStackTrace();
			LOG.error(excepcion.getMessage(), excepcion);
            throw new CompraListaErrores(pId, crearValidacionException());

		}
        eventBus.publish(vCompra.pullDomainEvents());
    }
    private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_ASOCIACION_COMPRAS.getId()));
        }});
    }

}
