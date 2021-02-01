package bo.gob.sin.sre.fac.frvcc.shared.adpters.primary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public class ResultadoGenericoListaDto<T> extends ListaMensajesAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<T> resultadoLista = new ArrayList<>();

	public List<T> getResultadoLista() {
		return this.resultadoLista;
	}

	public void setResultadoLista(List<T> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}
}
