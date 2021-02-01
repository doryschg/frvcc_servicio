package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes.IVerificaContribuyenteNewton;

@Service
@Transactional("contribuyentes-transaction_manager")
public class VerificaContribuyenteNewton implements IVerificaContribuyenteNewton{

	private final SessionFactory sessionFactory;

    public VerificaContribuyenteNewton(@Qualifier("contribuyentes-session-factory")
                                         SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	public String esContribuyenteNewton(Long pNit) {
		Query query = sessionFactory
                .getCurrentSession()
                .getSession().createNativeQuery("select PSFE_UTILES.F_EsNewton("+pNit+") from dual");
      return  query.getSingleResult().toString();
	}

}
