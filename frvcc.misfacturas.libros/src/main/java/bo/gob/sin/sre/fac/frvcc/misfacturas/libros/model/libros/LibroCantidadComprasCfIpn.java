package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class LibroCantidadComprasCfIpn extends IntValueObject {
    public LibroCantidadComprasCfIpn(Integer value) {
        super(value);
    }
    public LibroCantidadComprasCfIpn(){
        super(null);
    }
    public LibroCantidadComprasCfIpn incrementar(){
        return new LibroCantidadComprasCfIpn(this.value()+1);
    }
    public LibroCantidadComprasCfIpn decrementar(){
        return new LibroCantidadComprasCfIpn(this.value()-1);
    }
}
