package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioCantidadComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public class LibroCantidadComprasCf extends IntValueObject {
    public LibroCantidadComprasCf(Integer value) {
        super(value);

    }

    public LibroCantidadComprasCf() {
        super(null);
    }
    public LibroCantidadComprasCf incrementar(){
        return new LibroCantidadComprasCf(this.value()+1);
    }
    public LibroCantidadComprasCf decrementar(){
        return new LibroCantidadComprasCf(this.value()-1);
    }
}