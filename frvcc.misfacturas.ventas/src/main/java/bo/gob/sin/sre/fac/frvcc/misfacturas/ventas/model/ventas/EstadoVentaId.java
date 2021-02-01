package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

public enum EstadoVentaId {
	VIGENTE("VIG"), ANULADO("ANL");

	private final String value;

	EstadoVentaId(String value) {
        this.value = value;
    }

	public String value() {
		return value;
	}

}
