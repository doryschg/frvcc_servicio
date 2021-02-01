package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class FormularioDeterminacionPagoSdCf extends BigDecimalValueObject {
    public FormularioDeterminacionPagoSdCf(BigDecimal value) {
        super(value);
    }

    public static FormularioDeterminacionPagoSdCf derterminacionPago(FormularioTotalComprasCf totalCompras){
            return new FormularioDeterminacionPagoSdCf( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public FormularioDeterminacionPagoSdCf adicion(BigDecimal value){
        return new FormularioDeterminacionPagoSdCf(value.add(value()));
    }

    public FormularioDeterminacionPagoSdCf substracion(BigDecimal value){
        return new FormularioDeterminacionPagoSdCf(value().subtract(value));
    }

    public FormularioDeterminacionPagoSdCf() {
        super(null);
    }
} 
