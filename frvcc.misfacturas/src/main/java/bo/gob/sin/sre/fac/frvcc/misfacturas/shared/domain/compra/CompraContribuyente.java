package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

public final class CompraContribuyente {
    private final Long nit;
    private final Long ifc;
    private final String razonSocial;

    public CompraContribuyente(Long nit, Long ifc, String razonSocial) {
        this.nit = nit;
        this.ifc = ifc;
        this.razonSocial = razonSocial;
    }

    public Long getNit() {
        return nit;
    }

    public Long getIfc() {
        return ifc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
}
