package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class LibroDeterminacionPago extends BigDecimalValueObject {
    public LibroDeterminacionPago(BigDecimal value) {
        super(value);
    }

    public static LibroDeterminacionPago derterminacionPago(LibroTotalComprasCf totalCompras){
            return new LibroDeterminacionPago( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public LibroDeterminacionPago adicion(BigDecimal value){
        return new LibroDeterminacionPago(value.add(value()));
    }

    public LibroDeterminacionPago substracion(BigDecimal value){
        return new LibroDeterminacionPago(value().subtract(value));
    }

    public LibroDeterminacionPago() {
        super(null);
    }
} 
