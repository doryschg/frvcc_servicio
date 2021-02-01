package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.modificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaCodigoControlNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaFechaNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaImporteTotalNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNumeroNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraNotaModificar {
	void modificar(CompraNotaId pId,
    		CompraNotaNitProveedor pNitProveedor,
    		CompraNotaNumeroNota pNumeroNota,
    		CompraNotaCodigoAutorizacion pCodigoAutorizacion,
            CompraNotaFechaNota pFechaNota,
            CompraNotaImporteTotalNota pImporteTotalNota,
            CompraNotaCodigoControlNota pCodigoControlNota,
            CompraNotaOrigenId pOrigenId,
            CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion) throws QueryNotRegisteredError, QueryHandlerExecutionError ;
}
