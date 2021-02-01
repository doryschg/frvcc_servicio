package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.declarar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class DeclararLibroCommand implements Command {
    private final String id;
    private final Integer codAdmin;
    private final Long usuarioUltimaModificacionId;

    public DeclararLibroCommand(String id, Integer codAdmin,Long usuarioUltimaModificacionId) {
        this.id = id;
        this.codAdmin = codAdmin;
        this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
    }

    public String id() {
        return id;
    }

    public Integer codAdmin() {
        return codAdmin;
    }
    public Long usuarioUltimaModificacionId()
    {
    	return usuarioUltimaModificacionId;
    }
}

