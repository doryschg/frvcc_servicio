package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_tipo_compra_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraModificadorTipoCompraLibro {
	void modificarTipoCompra(CompraId pId, CompraTipoCompraId pTipoCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion)
			throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
