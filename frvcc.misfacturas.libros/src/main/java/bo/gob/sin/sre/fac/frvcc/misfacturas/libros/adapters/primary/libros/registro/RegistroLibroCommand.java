package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.registro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroAdministracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCodigoAdministracion;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.time.LocalDate;

public final class RegistroLibroCommand implements Command {

    private final String id;
    private final String nombreLibro;
    private final Integer mesPeriodo;
    private final Integer anioPeriodo;
    private final String periodicidadId;
    private final String cantidadPeriodicidad;
    private final String tipoPresentacionId;
    private final Long nit;
    private final Long ifc;
    private final String razonSocial;
    private final Long codAdministracion;
    private final String administracion;
    private final Long usuarioRegistro;


    public RegistroLibroCommand(String id,
                                     String nombreLibro,
                                     Integer mesPeriodo,
                                     Integer anioPeriodo,
                                     String periodicidadId,
                                     String cantidadPeriodicidad,
                                     String tipoPresentacionId,
                                     Long nit,
                                     Integer expedicion,
                                     Long ifc,
                                     String razonSocial,Long codAdministracion,
                                     String administracion,
                                     Long usuarioRegistro) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.mesPeriodo = mesPeriodo;
        this.anioPeriodo = anioPeriodo;
        this.periodicidadId = periodicidadId;
        this.cantidadPeriodicidad = cantidadPeriodicidad;
        this.tipoPresentacionId = tipoPresentacionId;
        this.nit = nit;
        this.ifc = ifc;
        this.razonSocial = razonSocial;
        this.codAdministracion=codAdministracion;
        this.administracion=administracion;
        this.usuarioRegistro = usuarioRegistro;
    }

    private RegistroLibroCommand(Builder builder) {
        this.id = builder.id;
        this.nombreLibro = builder.nombreLibro;
        this.mesPeriodo = builder.mesPeriodo;
        this.anioPeriodo = builder.anioPeriodo;
        this.periodicidadId = builder.periodicidadId;
        this.cantidadPeriodicidad = builder.cantidadPeriodicidad;
        this.tipoPresentacionId = builder.tipoPresentacionId;
        this.nit = builder.nit;
        this.ifc = builder.ifc;
        this.razonSocial = builder.razonSocial;
        this.codAdministracion=builder.codAdministracion;
        this.administracion=builder.administracion;
        this.usuarioRegistro = builder.usuarioRegistro;
    }

    public static Builder newRegistroLibroCommand() {
        return new Builder();
    }

    public String id() {
        return id;
    }

    public String nombreLibro() {
        return nombreLibro;
    }

    public Integer mesPeriodo() {
        return mesPeriodo;
    }

    public Integer anioPeriodo() {
        return anioPeriodo;
    }


    public String periodicidadId() {
        return periodicidadId;
    }

    public String cantidadPeriodicidad() {
        return cantidadPeriodicidad;
    }

    public String tipoPresentacionId() {
        return tipoPresentacionId;
    }


    public Long nit(){
        return nit;
    }

    public Long ifc() {
        return ifc;
    }
    public String razonSocial()
    {
    	return razonSocial;
    }
    public Long usuarioRegistro() {
        return usuarioRegistro;
    }

    public  Long codAdministracion()
    {
    	return codAdministracion;
    }
    public  String administracion()
    {
    	return administracion;
    }
    
    
    public static final class Builder {
        private String id;
        private String nombreLibro;
        private Integer mesPeriodo;
        private Integer anioPeriodo;
        private LocalDate fechaPresentacion;
        private String periodicidadId;
        private String cantidadPeriodicidad;
        private String tipoPresentacionId;
        private Long nit;
        private Long ifc;
        private String razonSocial;
        private Long codAdministracion;
        private String administracion;
        private Long usuarioRegistro;

        private Builder() {
        }

        public RegistroLibroCommand build() {
            return new RegistroLibroCommand(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder nombreLibro(String nombreLibro) {
            this.nombreLibro = nombreLibro;
            return this;
        }

        public Builder mesPeriodo(Integer mesPeriodo) {
            this.mesPeriodo = mesPeriodo;
            return this;
        }

        public Builder anioPeriodo(Integer anioPeriodo) {
            this.anioPeriodo = anioPeriodo;
            return this;
        }

        public Builder fechaPresentacion(LocalDate fechaPresentacion) {
            this.fechaPresentacion = fechaPresentacion;
            return this;
        }

        public Builder periodicidadId(String periodicidadId) {
            this.periodicidadId = periodicidadId;
            return this;
        }

        public Builder cantidadPeriodicidad(String cantidadPeriodicidad) {
            this.cantidadPeriodicidad = cantidadPeriodicidad;
            return this;
        }

        public Builder tipoPresentacionId(String tipoPresentacionId) {
            this.tipoPresentacionId = tipoPresentacionId;
            return this;
        }

        public Builder nit(Long nit) {
            this.nit = nit;
            return this;
        }

        public Builder ifc(Long ifc) {
            this.ifc = ifc;
            return this;
        }

        public Builder razonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
            return this;
        }
        public Builder  codAdministracion(Long codAdministracion) {
        	this.codAdministracion=codAdministracion;
        	return this;
        }
        public  Builder  administracion(String administracion)
        {
        	this.administracion=administracion;
        	return this;
        }
        public Builder usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }
    }
}
