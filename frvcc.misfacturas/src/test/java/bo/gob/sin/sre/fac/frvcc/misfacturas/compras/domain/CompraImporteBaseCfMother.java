package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteBaseCf;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.BigDecimalMother;

import java.math.BigDecimal;



public final class CompraImporteBaseCfMother {
       public static CompraImporteBaseCf create(BigDecimal value){
               return new CompraImporteBaseCf(value);
           }
           public static CompraImporteBaseCf random(){
               return create(BigDecimalMother.random());
           }


}
