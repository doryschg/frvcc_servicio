package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class LibroCantidadComprasCfElec extends IntValueObject {
    public LibroCantidadComprasCfElec(Integer value) {
        super(value);
    }
    public LibroCantidadComprasCfElec(){
        super(null);
    }
    public LibroCantidadComprasCfElec incrementar(){
        return new LibroCantidadComprasCfElec(this.value()+1);
    }
    public LibroCantidadComprasCfElec decrementar(){
        return new LibroCantidadComprasCfElec(this.value()-1);
    }
}
