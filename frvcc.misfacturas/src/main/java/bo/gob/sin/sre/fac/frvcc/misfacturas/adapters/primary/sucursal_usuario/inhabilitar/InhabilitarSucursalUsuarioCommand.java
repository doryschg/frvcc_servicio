package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.inhabilitar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;


public final class InhabilitarSucursalUsuarioCommand implements Command {
    private final String id ;
    private final Long usuarioUltimaModificacion;

    public InhabilitarSucursalUsuarioCommand(String id, Long usuarioUltimaModificacion) {

        this.id = id;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public String id() {
        return id;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
