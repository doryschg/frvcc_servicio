package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioCantidadComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public class LibroCantidadComprasNotas extends IntValueObject {
    public LibroCantidadComprasNotas(Integer value) {
        super(value);

    }

    public LibroCantidadComprasNotas() {
        super(null);
    }
    public LibroCantidadComprasNotas incrementar(){
        return new LibroCantidadComprasNotas(this.value()+1);
    }
    public LibroCantidadComprasNotas decrementar(){
        return new LibroCantidadComprasNotas(this.value()-1);
    }
}