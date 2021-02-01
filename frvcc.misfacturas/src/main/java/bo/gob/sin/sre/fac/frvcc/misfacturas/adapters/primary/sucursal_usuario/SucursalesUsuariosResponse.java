package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class SucursalesUsuariosResponse extends ListaMensajesAplicacion implements Serializable, Response {
    private final List<SucursalUsuarioResponseGenerico> sucursalesUsuariosReponse;

    private final Integer totalPaginas;
    private final Long totalElementos;

    public SucursalesUsuariosResponse(List<SucursalUsuarioResponseGenerico> sucursalesUsuariosReponse) {
        this.sucursalesUsuariosReponse = sucursalesUsuariosReponse;
        this.totalPaginas = null;
        this.totalElementos = null;
    }

    public SucursalesUsuariosResponse(List<SucursalUsuarioResponseGenerico> sucursalesUsuariosReponse, Integer totalPaginas, Long totalElementos) {
        this.sucursalesUsuariosReponse = sucursalesUsuariosReponse;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<SucursalUsuarioResponseGenerico> getSucursalesUsuariosReponse() {
        return sucursalesUsuariosReponse;
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
        SucursalesUsuariosResponse that = (SucursalesUsuariosResponse) o;
        return Objects.equals(sucursalesUsuariosReponse, that.sucursalesUsuariosReponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sucursalesUsuariosReponse);
    }
}
