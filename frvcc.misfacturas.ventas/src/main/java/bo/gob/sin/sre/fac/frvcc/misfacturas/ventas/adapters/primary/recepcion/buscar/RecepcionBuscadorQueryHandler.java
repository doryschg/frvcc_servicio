package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.buscar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.RecepcionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.buscar.IRecepcionBuscador;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public final class RecepcionBuscadorQueryHandler implements QueryHandler<RecepcionBuscadorQuery, RecepcionResponse> {
	private final IRecepcionBuscador finder;

	public RecepcionBuscadorQueryHandler(IRecepcionBuscador finder) {
		this.finder = finder;
	}

	@Override
	public RecepcionResponse handle(RecepcionBuscadorQuery query) throws QueryHandlerExecutionError {
		return this.finder.buscar(new RecepcionId(query.id()));
	}
}
