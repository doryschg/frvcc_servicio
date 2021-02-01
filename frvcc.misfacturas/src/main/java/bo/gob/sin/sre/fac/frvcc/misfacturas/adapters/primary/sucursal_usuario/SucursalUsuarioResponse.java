package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario;




import java.io.Serializable;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;


public final class SucursalUsuarioResponse extends ListaMensajesAplicacion implements Response,Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private final SucursalUsuarioResponseGenerico sucursalUsuarioResponse;

    public SucursalUsuarioResponse(SucursalUsuarioResponseGenerico compraResponse) {
        this.sucursalUsuarioResponse = compraResponse;
    }

    public SucursalUsuarioResponseGenerico getSucursalUsuarioResponse() {
        return sucursalUsuarioResponse;
    }
    public SucursalUsuarioResponse()
    {
		this.sucursalUsuarioResponse = null;
    	
    }
}
