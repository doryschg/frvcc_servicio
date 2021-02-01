package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroImporteBaseComprasCfElec extends BigDecimalValueObject {
    public LibroImporteBaseComprasCfElec(BigDecimal value) {
        super(value);
    }
    public LibroImporteBaseComprasCfElec adicion(BigDecimal value){
        return new LibroImporteBaseComprasCfElec(value.add(value()));
    }

    public LibroImporteBaseComprasCfElec substracion(BigDecimal value){
        return new LibroImporteBaseComprasCfElec(value().subtract(value));
    }
    public LibroImporteBaseComprasCfElec() {
        super(null);
    }
}
