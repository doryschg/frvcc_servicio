package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public enum TipoDocumentoId {
    FACTURA("FAC"),
    NOTA_FISCAL("NFIS");

    private final String value;

    TipoDocumentoId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
