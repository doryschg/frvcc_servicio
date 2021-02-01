package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateTimeValueObject;

import java.time.LocalDateTime;


public final class AnalyticsDomainEventOccurredOn extends LocalDateTimeValueObject {
    public AnalyticsDomainEventOccurredOn() {
        super(null);
    }

    public AnalyticsDomainEventOccurredOn(LocalDateTime value) {
        super(value);
    }
}
