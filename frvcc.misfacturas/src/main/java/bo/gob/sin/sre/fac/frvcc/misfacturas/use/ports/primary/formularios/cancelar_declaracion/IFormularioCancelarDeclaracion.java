package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.cancelar_declaracion;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioCancelarDeclaracion {
	void cancelarDeclarcion(FormularioId pFormularioId, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
