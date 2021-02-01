package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.rectificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioRectificar {
	void rectificar(FormularioId pFormularioId, Integer pCodAdmin, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
