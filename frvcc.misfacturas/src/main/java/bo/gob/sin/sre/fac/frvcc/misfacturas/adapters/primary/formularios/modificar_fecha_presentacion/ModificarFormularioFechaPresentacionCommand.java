package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modificar_fecha_presentacion;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.time.LocalDate;

public class ModificarFormularioFechaPresentacionCommand implements Command {
	   private final String id;
	   private final LocalDate fechaPresentacion;
	   private final Long usuarioUltimaModificacionId;
	   public  ModificarFormularioFechaPresentacionCommand(String id,LocalDate fechaPresentacion,Long usuarioUltimaModificacionId)
	   {
		   this.id=id;
		   this.fechaPresentacion=fechaPresentacion;
		   this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
	   }
	public String id() {
		return id;
	}
	public LocalDate fechaPresentacion() {
		return fechaPresentacion;
	}
	public Long usuarioUltimaModificacionId()
	{
		return usuarioUltimaModificacionId;
	}
	   
}
