package bo.gob.sin.sre.fac.frvcc.misfacturas.service.hformularios;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.hformularios.HFormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;


@Service
public final class HFormularioCreator {
	private static final Logger LOG= LoggerFactory.getLogger(HFormularioCreator.class);
    private final HFormularioRepository repository;
    private final EventBus eventBus;

    public HFormularioCreator(HFormularioRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }
    public void create(HFormulario formulario){

        if(!repository.search(formulario.id()).isPresent()){
        	try {
				
            repository.save(formulario);
        	} catch (Exception excepcion) {
    	  		LOG.error(excepcion.getCause().toString(), excepcion);
			}
            eventBus.publish(formulario.pullDomainEvents());
        }
    }
}
