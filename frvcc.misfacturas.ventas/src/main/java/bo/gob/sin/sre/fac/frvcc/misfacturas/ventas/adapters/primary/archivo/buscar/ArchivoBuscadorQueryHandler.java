package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.buscar;



import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.ArchivoResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.buscar.IArchivoBuscador;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;

@Service
public class ArchivoBuscadorQueryHandler implements QueryHandler<ArchivoBuscadorQuery, ArchivoResponse> {

    private final IArchivoBuscador finder;

    public ArchivoBuscadorQueryHandler(IArchivoBuscador finder) {
        this.finder = finder;
    }

    @Override
    public ArchivoResponse handle(ArchivoBuscadorQuery query) throws ArchivoNotExist {
        return finder.buscar(new ArchivoId(query.id()));

    }
}
