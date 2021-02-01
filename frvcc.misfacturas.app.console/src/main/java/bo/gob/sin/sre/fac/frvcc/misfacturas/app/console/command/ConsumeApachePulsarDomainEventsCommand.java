package bo.gob.sin.sre.fac.frvcc.misfacturas.app.console.command;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventSubscribersInformation;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar.ApachePulsarDomainEventsConsumer;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.cli.ConsoleCommand;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.apache.pulsar.client.api.*;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Primary
@Service
public final class ConsumeApachePulsarDomainEventsCommand extends ConsoleCommand {

    public static String CONSUMER_NAME = "Mis Facturas";
    private final ApachePulsarDomainEventsConsumer consumer;
    private final DomainEventSubscribersInformation domainEventSubscribersInformation;
    private final PulsarClient connection;
    private final Environment env;


    public ConsumeApachePulsarDomainEventsCommand(ApachePulsarDomainEventsConsumer consumer, DomainEventSubscribersInformation domainEventSubscribersInformation, PulsarClient connection, Environment env) {
        this.consumer = consumer;
        this.domainEventSubscribersInformation = domainEventSubscribersInformation;
        this.connection = connection;
        this.env = env;
    }



    private Consumer<byte[]> consumer(){
        try {

            String tentan = env.getProperty("apache-pulsar-tenant");
            return connection.newConsumer(Schema.BYTES)
                    .topics(domainEventSubscribersInformation.all().stream().map(x -> {
                             return    "persistent://"+tentan+"/sre_fac_frvcc/"+x.formatApachePulsarQueueName();
                            }

                    ).collect(Collectors.toList()))
                    .subscriptionType(SubscriptionType.Shared)
                    .subscriptionName(CONSUMER_NAME)
                    .subscribe();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  void execute(String[] args) {
        consumer.consumir(consumer());
    }
}
