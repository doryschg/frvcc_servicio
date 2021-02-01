package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.desasignar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

import java.util.List;

public interface ICompraDesasignar {
	void desAsignar(List<CompraId> pIds, CompraFormularioId pFormularioId,
                    CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraPeriodoUso pPeriodoUso,
                    CompraGestionUso pGestionUso, CompraNombreFormularioUso pNombreFormulrioUso, String pTipoformularioId);

}
