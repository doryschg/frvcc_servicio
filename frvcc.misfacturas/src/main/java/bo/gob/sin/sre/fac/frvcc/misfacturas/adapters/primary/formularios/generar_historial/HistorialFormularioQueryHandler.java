package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.generar_historial;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.generar_historial.IGeneradorHistorialFormulario;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public final class HistorialFormularioQueryHandler implements QueryHandler<HistorialFormularioQuery, FormulariosResponse> {
    private final IGeneradorHistorialFormulario service;

    public HistorialFormularioQueryHandler(IGeneradorHistorialFormulario service) {
        this.service = service;

    }

    @Override
    public FormulariosResponse handle(HistorialFormularioQuery query) throws QueryHandlerExecutionError {
        return service.generadorHistorial(new FormularioId(query.id()));
    }
}
