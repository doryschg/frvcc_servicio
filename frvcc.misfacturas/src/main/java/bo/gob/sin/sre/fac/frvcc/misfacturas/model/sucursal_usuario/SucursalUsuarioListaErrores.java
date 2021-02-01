package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public final class SucursalUsuarioListaErrores  extends DomainError implements Serializable {
    public SucursalUsuarioListaErrores(SucursalUsuarioId id) {
        super("La SucursalUsuario no existe", String.format("La SucursalUsuario <%s> doesn't exist", id.value()));
    }

    public SucursalUsuarioListaErrores(SucursalUsuarioId id,ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public SucursalUsuarioListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
