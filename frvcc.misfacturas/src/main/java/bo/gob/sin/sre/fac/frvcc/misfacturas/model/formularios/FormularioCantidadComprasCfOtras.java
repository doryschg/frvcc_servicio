package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class FormularioCantidadComprasCfOtras extends IntValueObject {
    public FormularioCantidadComprasCfOtras(Integer value) {
        super(value);
    }
    public FormularioCantidadComprasCfOtras(){
        super(null);
    }
    public FormularioCantidadComprasCfOtras incrementar(){
        return new FormularioCantidadComprasCfOtras(this.value()+1);
    }
    public FormularioCantidadComprasCfOtras decrementar(){
        return new FormularioCantidadComprasCfOtras(this.value()-1);
    }
}
