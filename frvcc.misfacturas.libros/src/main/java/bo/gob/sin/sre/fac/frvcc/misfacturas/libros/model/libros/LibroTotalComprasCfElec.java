package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroTotalComprasCfElec extends BigDecimalValueObject {
    public LibroTotalComprasCfElec(BigDecimal value) {
        super(value);
    }
    public LibroTotalComprasCfElec adicion(BigDecimal value){
        return new LibroTotalComprasCfElec(value.add(value()));
    }

    public LibroTotalComprasCfElec substracion(BigDecimal value){
        return new LibroTotalComprasCfElec(value().subtract(value));
    }
    public LibroTotalComprasCfElec() {
        super(null);
    }
}
