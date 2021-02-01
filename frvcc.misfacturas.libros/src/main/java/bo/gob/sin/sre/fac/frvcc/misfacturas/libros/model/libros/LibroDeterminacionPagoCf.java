package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class LibroDeterminacionPagoCf extends BigDecimalValueObject {
    public LibroDeterminacionPagoCf(BigDecimal value) {
        super(value);
    }

    public static LibroDeterminacionPagoCf derterminacionPago(LibroTotalComprasCf totalCompras){
            return new LibroDeterminacionPagoCf( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public LibroDeterminacionPagoCf adicion(BigDecimal value){
        return new LibroDeterminacionPagoCf(value.add(value()));
    }

    public LibroDeterminacionPagoCf substracion(BigDecimal value){
        return new LibroDeterminacionPagoCf(value().subtract(value));
    }

    public LibroDeterminacionPagoCf() {
        super(null);
    }
} 
