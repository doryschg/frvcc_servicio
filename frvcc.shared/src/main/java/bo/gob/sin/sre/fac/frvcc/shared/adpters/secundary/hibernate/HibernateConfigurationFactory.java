package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public final class HibernateConfigurationFactory {
    private final ResourcePatternResolver resourceResolver;

    public HibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        this.resourceResolver = resourceResolver;

    }

    public PlatformTransactionManager hibernateTransactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());

        return transactionManager;
    }

    public LocalSessionFactoryBean sessionFactory( InputStreamResource[] inputStreamResources, DataSource dataSource, Properties properties) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setMappingLocations( inputStreamResources);

        return sessionFactory;
    }

    public DataSource dataSource(
            String url,
            String username,
            String password,
            String driverClassName

    )  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(
                String.format(
                        "%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        url
                )
        );
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
    public DataSource dataSource(
        String host,
        String driverClassName,
        Integer port,
        String databaseName,
        String username,
        String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(
            String.format(
                "%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                host,
                port,
                databaseName
            )
        );
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    private List<Resource> searchMappingFiles(String contextName) {
        List<String> modules   = subdirectoriesFor(contextName);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor(String contextName) {



        String path = contextName;

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            path  =contextName;
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

}
