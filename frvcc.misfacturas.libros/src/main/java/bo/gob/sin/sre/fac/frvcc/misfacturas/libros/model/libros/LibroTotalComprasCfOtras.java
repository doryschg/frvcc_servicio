package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroTotalComprasCfOtras extends BigDecimalValueObject {
    public LibroTotalComprasCfOtras(BigDecimal value) {
        super(value);
    }
    public LibroTotalComprasCfOtras adicion(BigDecimal value){
        return new LibroTotalComprasCfOtras(value.add(value()));
    }

    public LibroTotalComprasCfOtras substracion(BigDecimal value){
        return new LibroTotalComprasCfOtras(value().subtract(value));
    }
    public LibroTotalComprasCfOtras() {
        super(null);
    }
}
