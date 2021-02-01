package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.search_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibroRespuesta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibrosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibrosByCriteriaSearcher {
    private final LibroRepository repository;

    public LibrosByCriteriaSearcher(LibroRepository repository) {
        this.repository = repository;
    }


    public LibrosResponse search(
            Filters filters,
            Order order,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);
        Pagina<Libro> libros = repository.BuscarPorCriteria(criteria);

        return new LibrosResponse(
                        libros.getContent()
                        .stream()
                        .map(LibroRespuesta::fromAggregate)
                        .collect(Collectors.toList()),
                libros.getTotalPaginas(),
                libros.getTotalElementos()
        );
    }
    public TotalRegistrosResponse countResultSearch(Filters filters) {
		Criteria criteria = new Criteria(filters, null);
		return new TotalRegistrosResponse(repository.countByCriteria(criteria));
	}

}
