package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public class ListaConsultaLcvResponse extends ListaMensajesAplicacion implements Serializable, Response{

	private static final long serialVersionUID = 1L;
	private final List<ConsultaLcvResponse> listaConsultaLcvResponse;

	
	public List<ConsultaLcvResponse> getListaConsultaLcvResponse() {
		return listaConsultaLcvResponse;
	}
	
    public ListaConsultaLcvResponse(List<ConsultaLcvResponse> listaConsultaLcvResponse) {
        this.listaConsultaLcvResponse = listaConsultaLcvResponse;
     }

	public ListaConsultaLcvResponse() {
		this.listaConsultaLcvResponse = null;

		// TODO Auto-generated constructor stub
	}
   
}
