package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.time.LocalDate;

public final class RegistroFormularioCommand implements Command {

    private final String id;

    private final String tipoFormularioId;
    private final String nombreFormulario;
    private final Integer mesPeriodo;
    private final Integer anioPeriodo;
    private final LocalDate fechaPresentacion;
    private final String periodicidadId;
    private final String cantidadPeriodicidad;
    private final String tipoPresentacionId;
    private final Integer lugarDepartamento;
    private final Long nitCi;
    private final Integer expedicionCi;
    private final Long ifc;
    private final String razonSocial;
    private final String direccion;
    private final Long codigoDependiente;
    private final Long nitEmpleador;
    private final String nombreEmpleador;
    private final String direccionEmpleador;
    private final Long usuarioRegistro;
    private final Integer numeroSucursal;
    private final DatosEspecificos datosEspecificos;
    private final String tipoUsoId;


    public RegistroFormularioCommand(String id,
                                     String tipoFormularioId,
                                     String nombreFormulario,
                                     Integer mesPeriodo,
                                     Integer anioPeriodo,
                                     LocalDate fechaPresentacion,
                                     String periodicidadId,
                                     String cantidadPeriodicidad,
                                     String tipoPresentacionId,
                                     Integer lugarDepartamento,
                                     Long nitCi,
                                     Integer expedicionCi,
                                     Long ifc,
                                     String razonSocial,
                                     String direccion,
                                     Long codigoDependiente,
                                     Long nitEmpleador,
                                     String nombreEmpleador,
                                     String direccionEmpleador,
                                     Long usuarioRegistro,
                                     Integer numeroSucursal,
                                     DatosEspecificos datosEspecificos, String tipoUsoId) {
        this.id = id;
        this.tipoFormularioId = tipoFormularioId;
        this.nombreFormulario = nombreFormulario;
        this.mesPeriodo = mesPeriodo;
        this.anioPeriodo = anioPeriodo;
        this.fechaPresentacion = fechaPresentacion;
        this.periodicidadId = periodicidadId;
        this.cantidadPeriodicidad = cantidadPeriodicidad;
        this.tipoPresentacionId = tipoPresentacionId;
        this.lugarDepartamento = lugarDepartamento;
        this.nitCi = nitCi;
        this.expedicionCi = expedicionCi;
        this.ifc = ifc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.codigoDependiente = codigoDependiente;
        this.nitEmpleador = nitEmpleador;
        this.nombreEmpleador = nombreEmpleador;
        this.direccionEmpleador = direccionEmpleador;
        this.usuarioRegistro = usuarioRegistro;
        this.numeroSucursal=numeroSucursal;
        this.datosEspecificos=datosEspecificos;
        this.tipoUsoId = tipoUsoId;
    }

    private RegistroFormularioCommand(Builder builder) {
        this.id = builder.id;
        this.tipoFormularioId = builder.tipoFormularioId;
        this.nombreFormulario = builder.nombreFormulario;
        this.mesPeriodo = builder.mesPeriodo;
        this.anioPeriodo = builder.anioPeriodo;
        this.fechaPresentacion = builder.fechaPresentacion;
        this.periodicidadId = builder.periodicidadId;
        this.cantidadPeriodicidad = builder.cantidadPeriodicidad;
        this.tipoPresentacionId = builder.tipoPresentacionId;
        this.lugarDepartamento = builder.lugarDepartamento;
        this.nitCi = builder.nitCi;
        this.expedicionCi = builder.expedicionCi;
        this.ifc = builder.ifc;
        this.razonSocial = builder.razonSocial;
        this.direccion = builder.direccion;
        this.codigoDependiente = builder.codigoDependiente;
        this.nitEmpleador = builder.nitEmpleador;
        this.nombreEmpleador = builder.nombreEmpleador;
        this.direccionEmpleador = builder.direccionEmpleador;
        this.usuarioRegistro = builder.usuarioRegistro;
        this.numeroSucursal=builder.numeroSucursal;
		this.datosEspecificos = builder.datosEspecificos;
		this.tipoUsoId =builder.tipoUsoId;
    }

    public static Builder newRegistroFormularioCommand() {
        return new Builder();
    }

    public String id() {
        return id;
    }

    public String tipoFormularioId() {
        return tipoFormularioId;
    }

    public String nombreFormulario() {
        return nombreFormulario;
    }

    public Integer mesPeriodo() {
        return mesPeriodo;
    }

    public Integer anioPeriodo() {
        return anioPeriodo;
    }

    public LocalDate fechaPresentacion() {
        return fechaPresentacion;
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

    public Integer lugarDepartamento() {
        return lugarDepartamento;
    }

    public Long nitCi() {
        return nitCi;
    }

    public Integer expedicionCi() {
        return expedicionCi;
    }

    public Long ifc() {
        return ifc;
    }

    public String razonSocial() {
        return razonSocial;
    }

    public String direccion() {
        return direccion;
    }

    public Long codigoDependiente() {
        return codigoDependiente;
    }

    public Long nitEmpleador() {
        return nitEmpleador;
    }

    public String direccionEmpleador() {
        return direccionEmpleador;
    }

    public String nombreEmpleador() {
        return nombreEmpleador;
    }

    public Long usuarioRegistro() {
        return usuarioRegistro;
    }
    public Integer numeroSucursal() {
        return numeroSucursal;
    }
    public DatosEspecificos datosEspecificos() {
    	return datosEspecificos;
    }
    public String tipoUsoId(){return tipoUsoId;}


    public static final class Builder {
        private String id;
        private String tipoFormularioId;
        private String nombreFormulario;
        private Integer mesPeriodo;
        private Integer anioPeriodo;
        private LocalDate fechaPresentacion;
        private String periodicidadId;
        private String cantidadPeriodicidad;
        private String tipoPresentacionId;
        private Integer lugarDepartamento;
        private Long nitCi;
        private Integer expedicionCi;
        private Long ifc;
        private String razonSocial;
        private String direccion;
        private Long codigoDependiente;
        private Long nitEmpleador;
        private String nombreEmpleador;
        private String direccionEmpleador;
        private Long usuarioRegistro;
        private Integer numeroSucursal;
        private DatosEspecificos datosEspecificos;
        private String tipoUsoId;
        private Builder() {
        }

        public RegistroFormularioCommand build() {
            return new RegistroFormularioCommand(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder tipoFormularioId(String tipoFormularioId) {
            this.tipoFormularioId = tipoFormularioId;
            return this;
        }

        public Builder nombreFormulario(String nombreFormulario) {
            this.nombreFormulario = nombreFormulario;
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

        public Builder lugarDepartamento(Integer lugarDepartamento) {
            this.lugarDepartamento = lugarDepartamento;
            return this;
        }

        public Builder nitCi(Long nitCi) {
            this.nitCi = nitCi;
            return this;
        }

        public Builder expedicionCi(Integer expedicionCi) {
            this.expedicionCi = expedicionCi;
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

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder codigoDependiente(Long codigoDependiente) {
            this.codigoDependiente = codigoDependiente;
            return this;
        }

        public Builder nitEmpleador(Long nitEmpleador) {
            this.nitEmpleador = nitEmpleador;
            return this;
        }

        public Builder nombreEmpleador(String nombreEmpleador) {
            this.nombreEmpleador = nombreEmpleador;
            return this;
        }

        public Builder direccionEmpleador(String direccionEmpleador) {
            this.direccionEmpleador = direccionEmpleador;
            return this;
        }

        public Builder usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }
        public Builder numeroSucursal(Integer numeroSucursal) {
            this.numeroSucursal = numeroSucursal;
            return this;
        }
        public Builder datosEspecificos(DatosEspecificos datosEspecificos) {
            this.datosEspecificos = datosEspecificos;
            return this;
        }
        public Builder tipoUsoId(String tipoUsoId)
        {
            this.tipoUsoId =tipoUsoId;
            return this;
        }
    }
}
