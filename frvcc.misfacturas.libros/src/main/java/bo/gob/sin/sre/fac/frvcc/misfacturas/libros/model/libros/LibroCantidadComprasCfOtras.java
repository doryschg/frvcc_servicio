package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class LibroCantidadComprasCfOtras extends IntValueObject {
    public LibroCantidadComprasCfOtras(Integer value) {
        super(value);
    }
    public LibroCantidadComprasCfOtras(){
        super(null);
    }
    public LibroCantidadComprasCfOtras incrementar(){
        return new LibroCantidadComprasCfOtras(this.value()+1);
    }
    public LibroCantidadComprasCfOtras decrementar(){
        return new LibroCantidadComprasCfOtras(this.value()-1);
    }
}
