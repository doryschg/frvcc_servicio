package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class FormularioCantidadComprasCf extends IntValueObject {
    public FormularioCantidadComprasCf(Integer value) {
        super(value);
    }
    public FormularioCantidadComprasCf(){
        super(null);
    }
    public FormularioCantidadComprasCf incrementar(){
        return new FormularioCantidadComprasCf(this.value() + 1);
    }
    public FormularioCantidadComprasCf decrementar(){
        return new FormularioCantidadComprasCf(this.value()-1);
    }
    public  FormularioCantidadComprasCf incrementar(Integer compras){ return new FormularioCantidadComprasCf(this.value() + compras);}
}
