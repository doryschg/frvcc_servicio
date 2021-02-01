package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.desmarcar_compras;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioDesmarcarCompras {
	void decrementarImporte(FormularioId pFormularioId,
			FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, List<String> pListaIdsCompras);
}
