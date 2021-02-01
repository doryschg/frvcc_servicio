package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.config.ParameterNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate.HibernateConfigurationFactory;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes.IContribuyentesHibernateConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class ContribuyentesHibernateConfiguration implements IContribuyentesHibernateConfiguration{
    private final Environment env;



    public ContribuyentesHibernateConfiguration(Environment env) {

        this.env = env;

}

    @Bean("contribuyentes-session-factory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean("contribuyentes-data_source")
    public DataSource dataSource()  {


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("bar.datasource.driver"));
        dataSource.setUrl(env.getRequiredProperty("bar.datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("bar.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("bar.datasource.password"));
        return dataSource;

    }


    public Properties hibernateProperties()  {

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getRequiredProperty("bar.hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getRequiredProperty("bar.hibernate.show_sql"));
        hibernateProperties.put("hibernate.jdbc.batch_size", env.getRequiredProperty("bar.hibernate.batch.size"));
        hibernateProperties.put("hibernate.bytecode.use_reflection_optimizer", env.getRequiredProperty("bar.hibernate.bytecode.use_reflection_optimizer"));
        hibernateProperties.put("hibernate.connection.driver_class", env.getRequiredProperty("bar.hibernate.connection.driver_class"));
        hibernateProperties.put("hibernate.connection.username", env.getRequiredProperty("bar.hibernate.connection.username"));
        hibernateProperties.put("hibernate.connection.password", env.getRequiredProperty("bar.hibernate.connection.password"));
        hibernateProperties.put("hibernate.connection.url", env.getRequiredProperty("bar.hibernate.connection.url"));
        hibernateProperties.put("org.hibernate.envers.audit_table_suffix", "_AUDIT_LOG");

        hibernateProperties.put("hibernate.c3p0.acquire_increment",env.getRequiredProperty("bar.hibernate.c3p0.acquire_increment" ));
        hibernateProperties.put("hibernate.c3p0.min_size",env.getRequiredProperty("bar.hibernate.c3p0.min_size"));
        hibernateProperties.put("hibernate.c3p0.max_size",env.getRequiredProperty("bar.hibernate.c3p0.max_size"));
        hibernateProperties.put("hibernate.c3p0.max_statements",env.getRequiredProperty("bar.hibernate.c3p0.max_statements"));
        hibernateProperties.put("hibernate.c3p0.timeout",env.getRequiredProperty("bar.hibernate.c3p0.timeout"));

        return hibernateProperties;
    }

    @Bean("contribuyentes-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws ParameterNotExist {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }
}
