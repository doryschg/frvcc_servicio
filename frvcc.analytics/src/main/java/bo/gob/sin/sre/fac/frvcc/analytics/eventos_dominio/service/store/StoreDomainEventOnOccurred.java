package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.service.store;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.*;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

import java.util.Arrays;
import java.util.List;


@Service
@DomainEventSubscriber({DomainEvent.class})
public final class StoreDomainEventOnOccurred {
    private final DomainEventStorer storer;
    private final List<String> domainEventIgnore = Arrays.asList("hformulario.registrado");

    private static final Logger LOG = LoggerFactory.getLogger(StoreDomainEventOnOccurred.class);


    public StoreDomainEventOnOccurred(DomainEventStorer storer) {
        this.storer = storer;
    }

    @EventListener
    public void on(DomainEvent event)  {
        try {
            AnalyticsDomainEventId id          = new AnalyticsDomainEventId(event.eventId());
            AnalyticsDomainEventAggregateId aggregateId = new AnalyticsDomainEventAggregateId(event.aggregateId());
            AnalyticsDomainEventName name        = new AnalyticsDomainEventName(event.eventName());
            AnalyticsDomainEventBody body        = new AnalyticsDomainEventBody(Utils.jsonEncode(event.toPrimitives()));
            AnalyticsDomainEventOccurredOn occurredOn = new AnalyticsDomainEventOccurredOn(Utils.stringToLocalDateTime(event.occurredOn()));

            if(!domainEventIgnore.stream().filter(nameDomain -> nameDomain.equals(name.value().strip())).findAny().isPresent()){
                storer.store(id,aggregateId,name,body,occurredOn);
            }
        }catch (Exception excepcion){
            LOG.error(excepcion.getCause().toString(), excepcion);
        }
    }
}


