package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.command;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventSubscribersInformation;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar.ApachePulsarDomainEventsConsumer;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.cli.ConsoleCommand;

//@Primary
//@Service
public final class ConsumeApachePulsarDomainEventsCommand extends ConsoleCommand {
	private final ApachePulsarDomainEventsConsumer consumer;
	private final DomainEventSubscribersInformation domainEventSubscribersInformation;
	private final PulsarClient connection;

	public ConsumeApachePulsarDomainEventsCommand(ApachePulsarDomainEventsConsumer consumer,
			DomainEventSubscribersInformation domainEventSubscribersInformation, PulsarClient connection) {
		this.consumer = consumer;
		this.domainEventSubscribersInformation = domainEventSubscribersInformation;
		this.connection = connection;
	}

	private Consumer<byte[]> consumer() {
		try {
			return connection.newConsumer(Schema.BYTES)
					.topics(domainEventSubscribersInformation.all().stream().map(x -> x.formatApachePulsarQueueName())
							.collect(Collectors.toList()))
					.ackTimeout(1, TimeUnit.SECONDS).subscriptionName(UUID.randomUUID().toString()).subscribe();
		} catch (PulsarClientException e) {
			return null;
		}
	}

	@Override
	public void execute(String[] args) {
		consumer.consumir(consumer());
	}
}
