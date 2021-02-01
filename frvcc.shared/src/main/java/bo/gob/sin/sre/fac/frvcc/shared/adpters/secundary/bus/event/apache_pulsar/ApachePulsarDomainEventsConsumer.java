package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventJsonDeserializer;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.DomainEventSubscribersInformation;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/*@Primary*/
//@Service
public final class ApachePulsarDomainEventsConsumer {
    private final DomainEventJsonDeserializer deserializer;
    private final List<Consumer> consumers;
    private DomainEventSubscribersInformation information;
    private final HashMap<String, Object> domainEventSubscribers = new HashMap<>();
    private final ApplicationContext context;
    private HashMap<String, String> queueNameForEventName;


    public ApachePulsarDomainEventsConsumer(DomainEventJsonDeserializer deserialize, DomainEventSubscribersInformation information, List<Consumer> consumers, ApplicationContext context, HashMap<String, String> queueNameForEventName) {
        this.deserializer = deserialize;
        this.consumers = consumers;
        this.information = information;
        this.context = context;
        this.queueNameForEventName = queueNameForEventName;
    }

    public void consume() {

    }

    private void consume(Consumer consumer) {
        try {
            Message ms = consumer.receive();
            consumer(new String(ms.getData()));
            consumer.acknowledge(ms);
        } catch (PulsarClientException e) {
            System.out.println("no hay mensaje");
        }
    }

    //TODO Refactorización de codigo
    public void consumer(String serializedMessage) {

        try {
            DomainEvent  domainEvent = deserializer.deserialize(serializedMessage);
           queueNameForEventName.entrySet().stream()
                    .filter(cola -> cola.getValue().equals(domainEvent.eventName()) || cola.getValue().length() == 0)
                    .forEach(cola -> {
                                try {
                                    consumirCola(cola.getKey(),
                                            cola.getValue().length() != 0 ? domainEvent.getClass() : domainEvent.getClass().getSuperclass() ,
                                            domainEvent);
                                } catch (Exception e) {
                                    System.out.println("errror");
                                }
                            }
                    );
        } catch (InvocationTargetException | IllegalAccessException
                | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }


    }

    private Object subscriberFor(String cola) throws Exception {
        String[] queueParts = cola.split("\\.");
        String subscriberName = Utils.toCamelFirstLower(queueParts[queueParts.length - 1]);

        try {
            Object subscriber = context.getBean(subscriberName);
            domainEventSubscribers.put(cola, subscriber);
            return subscriber;
        } catch (Exception e) {
            throw new Exception(String.format("There are not registered subscribers for <%s> cola", cola));
        }
    }

    public void consumir(Consumer<byte[]> consumers) {
        while (true) {
            consume(consumers);
        }
    }

    private void consumirCola(String cola, Class<?> domainEventClass, DomainEvent domainEvent) throws Exception {
        Object subscriber = domainEventSubscribers.containsKey(cola)
                ? domainEventSubscribers.get(cola)
                : subscriberFor(cola);
        Method subscriberOnMethod = subscriber.getClass().getMethod("on", domainEventClass);
        subscriberOnMethod.invoke(subscriber, domainEvent);
    }
}
