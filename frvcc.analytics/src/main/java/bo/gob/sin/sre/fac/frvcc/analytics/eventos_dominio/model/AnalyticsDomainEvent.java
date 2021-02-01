package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model;



public final class AnalyticsDomainEvent  {
    private final AnalyticsDomainEventId          id;
    private final AnalyticsDomainEventAggregateId aggregateId;
    private final AnalyticsDomainEventName        name;
    private final AnalyticsDomainEventBody        body;
    private final AnalyticsDomainEventOccurredOn occurredOn;
public AnalyticsDomainEvent(){
    occurredOn = null;
    body = null;
    name = null;
    aggregateId = null;
    id = null;
}

    public AnalyticsDomainEvent(
            AnalyticsDomainEventId id,
            AnalyticsDomainEventAggregateId aggregateId,
            AnalyticsDomainEventName name,
            AnalyticsDomainEventBody body,
            AnalyticsDomainEventOccurredOn occurredOn) {

        this.id          = id;
        this.aggregateId = aggregateId;
        this.name        = name;
        this.body        = body;
        this.occurredOn = occurredOn;
    }

    public AnalyticsDomainEventId id() {
        return id;
    }

    public AnalyticsDomainEventAggregateId aggregateId() {
        return aggregateId;
    }

    public AnalyticsDomainEventName name() {
        return name;
    }

    public AnalyticsDomainEventBody body() {
        return body;
    }

    public AnalyticsDomainEventOccurredOn occurredOn() {
        return occurredOn;
    }
}
