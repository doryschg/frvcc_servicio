package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar.CompraDeclaradorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar.IComprasDeclararLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.declarar.IComprasNotasDeclararLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComprasNotasDeclaradorLibroServiceImpl implements IComprasNotasDeclararLibro {
	private static final Logger LOG= LoggerFactory.getLogger(CompraDeclaradorLibroServiceImpl.class);
    private final CompraNotaRepository repository;
    private final EventBus eventBus;
    
    public ComprasNotasDeclaradorLibroServiceImpl(CompraNotaRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }
	@Override
	  public void declarar(CompraNotaLibroId pLibroId, CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        //	TODO: refactorizar y optimizar segun json de ids compras
            Criteria vCriteria = new Criteria (
                    new Filters(Arrays.asList(
                            Filter.create("libroId", "=",pLibroId.value())
                    		,Filter.create("estadoId", "=", "AC"))), Order.none()
            );

            List<CompraNota> vCompras = repository.matching(vCriteria).getContent()
                    .stream()
                    .map(compra -> declararCompraNota(compra,pUsuarioUltimaModificacion))
                    .collect(Collectors.toList());
            repository.guardarTodo(vCompras);
            vCompras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
        }

        private CompraNota declararCompraNota(CompraNota pCompra, CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion){
            pCompra.declararCompraNota(pUsuarioUltimaModificacion);
            return pCompra;
        }

}
