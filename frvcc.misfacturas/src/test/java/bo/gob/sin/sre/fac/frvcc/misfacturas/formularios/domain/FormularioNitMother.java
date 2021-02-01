package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioNitMother {
 public static FormularioNitCi create(Long value){
     return new FormularioNitCi(value);
 }
 public static FormularioNitCi random(){
     return create(LongMother.random());
 }
}
