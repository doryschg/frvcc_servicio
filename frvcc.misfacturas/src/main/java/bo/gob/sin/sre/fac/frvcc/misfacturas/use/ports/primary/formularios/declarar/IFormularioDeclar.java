package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioDeclar {
    void declarar(FormularioId pFormularioId, Integer pCodAdmin, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
