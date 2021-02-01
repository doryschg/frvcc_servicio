package bo.gob.sin.sre.fac.frvcc.misfacturas.service.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones.PostgreSqlConsolidacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.Consolidacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones.IBuscarConsolidacionPorCriteriaService;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class BuscarConsolidacionPorCriteriaServiceImpl implements IBuscarConsolidacionPorCriteriaService {

    private final PostgreSqlConsolidacionRepository repository;

    public BuscarConsolidacionPorCriteriaServiceImpl(PostgreSqlConsolidacionRepository repository) {
        this.repository = repository;
    }


    public ConsolidacionResponse search(
            Filters filters,
            Order order,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);
        Pagina<Consolidacion> formularios = repository.BuscarPorCriteria(criteria);

        return new ConsolidacionResponse(
                formularios.getContent()
                        .stream()
                        .map(ConsolidacionResponseGenerico::fromAggregate)
                        .collect(Collectors.toList()),
                formularios.getTotalPaginas(),
                formularios.getTotalElementos()
        );
    }

}
