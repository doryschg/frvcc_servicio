package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

public enum TipoDocumentoId {
    FACTURA("FAC"),
    NOTA_FISCAL("NFIS");

    private final String value;

    public String value() {
        return value;
    }

    TipoDocumentoId(String value) {
        this.value = value;
    }

}
