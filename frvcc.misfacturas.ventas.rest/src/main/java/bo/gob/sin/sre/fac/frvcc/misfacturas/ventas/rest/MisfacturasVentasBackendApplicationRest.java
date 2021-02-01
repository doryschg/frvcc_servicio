package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, CassandraAutoConfiguration.class })
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class), value = {
		"bo.gob.sin.sre.fac.frvcc.misfacturas","bo.gob.sin.sre.fac.frvcc.misfacturas.ventas",
		"bo.gob.sin.sre.fac.frvcc.shared", "bo.gob.sin.sre.fac.frvcc.analytics",
		"bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend" })
public class MisfacturasVentasBackendApplicationRest {

	public static void main(String[] args) {
		SpringApplication.run(MisfacturasVentasBackendApplicationRest.class);
	}
}
