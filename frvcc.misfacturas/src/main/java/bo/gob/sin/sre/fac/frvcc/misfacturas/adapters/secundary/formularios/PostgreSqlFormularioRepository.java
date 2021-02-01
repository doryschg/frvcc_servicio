package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("misfacturas-transaction_manager")
public class PostgreSqlFormularioRepository extends SpringDataRepository<Formulario> implements FormularioRepository {
    public PostgreSqlFormularioRepository(@Qualifier("misfacturas-session-factory")
                                                  SessionFactory sessionFactory) {

        super(sessionFactory, Formulario.class);
    }

    @Override
    public void save(Formulario formulario) {
        super.save(formulario);

    }
    @Override
    public Optional<Formulario> search(FormularioId id) {
        return byId(id);
    }
    @Override
    public Optional<Formulario> findById(FormularioId id) {
        return byId(id);
    }



    @Override
    public Pagina<Formulario> BuscarPorCriteria(Criteria criteria) {
        Page<Formulario> vResult = this.findAll(criteria);

        return new Pagina<>(vResult.getTotalPages(),vResult.getTotalElements(),vResult.getContent());
    }

    @Override
	public Long countByCriteria(Criteria criteria) {
		return byCriteriaCount(criteria);
	}
}
