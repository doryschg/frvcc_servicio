package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.consolidar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class ConsolidarCompraCommandImpl implements Command {
    private final String id;
    private final Long usuarioUltimaModificacion;

    public ConsolidarCompraCommandImpl(String id, Long usuarioUltimaModificacion) {
        this.id = id;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }
    public String getId() {
        return id;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
