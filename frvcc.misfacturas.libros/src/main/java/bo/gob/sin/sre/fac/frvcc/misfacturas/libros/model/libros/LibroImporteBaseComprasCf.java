package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioTotalComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class LibroImporteBaseComprasCf extends BigDecimalValueObject {
    public LibroImporteBaseComprasCf(BigDecimal value) {
        super(value);
    }
    public LibroImporteBaseComprasCf adicion(BigDecimal value){
        return new LibroImporteBaseComprasCf(value.add(value()));
    }

    public LibroImporteBaseComprasCf substracion(BigDecimal value){
        return new LibroImporteBaseComprasCf(value().subtract(value));
    }
    public LibroImporteBaseComprasCf() {
        super(null);
    }
}