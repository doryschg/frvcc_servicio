package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class ConsolidacionPeriodo extends IntValueObject {
    public ConsolidacionPeriodo(Integer value) {
        super(value);
    }

    public ConsolidacionPeriodo() {
        super(null);
    }
    public ConsolidacionPeriodo incrementar(){
        return new ConsolidacionPeriodo(value()+1);
    }
}
