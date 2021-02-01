package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.recepcion;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.recepcion.IRecepcionRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate.HibernateRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
@Transactional("misfacturasVentas-transaction_manager")
public class PostgreSqlRecepcionRepository extends HibernateRepository<Recepcion> implements IRecepcionRepository {

	public PostgreSqlRecepcionRepository(@Qualifier("misfacturasVentas-session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, Recepcion.class);
	}

	@Override
	public void guardar(Recepcion recepcion) {
		save(recepcion);

	}

	@Override
	public Optional<Recepcion> findById(RecepcionId id) {
		return byId(id);
	}

	@Override
	public List<Recepcion> matching(Criteria criteria) {
		return byCriteria(criteria);
	}
}
