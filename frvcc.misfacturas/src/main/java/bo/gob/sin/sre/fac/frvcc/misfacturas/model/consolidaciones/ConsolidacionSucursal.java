package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class ConsolidacionSucursal extends IntValueObject {
    public ConsolidacionSucursal(Integer value) {
        super(value);
    }

    public ConsolidacionSucursal() {
        super(null);
    }
    public ConsolidacionSucursal incrementar(){
        return new ConsolidacionSucursal(value()+1);
    }
}
