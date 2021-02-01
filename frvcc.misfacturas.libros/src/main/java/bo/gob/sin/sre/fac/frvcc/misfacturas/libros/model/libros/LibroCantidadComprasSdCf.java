package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public final class LibroCantidadComprasSdCf extends IntValueObject {
    public LibroCantidadComprasSdCf(Integer value) {
        super(value);
    }
    public LibroCantidadComprasSdCf(){
        super(null);
    }
    public LibroCantidadComprasSdCf incrementar(){
        return new LibroCantidadComprasSdCf(this.value()+1);
    }
    public LibroCantidadComprasSdCf decrementar(){
        return new LibroCantidadComprasSdCf(this.value()-1);
    }
}
