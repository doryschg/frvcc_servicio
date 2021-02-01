package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.service.store;


import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.secundary.DomainEventsRepository;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public final class DomainEventStorer {
    private DomainEventsRepository repository;

    public DomainEventStorer(DomainEventsRepository repository) {
        this.repository = repository;
    }

    public void store(
            AnalyticsDomainEventId id,
            AnalyticsDomainEventAggregateId aggregateId,
            AnalyticsDomainEventName name,
            AnalyticsDomainEventBody body,
            AnalyticsDomainEventOccurredOn occurredOn) {

        if(!repository.search(id).isPresent()){
            AnalyticsDomainEvent domainEvent = new AnalyticsDomainEvent(id, aggregateId, name, body, occurredOn);
            repository.save(domainEvent);
        }



    }
}
