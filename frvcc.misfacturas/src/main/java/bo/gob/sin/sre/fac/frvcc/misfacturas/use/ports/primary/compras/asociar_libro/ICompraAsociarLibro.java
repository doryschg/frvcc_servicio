package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.asociar_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraAsociarLibro {
    void asociarLibro(CompraId pId,
            CompraLibroId pFormularioId,
            CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,CompraPeriodoUso pPeriodoUso,
            CompraGestionUso pGestionUso,
            CompraNombreFormularioUso pNombreFormulrioUso) throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
