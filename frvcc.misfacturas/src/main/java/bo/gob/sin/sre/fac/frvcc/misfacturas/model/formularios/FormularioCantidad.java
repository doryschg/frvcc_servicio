package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public class FormularioCantidad  extends IntValueObject {
    public FormularioCantidad(Integer value) {
        super(value);
    }

    public FormularioCantidad() {
        super(null);
    }
    public FormularioCantidad incrementar(){
        return new FormularioCantidad(value()+1);
    }
}
