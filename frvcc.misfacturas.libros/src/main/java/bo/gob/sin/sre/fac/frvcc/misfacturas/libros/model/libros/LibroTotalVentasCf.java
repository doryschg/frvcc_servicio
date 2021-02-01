package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioTotalComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class LibroTotalVentasCf extends BigDecimalValueObject {
    public LibroTotalVentasCf(BigDecimal value) {
        super(value);
    }
    public FormularioTotalComprasCf adicion(BigDecimal value){
        return new FormularioTotalComprasCf(value.add(value()));
    }

    public FormularioTotalComprasCf substracion(BigDecimal value){
        return new FormularioTotalComprasCf(value().subtract(value));
    }
    public LibroTotalVentasCf() {
        super(null);
    }
}