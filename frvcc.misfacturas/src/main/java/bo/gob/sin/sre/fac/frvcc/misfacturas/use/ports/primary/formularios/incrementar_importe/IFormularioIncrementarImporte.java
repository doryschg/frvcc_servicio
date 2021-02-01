package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.incrementar_importe;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioIncrementarImporte {
	void incremento(FormularioId pFormularioId, BigDecimal pImporteBaseCf, BigDecimal pCreditoFiscal,
			FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraId pCompraId,
			BigDecimal pImporteTotalCompra, CompraMarcaEspecialId pMarcaEspecialId, String pModalidadId);
}
