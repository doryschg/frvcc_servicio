package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.MisFacturasHibernateConfiguration;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary.MisFacturasLibrosHibernateConfiguration;

import javax.sql.DataSource;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class MisFacturasLibrosHibernateConfiguration {
    private final Environment env;

    public MisFacturasLibrosHibernateConfiguration( Environment env) {

        this.env = env;
    }


    @Bean("misfacturasLibros-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager()  {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }


    @Bean("misfacturasLibros-session-factory")
    public LocalSessionFactoryBean sessionFactory()  {
        InputStreamResource[] inputStreamResources = {
        		new InputStreamResource(MisFacturasHibernateConfiguration.class.getResourceAsStream(
                        "./formularios/persistence/hibernate/CustomTypes.hbm.xml")),
               new InputStreamResource(MisFacturasLibrosHibernateConfiguration.class.getResourceAsStream(
              "./libros/persistence/hibernate/Libro.hbm.xml"))
        		};
        


        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setMappingLocations( inputStreamResources);

        return sessionFactory;
    }
    @Bean("misfacturasLibros-data-source")
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("datasource.driver"));
        dataSource.setUrl(env.getRequiredProperty("datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("datasource.password"));
        return dataSource;
    }

    private Properties hibernateProperties()  {
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
}
