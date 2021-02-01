package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.search_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormulariosByCriteriaSearcher {
    private final FormularioRepository repository;

    public FormulariosByCriteriaSearcher(FormularioRepository repository) {
        this.repository = repository;
    }


    public FormulariosResponse search(
            Filters filters,
            Order order,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);
        Pagina<Formulario> formularios = repository.BuscarPorCriteria(criteria);

        return new FormulariosResponse(
                        formularios.getContent()
                        .stream()
                        .map(FormularioResponseGenerico::fromAggregate)
                        .collect(Collectors.toList()),
                formularios.getTotalPaginas(),
                formularios.getTotalElementos()
        );
    }
    public TotalRegistrosResponse countResultSearch(Filters filters) {
		Criteria criteria = new Criteria(filters, null);
		return new TotalRegistrosResponse(repository.countByCriteria(criteria));
	}

}
