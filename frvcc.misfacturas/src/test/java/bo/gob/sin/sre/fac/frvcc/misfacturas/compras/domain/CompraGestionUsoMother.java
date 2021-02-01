package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;


public final class CompraGestionUsoMother {
       public static CompraGestionUso create(Integer value){
               return new CompraGestionUso(value);
           }
           public static CompraGestionUso random(){
               return create(IntegerMother.random());
           }

}
