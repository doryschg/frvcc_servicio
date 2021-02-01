package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.find.FormularioFinder;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class FindFormularioQueryHandler implements QueryHandler<FindFormularioQuery, FormularioResponse> {
    private final FormularioFinder finder;

    public FindFormularioQueryHandler(FormularioFinder finder) {
        this.finder = finder;
    }

    @Override
    public FormularioResponse handle(FindFormularioQuery query) throws QueryHandlerExecutionError {
      return finder.find(new FormularioId(query.id()));
    }
}
