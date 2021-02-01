package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class ConsolidacionResponse extends ListaMensajesAplicacion implements Serializable, Response {
    private final List<ConsolidacionResponseGenerico> consolidacionesResponse;

    private final Integer totalPaginas;
    private final Long totalElementos;

    public ConsolidacionResponse(List<ConsolidacionResponseGenerico> formulariosReponse) {
        this.consolidacionesResponse = formulariosReponse;
        this.totalPaginas = null;
        this.totalElementos = null;
    }

    public ConsolidacionResponse(List<ConsolidacionResponseGenerico> formulariosReponse, Integer totalPaginas, Long totalElementos) {
        this.consolidacionesResponse = formulariosReponse;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<ConsolidacionResponseGenerico> getConsolidacionesResponse() {
        return consolidacionesResponse;
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
        ConsolidacionResponse that = (ConsolidacionResponse) o;
        return Objects.equals(consolidacionesResponse, that.consolidacionesResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consolidacionesResponse);
    }
}
