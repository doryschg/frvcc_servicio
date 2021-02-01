package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.find.CompraBuscadorService;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;


@Service
public class FindCompraQueryHandler implements QueryHandler<FindCompraQuery, CompraResponse> {
private final CompraBuscadorService finder;

    public FindCompraQueryHandler(CompraBuscadorService finder) {
        this.finder = finder;
    }

    @Override
    public CompraResponse handle(FindCompraQuery query)  {
             return finder.find( new CompraId(query.id()));

    }
}
