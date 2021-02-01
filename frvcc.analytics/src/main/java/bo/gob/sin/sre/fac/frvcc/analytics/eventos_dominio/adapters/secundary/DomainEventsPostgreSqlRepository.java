package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.secundary;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEvent;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEventId;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate.HibernateRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import  bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional("analytics-transaction_manager")
public  class DomainEventsPostgreSqlRepository extends HibernateRepository<AnalyticsDomainEvent> implements DomainEventsRepository {
    public DomainEventsPostgreSqlRepository(@Qualifier("analytics-session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, AnalyticsDomainEvent.class);
    }

    @Override
    public void save(AnalyticsDomainEvent event) {
     super.save(event);
    }

    @Override
    public Optional<AnalyticsDomainEvent> search(AnalyticsDomainEventId id) {

        return byId(id);
    }

    @Override
    public List<AnalyticsDomainEvent> matching(Criteria criteria) {

        return byCriteria(criteria);
    }
}
