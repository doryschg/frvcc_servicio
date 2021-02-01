package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteTotalCompra;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.BigDecimalMother;

import java.math.BigDecimal;



public final class CompraImporteTotalCompraMother {
   public static CompraImporteTotalCompra create(BigDecimal value){
           return new CompraImporteTotalCompra(value);
       }
       public static CompraImporteTotalCompra random(){
           return create(BigDecimalMother.random());
       }
}
