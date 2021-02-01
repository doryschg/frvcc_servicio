package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DomainEventSubscriber {
    Class<? extends DomainEvent>[] value();

}
