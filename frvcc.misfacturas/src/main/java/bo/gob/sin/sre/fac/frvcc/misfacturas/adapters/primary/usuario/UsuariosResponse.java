package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalUsuarioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class UsuariosResponse extends ListaMensajesAplicacion implements Serializable, Response {
    private final List<UsuarioResponseGenerico> usuariosReponse;

    private final Integer totalPaginas;
    private final Long totalElementos;

    public UsuariosResponse(List<UsuarioResponseGenerico> usuariosReponse) {
        this.usuariosReponse = usuariosReponse;
        this.totalPaginas = null;
        this.totalElementos = null;
    }

    public UsuariosResponse(List<UsuarioResponseGenerico> usuariosReponse, Integer totalPaginas, Long totalElementos) {
        this.usuariosReponse = usuariosReponse;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<UsuarioResponseGenerico> getUsuariosReponse() {
        return usuariosReponse;
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
        UsuariosResponse that = (UsuariosResponse) o;
        return Objects.equals(usuariosReponse, that.usuariosReponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuariosReponse);
    }
}
