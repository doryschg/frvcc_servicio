package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioIfcMother {
 public static FormularioIfc create(Long value){
     return new FormularioIfc(value);
 }
 public static FormularioIfc random(){
     return create(LongMother.random());
 }
}
