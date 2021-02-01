package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

public enum TipoFormlarioId {
    F110("F110"),
    AF610("AF610"),
	AF702("AF702"),
    AF510("AF510"),
    F111("F111");

    private final String value;

    TipoFormlarioId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
