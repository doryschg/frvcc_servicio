package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioCantidadComprasCfOtras;
import bo.gob.sin.sre.fac.frvcc.shared.model.IntValueObject;

public class LibroNumeroEnvio extends IntValueObject {
    public LibroNumeroEnvio(Integer value) {
        super(value);

    }

    public LibroNumeroEnvio() {
        super(null);
    }
    public LibroNumeroEnvio incrementar(){
        return new LibroNumeroEnvio(this.value()+1);
    }
   
}
