package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;



public final class CompraPeriodoUsoMother {
       public static CompraPeriodoUso create(Integer value){
               return new CompraPeriodoUso(value);
           }
           public static CompraPeriodoUso random(){
               return create(IntegerMother.random());
           }

}
