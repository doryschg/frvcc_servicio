package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class FormularioDeterminacionPagoCfIpn extends BigDecimalValueObject {
    public FormularioDeterminacionPagoCfIpn(BigDecimal value) {
        super(value);
    }

    public static FormularioDeterminacionPagoCfIpn derterminacionPago(FormularioTotalComprasCf totalCompras){
            return new FormularioDeterminacionPagoCfIpn( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public FormularioDeterminacionPagoCfIpn adicion(BigDecimal value){
        return new FormularioDeterminacionPagoCfIpn(value.add(value()));
    }

    public FormularioDeterminacionPagoCfIpn substracion(BigDecimal value){
        return new FormularioDeterminacionPagoCfIpn(value().subtract(value));
    }

    public FormularioDeterminacionPagoCfIpn() {
        super(null);
    }
} 
