package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public enum EnumOrigenId {
    SERVICIO("SER"),
    MOBIL("MOB"),
    APLICACION("APL");

    private final String value;

    public String value() {
        return value;
    }

    EnumOrigenId(String value) {
        this.value = value;
    }
}
