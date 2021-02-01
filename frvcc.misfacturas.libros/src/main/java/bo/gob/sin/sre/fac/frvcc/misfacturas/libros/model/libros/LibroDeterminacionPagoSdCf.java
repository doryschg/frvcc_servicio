package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class LibroDeterminacionPagoSdCf extends BigDecimalValueObject {
    public LibroDeterminacionPagoSdCf(BigDecimal value) {
        super(value);
    }

    public static LibroDeterminacionPagoSdCf derterminacionPago(LibroTotalComprasCf totalCompras){
            return new LibroDeterminacionPagoSdCf( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public LibroDeterminacionPagoSdCf adicion(BigDecimal value){
        return new LibroDeterminacionPagoSdCf(value.add(value()));
    }

    public LibroDeterminacionPagoSdCf substracion(BigDecimal value){
        return new LibroDeterminacionPagoSdCf(value().subtract(value));
    }

    public LibroDeterminacionPagoSdCf() {
        super(null);
    }
} 
