package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public enum TipoObservacionId {
	ANULADA("AN"),
    DUPLICADA_SERVICIOS("DSER"),
    REGISTRADA_NCD("NCD");
 private final String value;
    TipoObservacionId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
