package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.seccundary.libros;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
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
@Transactional("misfacturasLibros-transaction_manager")
public class PostgreSqlLibroRepository extends SpringDataRepository<Libro> implements LibroRepository {
    public PostgreSqlLibroRepository(@Qualifier("misfacturasLibros-session-factory")
                                                  SessionFactory sessionFactory) {

        super(sessionFactory, Libro.class);
    }

    @Override
    public void save(Libro Libro) {
        super.save(Libro);

    }
    @Override
    public Optional<Libro> search(LibroId id) {
        return byId(id);
    }



    @Override
    public Pagina<Libro> BuscarPorCriteria(Criteria criteria) {
        Page<Libro> vResult = this.findAll(criteria);

        return new Pagina<>(vResult.getTotalPages(),vResult.getTotalElements(),vResult.getContent());
    }

    @Override
	public Long countByCriteria(Criteria criteria) {
		return byCriteriaCount(criteria);
	}


}
