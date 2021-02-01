package bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.Contribuyente;

public final class ContribuyenteResponse implements Response {
    private final Long nit;
    private final Long ifc;
    private final String razonSocial;

    public ContribuyenteResponse(Long nit, Long ifc, String razonSocial) {
        this.nit = nit;
        this.ifc = ifc;
        this.razonSocial = razonSocial;
    }

    public Long nit() {
        return nit;
    }

    public Long ifc() {
        return ifc;
    }

    public String razonSocial() {
        return razonSocial;
    }
    public static ContribuyenteResponse fromContribuyente(Contribuyente contribuyente){

        return new ContribuyenteResponse(

                contribuyente.nit() == null? null:contribuyente.nit().value(),
                contribuyente.ifc() == null ? null:contribuyente.ifc().value(),
                contribuyente.razonSocial()== null? null: contribuyente.razonSocial().value()
        );

    }
}
