package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;

public final class RecepcionesResponse implements Response {
    private final List<RecepcionesResponse> recepciones;

    public RecepcionesResponse(List<RecepcionesResponse> recepciones) {
        this.recepciones = recepciones;
    }

    public List<RecepcionesResponse> recepciones() {
        return recepciones;
    }
}
