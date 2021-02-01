package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

public final class ArchivosResponse implements Response {
    private final List<ArchivoResponse>  archivosResponse;

    public ArchivosResponse(List<ArchivoResponse> archivosResponse) {
        this.archivosResponse = archivosResponse;
    }

    public List<ArchivoResponse> archivosResponse(){
        return archivosResponse;
    }
}
