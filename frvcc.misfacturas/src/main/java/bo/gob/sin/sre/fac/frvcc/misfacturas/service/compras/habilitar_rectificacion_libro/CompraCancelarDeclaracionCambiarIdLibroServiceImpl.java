package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.habilitar_rectificacion_libro;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.habilitar_rectificacion_libro.ICompraCancelarDeclaracionCambiarIdLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public  class CompraCancelarDeclaracionCambiarIdLibroServiceImpl implements ICompraCancelarDeclaracionCambiarIdLibro {
	private static final Logger LOG= LoggerFactory.getLogger(CompraCancelarDeclaracionCambiarIdLibroServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;

    public CompraCancelarDeclaracionCambiarIdLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void cancelarDeclaracion(CompraLibroId libroId, String pIdLibroRectificado) {
        Criteria criteria = new Criteria (
                new Filters(Arrays.asList(
                        Filter.create("libroId", "=",libroId.value()))), Order.none()
        );
        List<Compra> compras = repository.matching(criteria).getContent().stream().collect(Collectors.toList());
        List<Compra> comprasEditadas=new ArrayList<>();
        for (Compra com : compras) {
			Compra compraeditada=desDeclararCompracambiarIdLibro(com,pIdLibroRectificado);
			comprasEditadas.add(compraeditada);
		}
        try {
        	 repository.guardarTodo(comprasEditadas);

		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);		}
               compras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
    }
  
    private Compra desDeclararCompracambiarIdLibro(Compra pCompra,String pLibroId)
    {
    	pCompra.desdeclararCompraPorRectificacionLibro(new CompraLibroId(pLibroId));
        return pCompra;
    }
}
