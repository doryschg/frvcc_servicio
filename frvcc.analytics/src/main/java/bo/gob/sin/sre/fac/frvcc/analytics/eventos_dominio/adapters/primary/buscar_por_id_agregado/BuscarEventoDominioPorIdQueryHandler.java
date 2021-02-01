package bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.buscar_por_id_agregado;

import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.adapters.primary.AnalyticsDomainEventsResponse;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.model.AnalyticsDomainEventAggregateId;
import bo.gob.sin.sre.fac.frvcc.analytics.eventos_dominio.service.buscar_por_id_agregado.BuscadorEventoDominioPorIdAgregado;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public final class BuscarEventoDominioPorIdQueryHandler implements QueryHandler<BuscarEventoDominioPorIdQuery, AnalyticsDomainEventsResponse> {
    private final BuscadorEventoDominioPorIdAgregado service;

    public BuscarEventoDominioPorIdQueryHandler(BuscadorEventoDominioPorIdAgregado service) {
        this.service = service;
    }

    @Override
    public AnalyticsDomainEventsResponse handle(BuscarEventoDominioPorIdQuery query) throws QueryHandlerExecutionError {
        return service.buscar(new AnalyticsDomainEventAggregateId(query.getAggregateId()));
    }
}
