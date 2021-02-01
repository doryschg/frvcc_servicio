package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.apache_pulsar;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.postgresql.PostgreSqlEventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

//@Primary
//@Service("ApachePulsarEventBus")
public class ApachePulsarEventBus implements EventBus {
	private final ApachePulsarPublisher publisher;
	private final PostgreSqlEventBus eventBus;

	public ApachePulsarEventBus(ApachePulsarPublisher publisher, PostgreSqlEventBus eventBus) {
		this.publisher = publisher;
		this.eventBus = eventBus;
	}

	@Override
	public void publish(List<DomainEvent> events) {
		events.forEach(this::publish);
	}

	private void publish(DomainEvent domainEvent) throws RuntimeException {
		try {
			this.publisher.publish(domainEvent, domainEvent.eventName());
		} catch (RuntimeException e) {
			eventBus.publish(domainEvent);
		}
	}
}
