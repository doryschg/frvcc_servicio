package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

public enum EstadoCompraNotaId {
	VIGENTE("VIG"), ANULADO("ANL");

	private final String value;

	EstadoCompraNotaId(String value) {
        this.value = value;
    }

	public String value() {
		return value;
	}

}
