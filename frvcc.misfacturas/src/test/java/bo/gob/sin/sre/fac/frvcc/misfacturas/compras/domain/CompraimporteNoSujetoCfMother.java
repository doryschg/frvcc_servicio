package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteNoSujetoCf;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.BigDecimalMother;

import java.math.BigDecimal;



public final class CompraimporteNoSujetoCfMother {
       public static CompraImporteNoSujetoCf create(BigDecimal value){
               return new CompraImporteNoSujetoCf(value);
           }
           public static CompraImporteNoSujetoCf random(){
               return create(BigDecimalMother.random());
           }

}
