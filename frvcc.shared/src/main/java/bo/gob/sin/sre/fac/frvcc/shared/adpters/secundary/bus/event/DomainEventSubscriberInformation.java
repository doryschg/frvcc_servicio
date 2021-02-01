package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event;


import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.util.List;

public final class DomainEventSubscriberInformation {
    private final Class<?> subscriberClass;
    private final List<Class<? extends DomainEvent>> subscribedEvents;

    public DomainEventSubscriberInformation(
            Class<?> subscriberClass,
            List<Class<? extends DomainEvent>> subscribedEvents
    ) {
        this.subscriberClass  = subscriberClass;
        this.subscribedEvents = subscribedEvents;
    }

    public Class<?> subscriberClass() {
        return subscriberClass;
    }

    public String contextName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return String.format("%s_%s",nameParts[3],nameParts[4]);
    }

    public String moduleName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[5];
    }

    public String className() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[nameParts.length - 1];
    }

    public List<Class<? extends DomainEvent>> subscribedEvents() {
        return subscribedEvents;
    }


    public String formatApachePulsarQueueName() {
        return String.format("%s", Utils.toSnake(className()));
    }
}
