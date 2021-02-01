package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

import java.time.LocalDateTime;

public final class AnalyticsDomainEventResponse implements Response {
    private final String id;
    private final String  aggregateId;
    private final String  name;
    private final String  body;
    private final LocalDateTime occurredOn;


    public AnalyticsDomainEventResponse(String id, String aggregateId, String name, String body, LocalDateTime occurredOn) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.name = name;
        this.body = body;
        this.occurredOn = occurredOn;
    }

    public static AnalyticsDomainEventResponse fromAnalyticsDomainEvent(AnalyticsDomainEvent event){
        return new AnalyticsDomainEventResponse(
                event.id().value(),
                event.aggregateId().value(),
                event.name().value(),
                event.body().value(),
                event.occurredOn().value()
        );
    }

    public String id() {
        return id;
    }

    public String aggregateId() {
        return aggregateId;
    }

    public String name() {
        return name;
    }

    public String body() {
        return body;
    }

    public LocalDateTime occurredOn() {
        return occurredOn;
    }
}


