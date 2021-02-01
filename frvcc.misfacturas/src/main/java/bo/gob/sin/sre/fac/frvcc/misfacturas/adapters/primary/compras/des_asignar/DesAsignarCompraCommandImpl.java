package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.des_asignar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class DesAsignarCompraCommandImpl implements Command {
    private final String id;
    private final String formularioId;
    private final Long usuarioUltimaModificacion;




    public DesAsignarCompraCommandImpl(String pId, String pFormularioId, Long pUsuarioUltimaModificacion) {
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
