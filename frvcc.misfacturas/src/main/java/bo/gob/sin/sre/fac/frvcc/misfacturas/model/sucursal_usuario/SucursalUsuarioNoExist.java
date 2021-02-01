package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class SucursalUsuarioNoExist extends DomainError {
    public SucursalUsuarioNoExist(SucursalUsuarioId id) {
        super("El SucursalUsuario no existe", String.format("The SucursalUsuario <%s> doesn't exist", id.value()));
    }
}

