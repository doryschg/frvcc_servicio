package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.habilitar_rectificatorio_fanexo;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class HabilitarRectificatorioFormularioCommand implements Command {
    private final String id;
    private final Long usuarioUltimaModificacionId;

    public HabilitarRectificatorioFormularioCommand(String id,Long usuarioUltimaModificacionId) {
        this.id = id;
        this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
    }

    public String id() {
        return id;
    }

 
    public Long usuarioUltimaModificacionId()
    {
    	return usuarioUltimaModificacionId;
    }
}

