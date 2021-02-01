package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventJsonSerializer;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventsInformation;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.List;


//@Service
public final class ApachePulsarPublisher {
    private final List<Producer<byte[]>> producers;
    private final HashMap<String, String> queueNameForEventName;
    private final DomainEventsInformation domainEventsInformation;
    private final Environment env;

    public ApachePulsarPublisher(List<Producer<byte[]>> producers, HashMap<String, String> queueNameForEventName, DomainEventsInformation domainEventsInformation, Environment env) {

        this.producers = producers;
        this.queueNameForEventName = queueNameForEventName;
        this.domainEventsInformation = domainEventsInformation;
        this.env = env;
    }

    public void publish(DomainEvent domainEvent, String exchangeName)  {
        String message = DomainEventJsonSerializer.serialize(domainEvent);
        String tentan = env.getProperty("apache-pulsar-tenant");

        String cola =  queueNameForEventName
                .entrySet()
                .stream()
                .filter(queue -> queue.getValue().equals(exchangeName) || queue.getValue().length() == 0)
                .map(queue -> queue.getKey())
                .findFirst().orElse(null);
        if(cola != null){
            producers.stream()
                    .filter(producer -> producer.getTopic().equals(String.format(
                            "%s/sre_fac_frvcc/%s"
                            ,tentan,cola)))
                    .forEach(producer -> {
                        try {
                            producer.send(message.getBytes());
                        } catch (PulsarClientException e) {
                            System.out.println("Error pulsar");
                        }
                    });
        }
    }
}
