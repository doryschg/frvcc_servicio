package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

import java.util.List;

public final class AnalyticsDomainEventsResponse implements Response {
    private final List<AnalyticsDomainEventResponse> response;

    public AnalyticsDomainEventsResponse(List<AnalyticsDomainEventResponse> response) {
        this.response = response;
    }

    public List<AnalyticsDomainEventResponse> response() {
        return response;
    }
}
