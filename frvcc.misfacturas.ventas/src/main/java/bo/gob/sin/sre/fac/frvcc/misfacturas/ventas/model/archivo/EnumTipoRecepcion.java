package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo;

public enum EnumTipoRecepcion {
	RECEPCION_VENTA("V"), RECEPCION_COMPRA("C");

	private final String value;

	private EnumTipoRecepcion(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
