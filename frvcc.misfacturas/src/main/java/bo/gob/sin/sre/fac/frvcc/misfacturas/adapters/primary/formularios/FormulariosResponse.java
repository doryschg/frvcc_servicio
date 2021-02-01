package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios;



import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public final class FormulariosResponse  extends ListaMensajesAplicacion implements Serializable, Response {
    private final List<FormularioResponseGenerico> formulariosReponse;

    private final Integer totalPaginas;
    private final Long totalElementos;

    public FormulariosResponse(List<FormularioResponseGenerico> formulariosReponse) {
        this.formulariosReponse = formulariosReponse;
        this.totalPaginas = null;
        this.totalElementos = null;
    }

    public FormulariosResponse(List<FormularioResponseGenerico> formulariosReponse, Integer totalPaginas, Long totalElementos) {
        this.formulariosReponse = formulariosReponse;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<FormularioResponseGenerico> getFormulariosReponse() {
        return formulariosReponse;
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
        FormulariosResponse that = (FormulariosResponse) o;
        return Objects.equals(formulariosReponse, that.formulariosReponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formulariosReponse);
    }
}
