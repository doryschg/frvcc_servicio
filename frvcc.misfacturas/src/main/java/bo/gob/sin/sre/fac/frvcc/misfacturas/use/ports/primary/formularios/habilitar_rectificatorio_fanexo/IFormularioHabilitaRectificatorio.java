package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.habilitar_rectificatorio_fanexo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioHabilitaRectificatorio {
	void habilitarFormularioanexoRectificatorio(FormularioId pFormularioId,FormularioUsuarioUltimaModificacion pUsuarioultimaModificacion);
}
