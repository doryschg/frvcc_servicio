package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

public enum AccionRecepcionId {
    NORMAL("NOR"),
    RECTIFICADO("REC");

    private final String value;

    public String value() {
        return value;
    }

    AccionRecepcionId(String value) {
        this.value = value;
    }
}
