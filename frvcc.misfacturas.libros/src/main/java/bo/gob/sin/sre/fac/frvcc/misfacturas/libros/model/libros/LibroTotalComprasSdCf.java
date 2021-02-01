package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroTotalComprasSdCf extends BigDecimalValueObject {
    public LibroTotalComprasSdCf(BigDecimal value) {
        super(value);
    }
    public LibroTotalComprasSdCf adicion(BigDecimal value){
        return new LibroTotalComprasSdCf(value.add(value()));
    }

    public LibroTotalComprasSdCf substracion(BigDecimal value){
        return new LibroTotalComprasSdCf(value().subtract(value));
    }
    public LibroTotalComprasSdCf() {
        super(null);
    }
}
