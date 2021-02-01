package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.search_by_criteria;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraContribuyente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;

@Service
public class ComprasByCriteriaSearcherImpl {
    private final CompraRepository repository;
    private final CompraValidador validador;


    public ComprasByCriteriaSearcherImpl(CompraRepository repository, CompraValidador validador) {
        this.repository = repository;
        this.validador=validador;
    }
    


      public ComprasResponse search(Filters filters, Order order, Optional<Integer> limit, Optional<Integer> offset) {


        Filter filter = Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO);
        filters.filters().add(filter);
        Criteria criteria = new Criteria(filters, order, limit, offset);
        

          Pagina<Compra> pagina = repository.matching(criteria);

        return new ComprasResponse(pagina.getContent().stream().map(CompraResponseGenerico::fromAggregate)
                .collect(Collectors.toList()), pagina.getTotalPaginas(), pagina.getTotalElementos());


    }

    public TotalRegistrosResponse countResultSearch(Filters filters) {
        Criteria criteria = new Criteria(filters, null);
        return new TotalRegistrosResponse(repository.countByCriteria(criteria));

    }

    public ComprasResponse buscarPorListaIds(List<String> pListaIds){
        List<Compra> vCompras = repository.ListaDeComprasPorIds(pListaIds);
        return new ComprasResponse(vCompras.stream().map(CompraResponseGenerico::fromAggregate).collect(Collectors.toList()));
    }
}
