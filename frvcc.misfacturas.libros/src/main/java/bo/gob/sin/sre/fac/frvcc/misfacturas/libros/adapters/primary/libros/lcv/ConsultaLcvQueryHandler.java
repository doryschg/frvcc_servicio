package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.lcv;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.ListaConsultaLcvResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.lcv.servicioConsultaLcv;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public final class ConsultaLcvQueryHandler implements QueryHandler<ConsultaLcvQuery, ListaConsultaLcvResponse>{
	private final servicioConsultaLcv service;

	public ConsultaLcvQueryHandler(servicioConsultaLcv service) {
		this.service = service;
	}

	@Override
	public ListaConsultaLcvResponse handle(ConsultaLcvQuery query) throws QueryHandlerExecutionError {
		 return new ListaConsultaLcvResponse ( service.buscarPorNItGestion(query.getNit(),query.getGestion()));
	}
		
}
