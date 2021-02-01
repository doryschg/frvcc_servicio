package bo.gob.sin.sre.fac.frvcc.shared.model;

public final class DatosBasicos {
    private final LongValueObject nit;
    private final LongValueObject ifc;
    private final StringValueObject razonSocial;

    public DatosBasicos(LongValueObject nit, LongValueObject ifc, StringValueObject razonSocial) {
        this.nit = nit;
        this.ifc = ifc;
        this.razonSocial = razonSocial;
    }

    public LongValueObject nit() {
        return nit;
    }

    public LongValueObject ifc() {
        return ifc;
    }

    public StringValueObject razonSocial() {
        return razonSocial;
    }
}
