package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modifcar_compra_seleccionada;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;

public interface IFormularioModificarCompraSeleccionado {
   void modifciarCompraSeleccionado(                                    CompraId pCompraId,
                                    CompraImporteTotalCompra pImporteTotalCompra,
                                    CompraFechaFactura pFechaFactura,
                                    CompraCodigoControl pCodigoControl,
                                    CompraOrigenId pOrigenId,
                                    FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
