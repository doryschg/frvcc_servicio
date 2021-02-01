package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;

public final class FormularioNumeroEnvioMother {
 public static FormularioNumeroEnvio create(Integer value){
     return new FormularioNumeroEnvio(value);
 }
 public static FormularioNumeroEnvio random(){
     return create(IntegerMother.random());
 }
}
