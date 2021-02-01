package bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.search_by_criteria;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalUsuarioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalesUsuariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.sucursal_usuario.ISucursalUsuarioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.bus.query.TotalRegistrosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalUsuarioByCriteriaSearcher {
    private final ISucursalUsuarioRepository repository;

    public SucursalUsuarioByCriteriaSearcher(ISucursalUsuarioRepository repository) {
        this.repository = repository;
    }


    public SucursalesUsuariosResponse search(
            Filters filters,
            Order order,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);
        Pagina<SucursalUsuario> sucursalesUsuarios = repository.BuscarPorCriteria(criteria);

        return new SucursalesUsuariosResponse(
                        sucursalesUsuarios.getContent()
                        .stream()
                        .map(SucursalUsuarioResponseGenerico::fromAggregate)
                        .collect(Collectors.toList()),
                sucursalesUsuarios.getTotalPaginas(),
                sucursalesUsuarios.getTotalElementos()
        );
    }
    public TotalRegistrosResponse countResultSearch(Filters filters) {
		Criteria criteria = new Criteria(filters, null);
		return new TotalRegistrosResponse(repository.countByCriteria(criteria));
	}

}
