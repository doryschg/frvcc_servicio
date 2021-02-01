package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public final class FormularioTotalVentas extends BigDecimalValueObject {
    public FormularioTotalVentas(BigDecimal value) {
        super(value);
    }
    public FormularioTotalVentas(){
        super(null);
    }
}
