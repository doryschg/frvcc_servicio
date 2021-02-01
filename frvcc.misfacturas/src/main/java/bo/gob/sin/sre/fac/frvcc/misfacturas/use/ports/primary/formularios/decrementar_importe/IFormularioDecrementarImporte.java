package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.decrementar_importe;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioDecrementarImporte {
	void decrementar(FormularioId pFormularioId,
            BigDecimal pImporteBaseCf,
            BigDecimal pCreditoFiscal,
            CompraId pCompraId,
            FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion
            ,BigDecimal importeTotalCompra,CompraMarcaEspecialId marcaEspecialId,String modalidadId);
}
