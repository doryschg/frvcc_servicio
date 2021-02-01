package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface IComprasDeclarar {
    void declarar(CompraFormularioId pFormularioId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
