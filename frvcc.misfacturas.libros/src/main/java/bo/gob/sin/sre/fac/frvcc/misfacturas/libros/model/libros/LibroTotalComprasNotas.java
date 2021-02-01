package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioTotalComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class LibroTotalComprasNotas extends BigDecimalValueObject {
    public LibroTotalComprasNotas(BigDecimal value) {
        super(value);
    }
    public LibroTotalComprasNotas adicion(BigDecimal value){
        return new LibroTotalComprasNotas(value.add(value()));
    }

    public LibroTotalComprasNotas substracion(BigDecimal value){
        return new LibroTotalComprasNotas(value().subtract(value));
    }
    public LibroTotalComprasNotas() {
        super(null);
    }
}