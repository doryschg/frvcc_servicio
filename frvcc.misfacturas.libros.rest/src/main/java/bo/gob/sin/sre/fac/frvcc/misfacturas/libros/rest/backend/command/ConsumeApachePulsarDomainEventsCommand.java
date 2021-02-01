package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.command;



import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventSubscribersInformation;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar.ApachePulsarDomainEventsConsumer;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.cli.ConsoleCommand;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

//@Primary
//@Service
public final class ConsumeApachePulsarDomainEventsCommand extends ConsoleCommand {
    private final ApachePulsarDomainEventsConsumer consumer;
    private final DomainEventSubscribersInformation domainEventSubscribersInformation;
    private final PulsarClient connection;


    public ConsumeApachePulsarDomainEventsCommand(ApachePulsarDomainEventsConsumer consumer, DomainEventSubscribersInformation domainEventSubscribersInformation, PulsarClient connection) {
        this.consumer = consumer;
        this.domainEventSubscribersInformation = domainEventSubscribersInformation;
        this.connection = connection;
    }



    private Consumer<byte[]> consumer(){
        try {
            return connection.newConsumer(Schema.BYTES)
                    .topics(domainEventSubscribersInformation.all().stream().map(x -> x.formatApachePulsarQueueName()).collect(Collectors.toList()))
                    .ackTimeout(1, TimeUnit.SECONDS)
                    .subscriptionName(UUID.randomUUID().toString())
                    .subscribe();
        } catch (PulsarClientException e) {
            return null;
        }
    }

    @Override
    public void execute(String[] args) {
        consumer.consumir(consumer());
    }
}
