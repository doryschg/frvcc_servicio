package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import org.reflections.Reflections;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Service
public final class DomainEventSubscribersInformation {
    HashMap<Class<?>, DomainEventSubscriberInformation> information;

    public DomainEventSubscribersInformation(HashMap<Class<?>, DomainEventSubscriberInformation> information) {
        this.information = information;
    }

    public DomainEventSubscribersInformation() {
        this(scanDomainEventSubscribers());
    }

    private static HashMap<Class<?>, DomainEventSubscriberInformation> scanDomainEventSubscribers() {
        Reflections reflections = new Reflections("bo.gob.sin.sre.fac.frvcc");
        Set<Class<?>> subscribers = reflections.getTypesAnnotatedWith(DomainEventSubscriber.class);

        HashMap<Class<?>, DomainEventSubscriberInformation> subscribersInformation = new HashMap<>();

        for (Class<?> subscriberClass : subscribers) {
            DomainEventSubscriber annotation = subscriberClass.getAnnotation(DomainEventSubscriber.class);

            subscribersInformation.put(
                    subscriberClass,
                    new DomainEventSubscriberInformation(subscriberClass, Arrays.asList(annotation.value()))
            );
        }

        return subscribersInformation;
    }

    public Collection<DomainEventSubscriberInformation> all() {
        return information.values();
    }




}
