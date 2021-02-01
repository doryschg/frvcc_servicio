package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar_tipo_compra_libro;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores_libro_compras.LibroCompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_tipo_compra_libro.ICompraModificadorTipoCompraLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class CompraModificadorTipoCompraLibroServiceImpl implements ICompraModificadorTipoCompraLibro {
    private static final Logger LOG = LoggerFactory.getLogger(CompraModificadorTipoCompraLibroServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final LibroCompraValidador validador;

    public CompraModificadorTipoCompraLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus,
                                                       LibroCompraValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador = pValidador;
    }

    @Override
    public void modificarTipoCompra(CompraId pId, CompraTipoCompraId pTipoCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion)
            throws QueryNotRegisteredError, QueryHandlerExecutionError {

        Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraListaErrores(pId, validador.crearValidacionCompraNoExiste()));

        vCompra.modificarTipoCompra(pTipoCompra, pUsuarioUltimaModificacion);
        try {
            repository.guardar(vCompra);
            LOG.info("compra editada {}", vCompra.tipoCompraId());
        } catch (Exception excepcion) {
            LOG.error(excepcion.getCause().toString(), excepcion);
            throw new CompraListaErrores(pId, crearValidacionException());

        }
        eventBus.publish(vCompra.pullDomainEvents());


    }


    private ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_EDICION.getId()));
            }
        });
    }


}
