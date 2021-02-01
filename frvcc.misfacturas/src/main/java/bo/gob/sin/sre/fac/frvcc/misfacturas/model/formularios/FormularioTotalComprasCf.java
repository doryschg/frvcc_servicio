package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class FormularioTotalComprasCf extends BigDecimalValueObject {
    public FormularioTotalComprasCf(BigDecimal value) {
        super(value);
    }
    public FormularioTotalComprasCf adicion(BigDecimal value){
        return new FormularioTotalComprasCf(value.add(value()));
    }

    public FormularioTotalComprasCf substracion(BigDecimal value){
        return new FormularioTotalComprasCf(value().subtract(value));
    }
    public FormularioTotalComprasCf() {
        super(null);
    }
}
