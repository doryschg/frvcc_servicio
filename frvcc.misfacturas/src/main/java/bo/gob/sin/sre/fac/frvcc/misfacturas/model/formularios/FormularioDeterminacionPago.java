package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class FormularioDeterminacionPago extends BigDecimalValueObject {
    public FormularioDeterminacionPago(BigDecimal value) {
        super(value);
    }

    public static FormularioDeterminacionPago derterminacionPago(FormularioTotalComprasCf totalCompras){
            return new FormularioDeterminacionPago( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public FormularioDeterminacionPago adicion(BigDecimal value){
        return new FormularioDeterminacionPago(value.add(value()));
    }

    public FormularioDeterminacionPago substracion(BigDecimal value){
        return new FormularioDeterminacionPago(value().subtract(value));
    }

    public FormularioDeterminacionPago() {
        super(null);
    }
} 
