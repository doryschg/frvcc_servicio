package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.asociar_libro;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class AsociarLibroCompraNotaCommand implements Command {
    private final String id;
    private final String libroId;
    private final Long usuarioUltimaModificacion;

    public AsociarLibroCompraNotaCommand(String id, String libroId, Long usuarioUltimaModificacion) {
        this.id = id;
        this.libroId = libroId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public String id() {
        return id;
    }

    public String libroId() {
        return libroId;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
