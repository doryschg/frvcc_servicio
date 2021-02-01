package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.GeneraNumeroOrdenRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;


@Service
@Transactional("contribuyentes-transaction_manager")
public  class JavaGeneraNumeroOrden implements GeneraNumeroOrdenRepository {

    private final SessionFactory sessionFactory;

    public JavaGeneraNumeroOrden(@Qualifier("contribuyentes-session-factory")
                                         SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long obtenerNumeroOrden(Integer codAdm) {
        Query query = sessionFactory
                .getCurrentSession()
                .getSession().createNativeQuery("select PSFE_UTILES.F_ObtenerNumeroOrden("+codAdm+") from dual");
      return  Long.valueOf(query.getSingleResult().toString());
    }
}
