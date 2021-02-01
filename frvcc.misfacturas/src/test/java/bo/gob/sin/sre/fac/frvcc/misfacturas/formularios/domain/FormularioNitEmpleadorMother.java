package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioNitEmpleadorMother {
 public static FormularioNitEmpleador create(Long value){
     return new FormularioNitEmpleador(value);
 }
 public static FormularioNitEmpleador random(){
     return create(LongMother.random());
 }
}
