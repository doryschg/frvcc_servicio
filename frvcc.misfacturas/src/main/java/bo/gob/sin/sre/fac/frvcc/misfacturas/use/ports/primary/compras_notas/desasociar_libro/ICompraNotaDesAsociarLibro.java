package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.desasociar_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;

public interface ICompraNotaDesAsociarLibro {
	void desAsociarLibro(CompraNotaId pId, CompraNotaLibroId pLibroId,
			CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraNotaPeriodoUso pPeriodoUso,
			CompraNotaGestionUso pGestionUso, CompraNotaNombreFormularioUso pNombreFormulrioUso);
}
