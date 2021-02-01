package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.time.LocalDate;

public final class ModifcarFormularioCommand implements Command {
    private final String id;
    private final String direccion;
    private final String direccionEmpleador;
    private final Long usuarioUltimaModificacion;
    private final Integer lugarDepartamento;
    private final LocalDate fechaPresentacion;
    private final Integer numeroSucursal;
    private final DatosEspecificos datosEspecificos;
    private final String esExDependiente;
  

    public ModifcarFormularioCommand(String id, String direccion, String direccionEmpleador, Long usuarioUltimaModificacion, Integer lugarDepartamento,
                                     LocalDate fechaPresentacion, Integer numeroSucursal, DatosEspecificos datosEspecificos, String esExDependiente) {
        this.id = id;
        this.direccion = direccion;
        this.direccionEmpleador = direccionEmpleador;
        this.usuarioUltimaModificacion=usuarioUltimaModificacion;
        this.lugarDepartamento=lugarDepartamento;
        this.fechaPresentacion=fechaPresentacion;
        this.numeroSucursal=numeroSucursal;
        this.datosEspecificos=datosEspecificos;
        this.esExDependiente = esExDependiente;
    }

    public String id() {
        return id;
    }


    public String direccion() {
        return direccion;
    }

    public String direccionEmpleador() {
        return direccionEmpleador;
    }
    public Integer lugarDepartamento()
    {
    	return lugarDepartamento;
    }
    public LocalDate fechaPresentacion()
    {
    	return fechaPresentacion;
    }
    public Long usuarioUltimaModificacion() {
    	return usuarioUltimaModificacion;
    }
    public Integer numeroSucursal() {
        return numeroSucursal;
    }
    public DatosEspecificos datosEspecificos()
    {
    	return datosEspecificos;
    }
    public String esExDependiente(){return esExDependiente;}
}
