package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.eliminar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;


public final class EliminarFormularioCommand implements Command {
    private final String id ;
    private final Long usuarioUltimaModificacion;

    public EliminarFormularioCommand(String id, Long usuarioUltimaModificacion) {

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
