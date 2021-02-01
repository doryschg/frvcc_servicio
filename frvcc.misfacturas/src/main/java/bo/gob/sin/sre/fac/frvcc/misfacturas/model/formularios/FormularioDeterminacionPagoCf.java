package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class FormularioDeterminacionPagoCf extends BigDecimalValueObject {
    public FormularioDeterminacionPagoCf(BigDecimal value) {
        super(value);
    }

    public static FormularioDeterminacionPagoCf derterminacionPago(FormularioTotalComprasCf totalCompras){
            return new FormularioDeterminacionPagoCf( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public FormularioDeterminacionPagoCf adicion(BigDecimal value){
        return new FormularioDeterminacionPagoCf(value.add(value()));
    }

    public FormularioDeterminacionPagoCf substracion(BigDecimal value){
        return new FormularioDeterminacionPagoCf(value().subtract(value));
    }

    public FormularioDeterminacionPagoCf() {
        super(null);
    }
} 
