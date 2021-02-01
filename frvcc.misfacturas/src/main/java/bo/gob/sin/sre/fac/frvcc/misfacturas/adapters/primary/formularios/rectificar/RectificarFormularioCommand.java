package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.rectificar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RectificarFormularioCommand implements Command {
	 private final String id;
	 private final Integer codAdmin;
	 private final Long usuarioUltimaModificacionId;

	    public RectificarFormularioCommand(String id,Integer codAdmin,Long usuarioUltimaModificacionId) {
	        this.id = id;
	        this.codAdmin=codAdmin;
	        this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
	    }

	    public String id() {
	        return id;
	    }
	    public Integer codAdmin()
	    {
	    	return codAdmin;
	    }
	    public Long usuarioUltimaModificacionId()
	    {
	    	return usuarioUltimaModificacionId;
	    }
}

