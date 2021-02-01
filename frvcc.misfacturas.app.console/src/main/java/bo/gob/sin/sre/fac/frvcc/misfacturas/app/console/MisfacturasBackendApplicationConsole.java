package bo.gob.sin.sre.fac.frvcc.misfacturas.app.console;

import bo.gob.sin.sre.fac.frvcc.misfacturas.app.console.command.ConsumeApachePulsarDomainEventsCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.usuario.obtener.BuscarUsuarioQueryServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.cli.ConsoleCommand;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, CassandraAutoConfiguration.class })
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class), value = {
		"bo.gob.sin.sre.fac.frvcc.misfacturas", "bo.gob.sin.sre.fac.frvcc.shared", "bo.gob.sin.sre.fac.frvcc.analytics",
		"bo.gob.sin.sre.fac.frvcc.misfacturas.ventas" }, excludeFilters = {
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
						BuscarUsuarioQueryServiceImpl.class }) })
public class MisfacturasBackendApplicationConsole implements CommandLineRunner {

	public String[] COMMAND_TEXT = new String[] { "Console", "Mis Facturas" };
	private final ApplicationContext context;

	public MisfacturasBackendApplicationConsole(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(MisfacturasBackendApplicationConsole.class);

		app.run();

	}

	@Override
	public void run(String... args) throws Exception {
		ConsoleCommand command = (ConsoleCommand) this.context.getBean(ConsumeApachePulsarDomainEventsCommand.class);

		command.execute(COMMAND_TEXT);
	}
}
