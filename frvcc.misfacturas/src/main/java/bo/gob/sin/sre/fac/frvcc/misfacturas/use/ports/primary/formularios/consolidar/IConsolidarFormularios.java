package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.consolidar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;

import java.util.List;

public interface IConsolidarFormularios {
    public void consolidar( List<FormularioId> pIds,
                            ConsolidacionId pIdConsolidacion,
                            ConsolidacionUsuarioUltimaModificacion pUsuarioUltimaModificacion
    );
}
