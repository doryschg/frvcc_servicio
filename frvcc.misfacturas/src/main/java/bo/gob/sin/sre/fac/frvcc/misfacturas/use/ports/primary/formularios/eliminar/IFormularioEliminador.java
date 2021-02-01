package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.eliminar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioEliminador {
	void eliminar(FormularioId pId, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
