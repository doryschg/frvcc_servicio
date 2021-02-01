package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroTotalComprasCfIpn extends BigDecimalValueObject {
    public LibroTotalComprasCfIpn(BigDecimal value) {
        super(value);
    }
    public LibroTotalComprasCfIpn adicion(BigDecimal value){
        return new LibroTotalComprasCfIpn(value.add(value()));
    }

    public LibroTotalComprasCfIpn substracion(BigDecimal value){
        return new LibroTotalComprasCfIpn(value().subtract(value));
    }
    public LibroTotalComprasCfIpn() {
        super(null);
    }
}
