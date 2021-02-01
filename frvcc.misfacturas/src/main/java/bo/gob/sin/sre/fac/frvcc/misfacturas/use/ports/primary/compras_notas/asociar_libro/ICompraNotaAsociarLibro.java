package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.asociar_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ICompraNotaAsociarLibro {
    void asociarLibro(CompraNotaId pId,
            CompraNotaLibroId pFormularioId,
            CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion,
            CompraNotaPeriodoUso pPeriodoUso,
            CompraNotaGestionUso pGestionUso,
            CompraNotaNombreFormularioUso pNombreFormulrioUso) throws QueryNotRegisteredError, QueryHandlerExecutionError;
}
