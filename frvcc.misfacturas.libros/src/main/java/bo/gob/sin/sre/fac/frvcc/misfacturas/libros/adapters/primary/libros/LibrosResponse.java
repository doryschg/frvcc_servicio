package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public class LibrosResponse extends ListaMensajesAplicacion implements Serializable, Response {
    private final List<LibroRespuesta> librosReponse;

    private final Integer totalPaginas;
    private final Long totalElementos;

    public LibrosResponse(List<LibroRespuesta> librosReponse) {
        this.librosReponse = librosReponse;
        this.totalPaginas = null;
        this.totalElementos = null;
    }

    public LibrosResponse(List<LibroRespuesta> librosReponse, Integer totalPaginas, Long totalElementos) {
        this.librosReponse = librosReponse;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<LibroRespuesta> getLibrosReponse() {
        return librosReponse;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public Long getTotalElementos() {
        return totalElementos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibrosResponse that = (LibrosResponse) o;
        return Objects.equals(librosReponse, that.librosReponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(librosReponse);
    }
}

