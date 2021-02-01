package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;

public final class FormularioUsuarioUltimaModificacionMother {
 public static FormularioUsuarioUltimaModificacion create(Long value){
     return new FormularioUsuarioUltimaModificacion(value);
 }
 public static FormularioUsuarioUltimaModificacion random(){
     return create(LongMother.random());
 }
}
