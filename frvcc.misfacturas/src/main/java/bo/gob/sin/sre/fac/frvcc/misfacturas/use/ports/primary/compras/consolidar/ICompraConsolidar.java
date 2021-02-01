package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.consolidar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface ICompraConsolidar {
	 void consolidar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion);

}
