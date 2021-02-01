package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.secundary;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEvent;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEventId;
import  bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface DomainEventsRepository {
    void save(AnalyticsDomainEvent event);
    Optional<AnalyticsDomainEvent> search(AnalyticsDomainEventId id);
    List<AnalyticsDomainEvent> matching(Criteria criteria);
}

