package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;

public enum EstadoRecepcionId {
    REGISTRADO("REG"),
    RECHAZADO("RECH"),
    VALIDADO("VAL"),
    ANULADO("ANU"),
    OBSERVADO("OBS");

    private final String value;

    public String value() {
        return value;
    }

    EstadoRecepcionId(String value) {
        this.value = value;
    }
}
