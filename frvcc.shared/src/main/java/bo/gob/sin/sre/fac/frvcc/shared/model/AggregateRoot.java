package bo.gob.sin.sre.fac.frvcc.shared.model;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {

	private List<DomainEvent> domainEvents = new ArrayList<>();
	private TotalPages totalPages;

	final public List<DomainEvent> pullDomainEvents() {
		List<DomainEvent> events = domainEvents;

		domainEvents =  new ArrayList<>();

		return events;
	}

	final protected void record(DomainEvent event) {
		domainEvents.add(event);
	}

	public TotalPages totalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = new TotalPages(totalPages);
	}
}
