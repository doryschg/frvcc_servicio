package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class FormularioCantidadComprasCfIpn extends IntValueObject {
    public FormularioCantidadComprasCfIpn(Integer value) {
        super(value);
    }
    public FormularioCantidadComprasCfIpn(){
        super(null);
    }
    public FormularioCantidadComprasCfIpn incrementar(){
        return new FormularioCantidadComprasCfIpn(this.value()+1);
    }
    public FormularioCantidadComprasCfIpn decrementar(){
        return new FormularioCantidadComprasCfIpn(this.value()-1);
    }
}
