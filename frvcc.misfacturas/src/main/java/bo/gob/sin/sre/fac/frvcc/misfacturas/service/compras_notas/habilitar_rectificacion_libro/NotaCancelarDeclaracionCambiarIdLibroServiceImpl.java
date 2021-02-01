package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.habilitar_rectificacion_libro;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.habilitar_rectificacion_libro.INotaCancelarDeclaracionCambiarIdLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public  class NotaCancelarDeclaracionCambiarIdLibroServiceImpl implements INotaCancelarDeclaracionCambiarIdLibro {
	private static final Logger LOG= LoggerFactory.getLogger(NotaCancelarDeclaracionCambiarIdLibroServiceImpl.class);
    private final CompraNotaRepository repository;
    private final EventBus eventBus;

    public NotaCancelarDeclaracionCambiarIdLibroServiceImpl(CompraNotaRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void cancelarDeclaracion(CompraNotaLibroId libroId, String pIdLibroRectificado) {
        Criteria criteria = new Criteria (
                new Filters(Arrays.asList(
                        Filter.create("libroId", "=",libroId.value()))), Order.none()
        );
        List<CompraNota> comprasNotas = repository.matching(criteria).getContent().stream().collect(Collectors.toList());
        List<CompraNota> comprasNotasEditadas=new ArrayList<>();
        for (CompraNota comNota : comprasNotas) {
        	desDeclararNotacambiarIdLibro(comNota,pIdLibroRectificado);
        	comprasNotasEditadas.add(comNota);
		}
        try {
        	LOG.info("notas desdeclaradas {} ", comprasNotasEditadas);
        	 repository.guardarTodo(comprasNotasEditadas);

		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);		
			}
        comprasNotasEditadas.stream().forEach(nota -> eventBus.publish(nota.pullDomainEvents()));
       
    }
  
    private CompraNota desDeclararNotacambiarIdLibro(CompraNota pCompraNota,String pLibroId)
    {
    	pCompraNota.desdeclararNotaPorRectificacionLibro(new CompraNotaLibroId(pLibroId));
        return pCompraNota;
    }
}
