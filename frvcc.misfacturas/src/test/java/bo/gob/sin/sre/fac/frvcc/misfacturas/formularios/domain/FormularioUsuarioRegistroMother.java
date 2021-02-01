package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioUsuarioRegistroMother {
 public static FormularioUsuarioRegistro create(Long value){
     return new FormularioUsuarioRegistro(value);
 }
 public static FormularioUsuarioRegistro random(){
     return create(LongMother.random());
 }
}
