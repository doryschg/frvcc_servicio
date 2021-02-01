package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCreditoFiscal;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.BigDecimalMother;

import java.math.BigDecimal;



public final class CompraCreditoFiscalMother {
       public static CompraCreditoFiscal create(BigDecimal value){
               return new CompraCreditoFiscal(value);
           }
           public static CompraCreditoFiscal random(){
               return create(BigDecimalMother.random());
           }

}
