package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class FormularioTotalComprasCfIpn extends BigDecimalValueObject {
    public FormularioTotalComprasCfIpn(BigDecimal value) {
        super(value);
    }
    public FormularioTotalComprasCfIpn adicion(BigDecimal value){
        return new FormularioTotalComprasCfIpn(value.add(value()));
    }

    public FormularioTotalComprasCfIpn substracion(BigDecimal value){
        return new FormularioTotalComprasCfIpn(value().subtract(value));
    }
    public FormularioTotalComprasCfIpn() {
        super(null);
    }
}
