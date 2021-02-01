package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.Consolidacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.consolidaciones.IConsolidacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional("misfacturas-transaction_manager")
public class PostgreSqlConsolidacionRepository extends SpringDataRepository<Consolidacion> implements IConsolidacionRepository {

	public PostgreSqlConsolidacionRepository(@Qualifier("misfacturas-session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, Consolidacion.class);
	}

	@Override
	public void guardar(Consolidacion pConsolidacion) {

		super.save(pConsolidacion);
	}

	@Override
	public void guardarTodo(List<Consolidacion> pConsolidacion) {
		super.persisteAll(pConsolidacion);
	}

	@Override
	public Optional<Consolidacion> findById(ConsolidacionId id) {
		return byId(id);

	}
	@Override
	public Optional<Consolidacion> BuscarConsolidacionExistente(Consolidacion pConsolidacion) {

		Filters filters = new Filters(Arrays.asList(
				Filter.create("nitAgente","=",pConsolidacion.nitAgente().value().toString()),
				Filter.create("sucursal","=","0"),
				Filter.create("gestion","=",pConsolidacion.gestion().value().toString()),
				Filter.create("periodo","=",pConsolidacion.periodo().value().toString()),
				Filter.create("tipoId","=",pConsolidacion.tipoId().value()),
				Filter.create("estadoConsolidadoId","=",ConstEstado.ESTADO_ACTIVO),
				Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO)
		).stream().filter(filter -> filter !=null).collect(Collectors.toList()));
		Criteria criteria = new Criteria(filters, Order.none(), Optional.of(Integer.valueOf(1)), Optional.empty());
		return  this.findAll(criteria).get().findFirst();
	}
	@Override
	public Pagina<Consolidacion> BuscarPorCriteria(Criteria criteria) {

		Page<Consolidacion> vResult = this.findAll(criteria);

		return new Pagina<>(vResult.getTotalPages(),vResult.getTotalElements(),vResult.getContent());
	}



}
