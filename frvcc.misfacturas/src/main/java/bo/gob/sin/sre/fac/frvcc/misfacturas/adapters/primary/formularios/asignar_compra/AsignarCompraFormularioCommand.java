package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.asignar_compra;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class AsignarCompraFormularioCommand implements Command {
    private final String id;
    private final String compraId;
    private final Long usuarioUltimaModificacion;

    public AsignarCompraFormularioCommand(String id, String compraId, Long usuarioUltimaModificacion) {
        this.id = id;
        this.compraId = compraId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public String getId() {
        return id;
    }

    public String getCompraId() {
        return compraId;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
