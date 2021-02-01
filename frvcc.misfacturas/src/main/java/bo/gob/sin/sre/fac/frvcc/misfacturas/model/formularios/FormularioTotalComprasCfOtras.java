package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class FormularioTotalComprasCfOtras extends BigDecimalValueObject {
    public FormularioTotalComprasCfOtras(BigDecimal value) {
        super(value);
    }
    public FormularioTotalComprasCfOtras adicion(BigDecimal value){
        return new FormularioTotalComprasCfOtras(value.add(value()));
    }

    public FormularioTotalComprasCfOtras substracion(BigDecimal value){
        return new FormularioTotalComprasCfOtras(value().subtract(value));
    }
    public FormularioTotalComprasCfOtras() {
        super(null);
    }
}
