package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.reporte;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioReporteResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.reporte.FormularioReporteFinder;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public class ReporteFormularioQueryHandler implements QueryHandler<ReporteFormularioQuery, FormularioReporteResponse> {
	 private final FormularioReporteFinder finder;

	    public ReporteFormularioQueryHandler(FormularioReporteFinder finder) {
	        this.finder = finder;
	    }

	    @Override
	    public FormularioReporteResponse handle(ReporteFormularioQuery query) throws QueryHandlerExecutionError {
	      return finder.reporteFormulario(new FormularioId(query.id()));
	    }
}
