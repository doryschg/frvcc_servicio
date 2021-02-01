package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.declarar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.EstadoUsoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar.IComprasDeclarar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class ComprasDeclaradorServiceImpl implements IComprasDeclarar {
	private static final Logger LOG = LoggerFactory.getLogger(CompraDeclaradorServiceImpl.class);
	private final CompraRepository repository;
	private final EventBus eventBus;

	public ComprasDeclaradorServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	@Override
	public void declarar(CompraFormularioId pFormularioId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Criteria vCriteria = new Criteria(
				new Filters(Arrays.asList(Filter.create("formularioId", "=", pFormularioId.value()),
						Filter.create("estadoUsoId", "=", EstadoUsoId.ASIGNADO.value())
				)),
				Order.none());

		List<Compra> vCompras = repository.matching(vCriteria).getContent().stream().map(compra -> declararCompra(compra, pUsuarioUltimaModificacion))
				.collect(Collectors.toList());
		try{
			repository.guardarTodo(vCompras);
			vCompras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
		}catch (Exception excepcion)
		{
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
	}

	private Compra declararCompra(Compra pCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		pCompra.declararCompra(pUsuarioUltimaModificacion);
		return pCompra;
	}
}
