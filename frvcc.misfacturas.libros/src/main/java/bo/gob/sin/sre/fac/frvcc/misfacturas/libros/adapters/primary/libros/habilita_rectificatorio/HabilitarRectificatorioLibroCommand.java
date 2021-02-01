package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.habilita_rectificatorio;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class HabilitarRectificatorioLibroCommand implements Command {
    private final String id;
    private final Long usuarioUltimaModificacionId;

    public HabilitarRectificatorioLibroCommand(String id,Long usuarioUltimaModificacionId) {
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

