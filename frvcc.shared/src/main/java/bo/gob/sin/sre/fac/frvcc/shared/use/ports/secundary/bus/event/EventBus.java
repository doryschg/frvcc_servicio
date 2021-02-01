package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);

}
