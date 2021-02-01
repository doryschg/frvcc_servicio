package bo.gob.sin.sre.fac.frvcc.shared.adpters.primary;

import java.io.Serializable;


import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public class ResultadoGenericoDto<T> extends ListaMensajesAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private T resultadoObjeto;

	public ResultadoGenericoDto(){

	}
	public ResultadoGenericoDto(T resultadoObjeto) {
		this.resultadoObjeto = resultadoObjeto;
	}

	public T getResultadoObjeto() {
		return this.resultadoObjeto;
	}

	public void setResultadoObjeto(T resultadoObjeto) {
		this.resultadoObjeto = resultadoObjeto;
	}
}
