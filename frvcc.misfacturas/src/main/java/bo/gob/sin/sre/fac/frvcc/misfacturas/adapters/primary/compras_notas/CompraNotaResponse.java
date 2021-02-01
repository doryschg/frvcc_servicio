package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas;

import java.io.Serializable;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;


public final class CompraNotaResponse extends ListaMensajesAplicacion implements Response,Serializable {

	private static final long serialVersionUID = -5668306939187770781L;
private final CompraNotaResponseGenerico compraNotaResponse;

    public CompraNotaResponse(CompraNotaResponseGenerico compraNotaResponse) {
        this.compraNotaResponse = compraNotaResponse;
    }

    public CompraNotaResponseGenerico getCompraNotaResponse() {
        return compraNotaResponse;
    }
}
