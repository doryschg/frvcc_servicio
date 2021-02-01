package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class FormularioCantidadComprasSdCf extends IntValueObject {
    public FormularioCantidadComprasSdCf(Integer value) {
        super(value);
    }
    public FormularioCantidadComprasSdCf(){
        super(null);
    }
    public FormularioCantidadComprasSdCf incrementar(){
        return new FormularioCantidadComprasSdCf(this.value()+1);
    }
    public FormularioCantidadComprasSdCf decrementar(){
        return new FormularioCantidadComprasSdCf(this.value()-1);
    }
}
