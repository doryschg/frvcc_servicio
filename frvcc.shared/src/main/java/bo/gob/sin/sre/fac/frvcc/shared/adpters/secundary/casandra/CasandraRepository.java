package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.casandra;

import com.datastax.oss.driver.api.core.CqlSession;

public abstract class CasandraRepository<T> {

    private CqlSession session = DaoNoSQLConfig.openSession();


    protected CqlSession getSession(){
        return session;
    }

}
