package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.contribuyente_newton;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.ContribuyenteNewtonResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibroResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.contribuyente_newton.contribuyente_newton;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.find.LibroFinder;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.find.FormularioFinder;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class ContribuyenteNewtonQueryHandler implements QueryHandler<ContribuyenteNewtonQuery, ContribuyenteNewtonResponse> {
    private final contribuyente_newton service;

    public ContribuyenteNewtonQueryHandler(contribuyente_newton service) {
        this.service = service;
    }

    @Override
    public ContribuyenteNewtonResponse handle(ContribuyenteNewtonQuery query) throws QueryHandlerExecutionError {
      return new ContribuyenteNewtonResponse(service.esContribuyenteNewton(query.nit()));
    }
}
