package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibroResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.find.LibroFinder;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.find.FormularioFinder;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class FindLibroQueryHandler implements QueryHandler<FindLibroQuery, LibroResponse> {
    private final LibroFinder finder;

    public FindLibroQueryHandler(LibroFinder finder) {
        this.finder = finder;
    }

    @Override
    public LibroResponse handle(FindLibroQuery query) throws QueryHandlerExecutionError {
      return finder.find(new LibroId(query.id()));
    }
}
