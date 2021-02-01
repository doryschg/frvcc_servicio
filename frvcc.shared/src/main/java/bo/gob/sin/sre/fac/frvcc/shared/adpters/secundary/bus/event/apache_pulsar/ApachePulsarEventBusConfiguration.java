package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar;



import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventSubscriberInformation;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventSubscribersInformation;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventsInformation;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


//@Configuration
public class ApachePulsarEventBusConfiguration {
    private final DomainEventSubscribersInformation domainEventSubscribersInformation;
    private final DomainEventsInformation domainEventsInformation;
    private final Environment env;

    public ApachePulsarEventBusConfiguration(
            DomainEventSubscribersInformation domainEventSubscribersInformation,
            DomainEventsInformation domainEventsInformation,
            Environment env
    ) {
        this.domainEventSubscribersInformation = domainEventSubscribersInformation;
        this.domainEventsInformation = domainEventsInformation;
        this.env = env;
    }

    @Bean
    public PulsarClient connection()
    {
        PulsarClient client = null;
        String url = env.getProperty("apache-pulsar.url");

        try {
            client = PulsarClient.builder()
                    .serviceUrl(url)
                    .build();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }

        return client;

    }

    @Bean
    public List<Producer<byte[]>> producers() {
        return domainEventSubscribersInformation.all().stream().map(this::producer).collect(Collectors.toList());
    }

    public Producer<byte[]> producer(DomainEventSubscriberInformation information) {
        try {
            String tentan = env.getProperty("apache-pulsar-tenant");
            return connection().newProducer(Schema.BYTES)
                    .topic(String.format("%s/sre_fac_frvcc/%s",tentan,information.formatApachePulsarQueueName()))
                    .sendTimeout(50, TimeUnit.MILLISECONDS)
                    .create();
        } catch (PulsarClientException e) {
            throw new RuntimeException(e);
        }
    }


    @Bean
    HashMap<String, String> queueNameForEventName() {
        return domainEventSubscribersInformation.all()
                .stream()
                .collect(Collectors.
                        toMap(DomainEventSubscriberInformation::formatApachePulsarQueueName,
                                DomainEventSubscriberInformation::subscribedEvents))
                .entrySet()
                .stream()
                .collect(HashMap::new, (m, e) -> e.getValue().forEach(k -> m.put(e.getKey(),
                        domainEventsInformation.forClass(k))), Map::putAll);

    }
}
