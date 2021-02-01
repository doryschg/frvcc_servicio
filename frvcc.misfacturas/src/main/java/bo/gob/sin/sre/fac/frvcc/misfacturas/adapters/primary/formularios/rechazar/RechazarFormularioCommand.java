package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.rechazar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class RechazarFormularioCommand implements Command {
	 	private final String id;
	 	private final Long usuarioUltimaModificacionId;
		private final String loginUsuarioReceptor;
		private final String nombreReceptor;

	    public RechazarFormularioCommand(String id,Long usuarioUltimaModificacionId, String nombreReceptor, String loginUsuarioReceptor ) {
	        this.id = id;
	        this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
			this.nombreReceptor=nombreReceptor;
	        this.loginUsuarioReceptor=loginUsuarioReceptor;

	    }

	    public String id() {
	        return id;
	    }
	    public Long usuarioUltimaModificacionId()
	    {
	    	return usuarioUltimaModificacionId;
	    }
		public String loginUsuarioReceptor() {
		return loginUsuarioReceptor;
	}
		public String nombreReceptor() {
		return nombreReceptor;
	}
}
