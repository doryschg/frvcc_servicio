package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asignar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class AsignarCompraCommandImpl implements Command {
    private final String id;
    private final String formularioId;
    private final Long usuarioUltimaModificacion;

    public AsignarCompraCommandImpl(String pId, String pFormularioId, Long pUsuarioUltimaModificacion) {
        this.id = pId;
        this.formularioId = pFormularioId;
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
    }

    public String id() {
        return id;
    }

    public String formularioId() {
        return formularioId;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
