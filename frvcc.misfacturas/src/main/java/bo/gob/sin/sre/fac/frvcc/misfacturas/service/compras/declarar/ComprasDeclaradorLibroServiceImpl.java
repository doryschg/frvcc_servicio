package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar.IComprasDeclararLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class ComprasDeclaradorLibroServiceImpl implements IComprasDeclararLibro {
	private static final Logger LOG= LoggerFactory.getLogger(CompraDeclaradorLibroServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    
    public ComprasDeclaradorLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }
	@Override
	  public void declarar(CompraLibroId pLibroId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        //	TODO: refactorizar y optimizar segun json de ids compras
            Criteria vCriteria = new Criteria (
                    new Filters(Arrays.asList(
                            Filter.create("libroId", "=",pLibroId.value())
                    		,Filter.create("estadoId", "=", "AC"))), Order.none()
            );

            List<Compra> vCompras = repository.matching(vCriteria).getContent()
                    .stream()
                    .map(compra -> declararCompra(compra,pUsuarioUltimaModificacion))
                    .collect(Collectors.toList());
            repository.guardarTodo(vCompras);
            vCompras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
        }

        private Compra declararCompra(Compra pCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion){
            pCompra.declararCompra(pUsuarioUltimaModificacion);
            return pCompra;
        }

}
