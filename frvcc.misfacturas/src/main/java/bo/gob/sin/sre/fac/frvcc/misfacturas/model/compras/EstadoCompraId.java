package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public enum EstadoCompraId {
	VIGENTE("VIG"),
    ANULADO("AN"),
    OBSERVADO("OBS"),
    NOTA_CREDITO_DEBITO("NCD");
 private final String value;
    EstadoCompraId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
