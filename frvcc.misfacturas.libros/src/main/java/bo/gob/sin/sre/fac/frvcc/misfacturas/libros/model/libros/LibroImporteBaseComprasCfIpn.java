package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public class LibroImporteBaseComprasCfIpn extends BigDecimalValueObject {
    public LibroImporteBaseComprasCfIpn(BigDecimal value) {
        super(value);
    }
    public LibroImporteBaseComprasCfIpn adicion(BigDecimal value){
        return new LibroImporteBaseComprasCfIpn(value.add(value()));
    }

    public LibroImporteBaseComprasCfIpn substracion(BigDecimal value){
        return new LibroImporteBaseComprasCfIpn(value().subtract(value));
    }
    public LibroImporteBaseComprasCfIpn() {
        super(null);
    }
}
