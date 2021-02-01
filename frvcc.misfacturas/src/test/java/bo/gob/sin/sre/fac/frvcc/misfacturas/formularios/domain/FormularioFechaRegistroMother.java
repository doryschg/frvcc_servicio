package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;

import java.time.LocalDateTime;

public final class FormularioFechaRegistroMother {
 public static FormularioFechaRegistro create(LocalDateTime value){
     return new FormularioFechaRegistro(value);
 }
 public static FormularioFechaRegistro random(){
     return create(LocalDateTime.now());
 }
}
