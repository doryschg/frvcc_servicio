package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public enum NumeroDui {
	ZERO("0");
 private final String value;
    NumeroDui(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
