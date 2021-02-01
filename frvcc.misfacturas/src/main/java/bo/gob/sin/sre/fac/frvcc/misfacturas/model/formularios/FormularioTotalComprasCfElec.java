package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class FormularioTotalComprasCfElec extends BigDecimalValueObject {
    public FormularioTotalComprasCfElec(BigDecimal value) {
        super(value);
    }
    public FormularioTotalComprasCfElec adicion(BigDecimal value){
        return new FormularioTotalComprasCfElec(value.add(value()));
    }

    public FormularioTotalComprasCfElec substracion(BigDecimal value){
        return new FormularioTotalComprasCfElec(value().subtract(value));
    }
    public FormularioTotalComprasCfElec() {
        super(null);
    }
}
