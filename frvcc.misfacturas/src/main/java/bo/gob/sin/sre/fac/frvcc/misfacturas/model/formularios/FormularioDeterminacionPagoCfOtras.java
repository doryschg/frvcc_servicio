package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class FormularioDeterminacionPagoCfOtras extends BigDecimalValueObject {
    public FormularioDeterminacionPagoCfOtras(BigDecimal value) {
        super(value);
    }

    public static FormularioDeterminacionPagoCfOtras derterminacionPago(FormularioTotalComprasCf totalCompras){
            return new FormularioDeterminacionPagoCfOtras( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public FormularioDeterminacionPagoCfOtras adicion(BigDecimal value){
        return new FormularioDeterminacionPagoCfOtras(value.add(value()));
    }

    public FormularioDeterminacionPagoCfOtras substracion(BigDecimal value){
        return new FormularioDeterminacionPagoCfOtras(value().subtract(value));
    }

    public FormularioDeterminacionPagoCfOtras() {
        super(null);
    }
} 
