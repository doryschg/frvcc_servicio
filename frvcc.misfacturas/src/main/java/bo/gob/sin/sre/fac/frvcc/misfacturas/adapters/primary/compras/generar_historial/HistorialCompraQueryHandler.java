package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.generar_historial;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.generar_historial.IGeneradorHistorialCompras;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public final class HistorialCompraQueryHandler implements QueryHandler<HistorialCompraQuery,ComprasResponse> {
    private final IGeneradorHistorialCompras service;

    public HistorialCompraQueryHandler(IGeneradorHistorialCompras service) {
        this.service = service;

    }

    @Override
    public ComprasResponse handle(HistorialCompraQuery query) throws QueryHandlerExecutionError {
        return service.generadorHistorial(new CompraId(query.id()));
    }
}
