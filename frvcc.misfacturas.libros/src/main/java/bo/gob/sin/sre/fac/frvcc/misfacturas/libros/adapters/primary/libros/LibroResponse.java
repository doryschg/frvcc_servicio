package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros;




import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public final class LibroResponse extends ListaMensajesAplicacion implements Response {
   private final  LibroRespuesta libroResponse;

    public LibroResponse(LibroRespuesta libroResponse) {
        this.libroResponse = libroResponse;
    }

    public LibroRespuesta getLibroResponse() {
        return libroResponse;
    }
}
