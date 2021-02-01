package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.adapters.secondary.sql2o;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.sql2o.Sql2o;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.RandomBasedGenerator;

/**
 * RepositoryConfig define la configuracion basica para los repositorios de
 * datos.
 *
 * @author vigmarcarlo
 * @version 14/07/2020
 */
public class RepositoryConfig {

    private static Sql2o sql2o;
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static RandomBasedGenerator randomBasedGenerator;

    public static Sql2o getSql2o() {
        if (sql2o == null) {
            sql2o = getSql2o(
                    resourceBundle.getString("datasource.driver"),
                    resourceBundle.getString("datasource.url"),
                    resourceBundle.getString("datasource.username"),
                    resourceBundle.getString("datasource.password"));
        }
        return sql2o;
    }

    public static Sql2o getSql2o(String driver, String url, String username, String password) {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            sql2o = new Sql2o(dataSource);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sql2o;
    }

    public static RandomBasedGenerator getRandomBasedGenerator() {
        if (randomBasedGenerator == null)
            randomBasedGenerator = Generators.randomBasedGenerator();
        return randomBasedGenerator;
    }

}
