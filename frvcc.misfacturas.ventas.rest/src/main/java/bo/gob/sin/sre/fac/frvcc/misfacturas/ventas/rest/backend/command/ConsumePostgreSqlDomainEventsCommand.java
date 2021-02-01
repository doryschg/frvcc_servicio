package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.command;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.postgresql.PostgreSqlDomainEventsConsumer;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.cli.ConsoleCommand;

public final class ConsumePostgreSqlDomainEventsCommand extends ConsoleCommand {
	private final PostgreSqlDomainEventsConsumer consumer;

	public ConsumePostgreSqlDomainEventsCommand(PostgreSqlDomainEventsConsumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void execute(String[] args) {
		consumer.consume();
	}
}
