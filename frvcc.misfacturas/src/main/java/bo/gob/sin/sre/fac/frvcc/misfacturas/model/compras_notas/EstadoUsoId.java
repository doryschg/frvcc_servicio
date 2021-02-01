package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

public enum EstadoUsoId {
	REGISTRADO("REG"), 
	APROPIADO("APR"), 
	ASIGNADO("ASC"), 
	DECLARADO("DEC"), 
	CONSOLIDADO("CON"), 
	ENVIADO("ENV");

	private final String value;

	private EstadoUsoId(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
