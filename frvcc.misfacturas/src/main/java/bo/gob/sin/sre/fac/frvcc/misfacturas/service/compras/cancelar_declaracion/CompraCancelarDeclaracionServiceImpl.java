package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.cancelar_declaracion;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.EstadoUsoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.cancelar_declaracion.ICompraCancelarDeclaracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public  class CompraCancelarDeclaracionServiceImpl implements ICompraCancelarDeclaracion {
	private static final Logger LOG= LoggerFactory.getLogger(CompraCancelarDeclaracionServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;

    public CompraCancelarDeclaracionServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void cancelarDeclaracion(CompraFormularioId pFormularioId, CompraUsuarioUltimaModificacion pCompraUsuarioUltimaModificacion) {
          Criteria vCriteria = new Criteria (
                new Filters(Arrays.asList(
                        Filter.create("formularioId", "=",pFormularioId.value()),
                        Filter.create("estadoUsoId", "=", EstadoUsoId.DECLARADO.value())))
                ,Order.none());
        List<Compra> vCompras = repository.matching(vCriteria).getContent().stream().map(compra -> desdeclararCompra(compra,pCompraUsuarioUltimaModificacion)).collect(Collectors.toList());
        try {
            repository.guardarTodo(vCompras);
            vCompras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
        }catch (Exception excepcion){
            LOG.error(excepcion.getCause().toString(), excepcion);
        }
    }

    private Compra desdeclararCompra(Compra pCompra, CompraUsuarioUltimaModificacion pCompraUsuarioUltimaModificacion){
        pCompra.cancelarDeclaracionCompra(pCompraUsuarioUltimaModificacion);
        return pCompra;
    }
}
