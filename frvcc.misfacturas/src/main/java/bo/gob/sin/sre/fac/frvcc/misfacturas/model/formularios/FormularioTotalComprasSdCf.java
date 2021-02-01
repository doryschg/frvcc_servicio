package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class FormularioTotalComprasSdCf extends BigDecimalValueObject {
    public FormularioTotalComprasSdCf(BigDecimal value) {
        super(value);
    }
    public FormularioTotalComprasSdCf adicion(BigDecimal value){
        return new FormularioTotalComprasSdCf(value.add(value()));
    }

    public FormularioTotalComprasSdCf substracion(BigDecimal value){
        return new FormularioTotalComprasSdCf(value().subtract(value));
    }
    public FormularioTotalComprasSdCf() {
        super(null);
    }
}
