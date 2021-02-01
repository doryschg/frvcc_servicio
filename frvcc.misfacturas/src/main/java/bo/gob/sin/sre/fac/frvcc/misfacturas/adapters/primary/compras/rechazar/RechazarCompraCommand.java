package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.rechazar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RechazarCompraCommand implements Command {
    private final String id;
    private final Long usuarioUltimaModificacion;

    public RechazarCompraCommand(String id, Long usuarioUltimaModificacion) {
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
