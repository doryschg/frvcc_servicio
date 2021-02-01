package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes;


import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.config.ParameterNotExist;

import javax.sql.DataSource;
import java.util.Properties;

public interface IContribuyentesHibernateConfiguration {
    LocalSessionFactoryBean sessionFactory() throws ParameterNotExist;
    DataSource dataSource() throws ParameterNotExist;
     Properties hibernateProperties() throws ParameterNotExist;
    PlatformTransactionManager hibernateTransactionManager() throws ParameterNotExist;
}
