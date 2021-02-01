package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraNotaRegistro {
	void registrar(CompraNotaId pId, 
			CompraNotaNitProveedor pNitProveedor, 
			CompraNotaNumeroNota pNumeroNota,
			CompraNotaCodigoAutorizacion pCodigoAutorizacion, 
			CompraNotaFechaNota pFechaNota,
			CompraNotaImporteTotalNota pImporteTotalNota, 
			CompraNotaCodigoControlNota pCodigoControlNota,
			CompraNotaCompraId pCompraId, 
			CompraNotaTipoDocumentoCliente pTipoDocumentoCliente,
			CompraNotaNumeroDocumentoCliente pNumeroDocumentoCliente,
			CompraNotaComplementoDocumentoCliente pComplementoDocumentoCliente, 
			CompraNotaNombreCliente pNombreCliente,
			CompraNotaOrigenId pOrigenId, 
			CompraNotaUsuarioRegistro pUsuarioRegistro)
			throws QueryNotRegisteredError, QueryHandlerExecutionError, ValidatorNotExist;
}