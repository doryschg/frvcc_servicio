package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.declarar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class DeclararCompraCommand implements Command {
    private final String id;
    private final Long usuarioUltimaModificacion;

    public DeclararCompraCommand(String pId, Long usuarioUltimaModificacion) {
        this.id = pId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public String getId() {
        return id;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
