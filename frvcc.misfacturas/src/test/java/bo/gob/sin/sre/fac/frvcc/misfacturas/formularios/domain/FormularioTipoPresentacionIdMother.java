package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioTipoPresentacionIdMother {
 public static FormularioTipoPresentacionId create(String value){
     return new FormularioTipoPresentacionId(value);
 }
 public static FormularioTipoPresentacionId random(){
     return create(WordMother.random());
 }
}
