package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.usuario.obtener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario.UsuariosResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;

import java.util.Optional;

public interface IBuscarUsuarioQueryService {
    UsuariosResponse obtenerUsuarios(
             Long pNit
     );
}
