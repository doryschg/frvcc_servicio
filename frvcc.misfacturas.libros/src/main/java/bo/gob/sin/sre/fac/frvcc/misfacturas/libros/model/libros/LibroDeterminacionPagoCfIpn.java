package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class LibroDeterminacionPagoCfIpn extends BigDecimalValueObject {
    public LibroDeterminacionPagoCfIpn(BigDecimal value) {
        super(value);
    }

    public static LibroDeterminacionPagoCfIpn derterminacionPago(LibroTotalComprasCf totalCompras){
            return new LibroDeterminacionPagoCfIpn( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public LibroDeterminacionPagoCfIpn adicion(BigDecimal value){
        return new LibroDeterminacionPagoCfIpn(value.add(value()));
    }

    public LibroDeterminacionPagoCfIpn substracion(BigDecimal value){
        return new LibroDeterminacionPagoCfIpn(value().subtract(value));
    }

    public LibroDeterminacionPagoCfIpn() {
        super(null);
    }
} 
