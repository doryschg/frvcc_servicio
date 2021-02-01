package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalUsuarioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.find.CompraBuscadorService;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.find.SucursalUsuarioBuscadorService;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;


@Service
public class FindSucursalUsuarioQueryHandler implements QueryHandler<FindSucursalUsuarioQuery, SucursalUsuarioResponse> {
private final SucursalUsuarioBuscadorService finder;

    public FindSucursalUsuarioQueryHandler(SucursalUsuarioBuscadorService finder) {
        this.finder = finder;
    }

    @Override
    public SucursalUsuarioResponse handle(FindSucursalUsuarioQuery query)  {
             return finder.find( new SucursalUsuarioId(query.id()));

    }
}
