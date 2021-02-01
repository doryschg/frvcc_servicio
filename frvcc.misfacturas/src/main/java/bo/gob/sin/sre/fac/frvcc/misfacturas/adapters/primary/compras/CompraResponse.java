package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras;




import java.io.Serializable;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;


public final class CompraResponse extends ListaMensajesAplicacion implements Response,Serializable {
   private final CompraResponseGenerico compraResponse;

    public CompraResponse(CompraResponseGenerico compraResponse) {
        this.compraResponse = compraResponse;
    }

    public CompraResponseGenerico getCompraResponse() {
        return compraResponse;
    }
    public CompraResponse()
    {
		this.compraResponse = null;
    	
    }
}
