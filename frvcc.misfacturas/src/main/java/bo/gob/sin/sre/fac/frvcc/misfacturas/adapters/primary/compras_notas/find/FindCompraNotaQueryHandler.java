package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.find.CompraNotaFinderService;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;


@Service
public class FindCompraNotaQueryHandler implements QueryHandler<FindCompraNotaQuery, CompraNotaResponse> {
private final CompraNotaFinderService finder;

    public FindCompraNotaQueryHandler(CompraNotaFinderService finder) {
        this.finder = finder;
    }

    @Override
    public CompraNotaResponse handle(FindCompraNotaQuery query)  {
             return finder.find( new CompraNotaId(query.id()));

    }
}
