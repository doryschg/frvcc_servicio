package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.find;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find.FindCompraQuery;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.UuidMother;

public class FindBeneficiarioFacturaQueryMother {
    public static FindCompraQuery create(String id) { return new FindCompraQuery(id);}
    public static FindCompraQuery random(){
        return create(UuidMother.random());
    }
}
