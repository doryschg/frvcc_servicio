package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.shared;

import java.util.List;

public final class Pagina<T> {
    private final Integer TotalPaginas;
    private final Long TotalElementos;
    private final List<T> content ;
    public Pagina(Integer totalPaginas, Long totalElementos, List<T> content) {
        TotalPaginas = totalPaginas;
        TotalElementos = totalElementos;
        this.content = content;
    }

    public Integer getTotalPaginas() {
        return TotalPaginas;
    }

    public Long getTotalElementos() {
        return TotalElementos;
    }

    public List<T> getContent() {
        return content;
    }
}
