package bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes;


public final class Contribuyente {
    private final ContribuyenteNit nit;
    private final ContribuyenteIfc ifc;
    private final ContribuyenteRezonSocial razonSocial;

    public Contribuyente(ContribuyenteNit nit, ContribuyenteIfc ifc, ContribuyenteRezonSocial razonSocial) {
        this.nit = nit;
        this.ifc = ifc;
        this.razonSocial = razonSocial;
    }

    public Contribuyente(){
        this.nit = new ContribuyenteNit(null);
        this.ifc = new ContribuyenteIfc(null);
        this.razonSocial = new ContribuyenteRezonSocial(null);
    }

    public ContribuyenteNit nit() {
        return nit;
    }

    public ContribuyenteIfc ifc() {
        return ifc;
    }

    public ContribuyenteRezonSocial razonSocial() {
        return razonSocial;
    }
}
