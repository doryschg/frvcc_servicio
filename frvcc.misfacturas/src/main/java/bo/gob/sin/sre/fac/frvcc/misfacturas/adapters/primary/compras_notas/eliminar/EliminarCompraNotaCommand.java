package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.eliminar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;


public final class EliminarCompraNotaCommand implements Command {
    private final String id ;
    private final Long usuarioUltimaModificacion;

    public EliminarCompraNotaCommand(String id, Long usuarioUltimaModificacion) {

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
