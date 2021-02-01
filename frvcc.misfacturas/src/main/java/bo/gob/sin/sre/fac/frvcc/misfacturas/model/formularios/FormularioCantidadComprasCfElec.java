package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class FormularioCantidadComprasCfElec extends IntValueObject {
    public FormularioCantidadComprasCfElec(Integer value) {
        super(value);
    }
    public FormularioCantidadComprasCfElec(){
        super(null);
    }
    public FormularioCantidadComprasCfElec incrementar(){
        return new FormularioCantidadComprasCfElec(this.value()+1);
    }
    public FormularioCantidadComprasCfElec decrementar(){
        return new FormularioCantidadComprasCfElec(this.value()-1);
    }
}
