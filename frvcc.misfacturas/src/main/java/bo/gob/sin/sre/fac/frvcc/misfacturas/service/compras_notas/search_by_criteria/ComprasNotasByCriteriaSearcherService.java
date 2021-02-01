package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.search_by_criteria;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.ComprasNotasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;

@Service
public class ComprasNotasByCriteriaSearcherService {
	private static final Logger LOG= LoggerFactory.getLogger(ComprasNotasByCriteriaSearcherService.class);

    private final CompraNotaRepository repository;
    public ComprasNotasByCriteriaSearcherService(CompraNotaRepository repository) {
        this.repository = repository;
    }

      public ComprasNotasResponse search(Filters filters, Order order, Optional<Integer> limit, Optional<Integer> offset) {
        Filter filter = Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO);
        filters.filters().add(filter);
        Criteria criteria = new Criteria(filters, order, limit, offset);
        try {
            Pagina<CompraNota> pagina = repository.matching(criteria);
            LOG.info("resultado busqueda {}", pagina);
            return new ComprasNotasResponse(pagina.getContent().stream().map(CompraNotaResponseGenerico::fromAggregate)
                    .collect(Collectors.toList()), pagina.getTotalPaginas(), pagina.getTotalElementos());

		} catch (Exception e) {
			e.printStackTrace();
			return new ComprasNotasResponse(null, null, null);
		}   

    }

    public TotalRegistrosResponse countResultSearch(Filters filters) {
        Criteria criteria = new Criteria(filters, null);
        return new TotalRegistrosResponse(repository.countByCriteria(criteria));

    }
}
