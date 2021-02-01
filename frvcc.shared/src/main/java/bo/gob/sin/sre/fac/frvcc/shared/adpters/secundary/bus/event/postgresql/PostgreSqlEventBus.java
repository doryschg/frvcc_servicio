package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.event.postgresql;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import org.hibernate.SessionFactory;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;




@Service
@Transactional("misfacturas-transaction_manager")
public  class PostgreSqlEventBus implements EventBus {
    private final SessionFactory sessionFactory;

    public PostgreSqlEventBus(@Qualifier("misfacturas-session-factory")SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }


    public void publish(DomainEvent domainEvent) {
        String                        id          = domainEvent.eventId();
        String                        aggregateId = domainEvent.aggregateId();
        String                        name        = domainEvent.eventName();
        HashMap<String, Serializable> body        = domainEvent.toPrimitives();
        String                        occurredOn  = domainEvent.occurredOn();

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
            "INSERT INTO dsin.sfe_facturacion.domain_events (id,  aggregate_id, name,  body,  occurred_on) " +
            "VALUES (:id, :aggregateId, :name, cast(:body as json), cast(:occurredOn as TIMESTAMP));"
        );

        query.setParameter("id", UUID.fromString(id))
             .setParameter("aggregateId", aggregateId)
             .setParameter("name", name)
             .setParameter("body", Utils.jsonEncode(body))
             .setParameter("occurredOn", occurredOn);

        query.executeUpdate();
    }
}
