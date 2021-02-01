package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class ConsolidacionGestion extends IntValueObject {
    public ConsolidacionGestion(Integer value) {
        super(value);
    }

    public ConsolidacionGestion() {
        super(null);
    }
    public ConsolidacionGestion incrementar(){
        return new ConsolidacionGestion(value()+1);
    }
}
