package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.hformularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormularioHistoricoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.hformularios.HFormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate.HibernateRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("misfacturas-transaction_manager")
public class PostgreSqlHFormularioRepository extends HibernateRepository<HFormulario> implements HFormularioRepository {
    public PostgreSqlHFormularioRepository(@Qualifier("misfacturas-session-factory")
                                                  SessionFactory sessionFactory) {

        super(sessionFactory, HFormulario.class);
    }

    @Override
    public void save(HFormulario formulario) {
        super.save(formulario);

    }
    @Override
    public Optional<HFormulario> search(HFormularioHistoricoId id) {
        return byId(id);
    }

    @Override
    public List<HFormulario> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
	public Long countByCriteria(Criteria criteria) {
		return byCriteriaCount(criteria);
	}

}
