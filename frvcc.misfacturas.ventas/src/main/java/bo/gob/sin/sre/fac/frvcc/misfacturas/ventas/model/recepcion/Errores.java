package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

import java.io.Serializable;

public class Errores implements Serializable {

	/**
	 * 
	 */
	private String fila;
	private String codigoError;

	public Errores() {
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

}
