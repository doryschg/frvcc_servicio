package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioTotalComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class LibroTotalComprasCf extends BigDecimalValueObject {
    public LibroTotalComprasCf(BigDecimal value) {
        super(value);
    }
    public LibroTotalComprasCf adicion(BigDecimal value){
        return new LibroTotalComprasCf(value.add(value()));
    }

    public LibroTotalComprasCf substracion(BigDecimal value){
        return new LibroTotalComprasCf(value().subtract(value));
    }
    public LibroTotalComprasCf() {
        super(null);
    }
}