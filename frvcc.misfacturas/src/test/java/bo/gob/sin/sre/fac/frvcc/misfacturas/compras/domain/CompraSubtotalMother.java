package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraSubtotal;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.BigDecimalMother;

import java.math.BigDecimal;



public final class CompraSubtotalMother {
       public static CompraSubtotal create(BigDecimal value){
               return new CompraSubtotal(value);
           }
           public static CompraSubtotal random(){
               return create(BigDecimalMother.random());
           }

}
