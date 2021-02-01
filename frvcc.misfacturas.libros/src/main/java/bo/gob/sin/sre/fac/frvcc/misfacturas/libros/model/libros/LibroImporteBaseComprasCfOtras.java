package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroImporteBaseComprasCfOtras extends BigDecimalValueObject {
    public LibroImporteBaseComprasCfOtras(BigDecimal value) {
        super(value);
    }
    public LibroImporteBaseComprasCfOtras adicion(BigDecimal value){
        return new LibroImporteBaseComprasCfOtras(value.add(value()));
    }

    public LibroImporteBaseComprasCfOtras substracion(BigDecimal value){
        return new LibroImporteBaseComprasCfOtras(value().subtract(value));
    }
    public LibroImporteBaseComprasCfOtras() {
        super(null);
    }
}
