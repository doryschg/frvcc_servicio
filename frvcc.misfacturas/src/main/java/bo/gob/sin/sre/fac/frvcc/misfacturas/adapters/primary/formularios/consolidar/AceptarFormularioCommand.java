package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.consolidar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class AceptarFormularioCommand implements Command {
	 private final String id;
	 private final Long usuarioUltimaModificacionId;
	 private final String loginUsuarioReceptor;
	 private final String nombreReceptor;
	 private final String esExDependiente;

	    public AceptarFormularioCommand(String id, Long usuarioUltimaModificacionId, String nombreReceptor, String loginUsuarioReceptor,
										String esExDependiente) {
	        this.id = id;
	        this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
			this.nombreReceptor=nombreReceptor;
	        this.loginUsuarioReceptor= loginUsuarioReceptor;
			this.esExDependiente = esExDependiente;
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
		public String esExDependiente(){return esExDependiente;}
}
