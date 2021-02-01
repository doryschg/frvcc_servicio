package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event;



import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId     = UUID.randomUUID().toString();
        this.occurredOn  = Utils.localDateTimeToString(LocalDateTime.now());

    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId     = eventId;
        this.occurredOn  = occurredOn;
    }

    protected DomainEvent() {
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) throws IOException;

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }
    public LocalDateTime occurredOnLocalDateTime() {
        return LocalDateTime.parse(occurredOn);
    }
}
