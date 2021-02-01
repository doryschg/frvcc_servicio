package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar.ICompraDeclarar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public  class CompraDeclaradorServiceImpl implements ICompraDeclarar {
	private static final Logger LOG= LoggerFactory.getLogger(CompraDeclaradorServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;

    public CompraDeclaradorServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void declarar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        Compra compra = repository.findById(pId).orElseThrow(() -> new CompraNotExist(pId));
        compra.declararCompra(pUsuarioUltimaModificacion);
        try {
        repository.guardar(compra);
        } catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
        eventBus.publish(compra.pullDomainEvents());
    }

    @Override
    public void declarar(CompraFormularioId pFormularioId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
    //	TODO: refactorizar y optimizar segun json de ids compras
        Criteria vCriteria = new Criteria (
                new Filters(Arrays.asList(
                        Filter.create("formularioId", "=",pFormularioId.value()))), Order.none()
        );

        List<Compra> compras = repository.matching(vCriteria).getContent()
                .stream()
                .map(compra -> declararCompra(compra, pUsuarioUltimaModificacion))
                .collect(Collectors.toList());
        repository.guardarTodo(compras);
        compras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
    }

    private Compra declararCompra(Compra pCompra,  CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion){
        pCompra.declararCompra(pUsuarioUltimaModificacion);
        return pCompra;
    }
}
