package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.habilitar_rectificacion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.habilitar_rectificacion.ICompraCancelarDeclaracionCambiarIdFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public  class CompraCancelarDeclaracionCambiarIdFormularioServiceImpl implements ICompraCancelarDeclaracionCambiarIdFormulario {
	private static final Logger LOG= LoggerFactory.getLogger(CompraCancelarDeclaracionCambiarIdFormularioServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;

    public CompraCancelarDeclaracionCambiarIdFormularioServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void cancelarDeclaracion(CompraFormularioId formularioId,String pIdFormularioRectificado) {
    //	TODO: refactorizar y optimizar segun json de ids compras
        Criteria criteria = new Criteria (
                new Filters(Arrays.asList(
                        Filter.create("formularioId", "=",formularioId.value()))), Order.none()
        );
        List<Compra> compras = repository.matching(criteria).getContent().stream().collect(Collectors.toList());
        List<Compra> comprasEditadas=new ArrayList<Compra>();
        for (Compra com : compras) {
			Compra compraeditada=desDeclararCompracambiarIdFormulario(com,pIdFormularioRectificado);
			comprasEditadas.add(compraeditada);
		}
        
        repository.guardarTodo(comprasEditadas);
        compras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
    }
  
    private Compra desDeclararCompracambiarIdFormulario(Compra pCompra,String pFormularioId)
    {
    	pCompra.desdeclararCompraPorRectificacion(new CompraFormularioId(pFormularioId));
        return pCompra;
    }
}
