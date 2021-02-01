package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public class ContribuyenteNewtonResponse extends ListaMensajesAplicacion implements Response {
	private final String esNewton;
	public ContribuyenteNewtonResponse(String esNewton)
	{
		this.esNewton=esNewton;
	}
	public String getEsNewton() {
		return esNewton;
	}
	
}
