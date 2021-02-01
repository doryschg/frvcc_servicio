package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraDescuento;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.BigDecimalMother;

import java.math.BigDecimal;



public final class CompraDescuentoMother {
       public static CompraDescuento create(BigDecimal value){
               return new CompraDescuento(value);
           }
           public static CompraDescuento random(){
               return create(BigDecimalMother.random());
           }

}
