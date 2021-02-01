package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario;



import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

import java.io.Serializable;


public final class UsuarioResponse extends ListaMensajesAplicacion implements Response,Serializable {

	private static final long serialVersionUID = 1L;
private final UsuarioResponseGenerico usuarioResponse;

    public UsuarioResponse(UsuarioResponseGenerico usuarioResponse) {
        this.usuarioResponse = usuarioResponse;
    }

    public UsuarioResponseGenerico getUsuarioResponse() {
        return usuarioResponse;
    }
    public UsuarioResponse()
    {
		this.usuarioResponse = null;
    	
    }
}
