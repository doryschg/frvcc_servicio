package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

public enum EstadoUsoId {
	REGISTRADO("REG"), CONSOLIDADO("CON"), ENVIADO("ENV");

	private final String value;

	private EstadoUsoId(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
