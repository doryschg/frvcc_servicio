package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public class LibroDeterminacionPagoCfOtras extends BigDecimalValueObject {
    public LibroDeterminacionPagoCfOtras(BigDecimal value) {
        super(value);
    }

    public static LibroDeterminacionPagoCfOtras derterminacionPago(LibroTotalComprasCf totalCompras){
            return new LibroDeterminacionPagoCfOtras( totalCompras.value().multiply( new BigDecimal(Utils.IMPUESTO_IVA)));

    }
    public LibroDeterminacionPagoCfOtras adicion(BigDecimal value){
        return new LibroDeterminacionPagoCfOtras(value.add(value()));
    }

    public LibroDeterminacionPagoCfOtras substracion(BigDecimal value){
        return new LibroDeterminacionPagoCfOtras(value().subtract(value));
    }

    public LibroDeterminacionPagoCfOtras() {
        super(null);
    }
} 
