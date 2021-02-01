package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.cancelar_declaracion;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class CancelarDeclaracionFormularioCommand implements Command {
    private final String id;
    private final Long usuarioUltimaModificacion;
   
    public CancelarDeclaracionFormularioCommand(String id, Long usuarioUltimaModificacion) {
       this.id = id;
       this.usuarioUltimaModificacion=usuarioUltimaModificacion;
    }
    public String id() {
        return id;
    }
    public Long usuarioUltimaModificacion()
    {
    	return usuarioUltimaModificacion;
    }
  
}

