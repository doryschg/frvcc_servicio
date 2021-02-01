package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import java.time.LocalDateTime;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioFechaUltimaModificacionMother {
 public static FormularioFechaUltimaModificacion create(LocalDateTime value){
     return new FormularioFechaUltimaModificacion(value);
 }
 public static FormularioFechaUltimaModificacion random(){
     return create(LocalDateTime.now());
 }
}
