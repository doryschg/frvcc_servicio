package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.secundary;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.config.ParameterNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AnalyticsHibernateConfiguration {
    private final HibernateConfigurationFactory factory;

    private final Environment env;

    public AnalyticsHibernateConfiguration(HibernateConfigurationFactory factory,  Environment env) {
        this.factory = factory;

        this.env = env;
    }

    @Bean("analytics-session-factory")
    public LocalSessionFactoryBean sessionFactory() {
          LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        InputStreamResource[] inputStreamResources = {
                new InputStreamResource(AnalyticsHibernateConfiguration.class.getResourceAsStream("./persistence/hibernate/DomianEvent.hbm.xml"))
        };
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setMappingLocations( inputStreamResources);
          return sessionFactory;
    }



    @Bean("analytics-data-source")
    public DataSource dataSource()  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("datasource.driver"));
        dataSource.setUrl(env.getRequiredProperty("datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("datasource.password"));
        return dataSource;
    }

    public Properties hibernateProperties()  {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.jdbc.batch_size", env.getRequiredProperty("hibernate.batch.size"));
        hibernateProperties.put("hibernate.bytecode.use_reflection_optimizer", env.getRequiredProperty("hibernate.bytecode.use_reflection_optimizer"));
        hibernateProperties.put("hibernate.connection.driver_class", env.getRequiredProperty("hibernate.connection.driver_class"));
        hibernateProperties.put("hibernate.connection.username", env.getRequiredProperty("hibernate.connection.username"));
        hibernateProperties.put("hibernate.connection.password", env.getRequiredProperty("hibernate.connection.password"));
        hibernateProperties.put("hibernate.connection.url", env.getRequiredProperty("hibernate.connection.url"));
        hibernateProperties.put("hibernate.jdbc.lob.non_contextual_creation", true);
        hibernateProperties.put("org.hibernate.envers.audit_table_suffix", "_AUDIT_LOG");
        return hibernateProperties;

    }
    @Bean("analytics-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }
}
