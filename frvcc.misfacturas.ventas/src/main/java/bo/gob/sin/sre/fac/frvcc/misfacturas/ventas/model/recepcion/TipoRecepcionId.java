package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

public enum TipoRecepcionId {
    VENTA("V"),
    COMPRA("C"),
    VENTA_NOTA_FISCAL("VN"),
    COMPRA_NOTA_FISCAL("CN");

    private final String value;

    public String value() {
        return value;
    }

    TipoRecepcionId(String value) {
        this.value = value;
    }
}
