package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.eliminar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;


public final class EliminarCompraCommand implements Command {
    private final String id ;
    private final Long usuarioUltimaModificacion;

    public EliminarCompraCommand(String id, Long usuarioUltimaModificacion) {

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
