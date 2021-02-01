package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public final class FormularioRegistradoDomainEvent extends DomainEvent {
    private final String tipoFormularioId;
    private final Long ifc;
    private final Long nitCi;
    private final Long codigoDependiente;
    private final String razonSocial;
    private final Integer expedicionCi;
    private final Integer mesPeriodo;
    private final Integer anioPeriodo;
    private final String nombreFormulario;
    private final Integer cantidadCompras;
    private final BigDecimal totalCompras;
    private final BigDecimal determinacionPago;
    private final Integer lugarDepartamento;
    private final String tipoPresentacionId;
    private final String direccion;
    private final Long nitEmpleador;
    private final String nombreEmpleador;
    private final String direccionEmpleador;
    private final LocalDate fechaPresentacion;
    private final String periodicidadId;
    private final String cantidadPeriodicidad;
    private final Long numeroOrden;
    private final LocalDate fechaEstado;
    private final String estadoFormularioId;
    private final Integer numeroEnvio;
    private final Long usuarioRegistro;
    private final LocalDateTime fechaRegistro;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;
    private final BigDecimal totalComprasCfIpn;
    private final BigDecimal totalComprasCfOtras;
    private final BigDecimal totalComprasSdCf;
    private final List<String> comprasId;
    private final DatosEspecificos datosEspecificos;


    public FormularioRegistradoDomainEvent() {

        this.tipoFormularioId = null;
        this.ifc = null;
        this.nitCi = null;
        this.razonSocial = null;
        this.mesPeriodo = null;
        this.anioPeriodo = null;
        this.nombreFormulario = null;
        this.totalCompras = null;
        this.cantidadCompras = null;
        this.lugarDepartamento = null;
        this.tipoPresentacionId = null;
        this.direccion = null;
        this.nitEmpleador = null;
        this.nombreEmpleador = null;
        this.direccionEmpleador = null;
        this.estadoFormularioId = null;
        this.numeroEnvio = null;
        this.usuarioRegistro = null;
        this.fechaRegistro = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.estadoId = null;
        this.codigoDependiente = null;
        this.expedicionCi = null;
        this.determinacionPago = null;
        this.fechaPresentacion = null;
        this.periodicidadId = null;
        this.cantidadPeriodicidad = null;
        this.numeroOrden = null;
        this.fechaEstado = null;
        this.totalComprasCfIpn= null;
        this.totalComprasCfOtras=null;
        this.totalComprasSdCf=null;
        this.comprasId = null;
        this.datosEspecificos=null;
    }

    private FormularioRegistradoDomainEvent(Builder builder) {
        super(builder.id);
        this.tipoFormularioId = builder.tipoFormularioId;
        this.ifc = builder.ifc;
        this.nitCi = builder.nitCi;
        this.codigoDependiente = builder.codigoDependiente;
        this.razonSocial = builder.razonSocial;
        this.expedicionCi = builder.expedicionCi;
        this.mesPeriodo = builder.mesPeriodo;
        this.anioPeriodo = builder.anioPeriodo;
        this.nombreFormulario = builder.nombreFormulario;
        this.cantidadCompras = builder.cantidadCompras;
        this.totalCompras = builder.totalCompras;
        this.determinacionPago = builder.determinacionPago;
        this.lugarDepartamento = builder.lugarDepartamento;
        this.tipoPresentacionId = builder.tipoPresentacionId;
        this.direccion = builder.direccion;
        this.nitEmpleador = builder.nitEmpleador;
        this.nombreEmpleador = builder.nombreEmpleador;
        this.direccionEmpleador = builder.direccionEmpleador;
        this.fechaPresentacion = builder.fechaPresentacion;
        this.periodicidadId = builder.periodicidadId;
        this.cantidadPeriodicidad = builder.cantidadPeriodicidad;
        this.numeroOrden = builder.numeroOrden;
        this.fechaEstado = builder.fechaEstado;
        this.estadoFormularioId = builder.estadoFormularioId;
        this.numeroEnvio = builder.numeroEnvio;
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
        this.totalComprasCfIpn= builder.totalComprasCfIpn;
        this.totalComprasCfOtras=builder.totalComprasCfOtras;
        this.totalComprasSdCf=builder.totalComprasSdCf;
        this.comprasId = builder.comprasId;
        this.datosEspecificos=builder.datosEspecificos;
    }

    public FormularioRegistradoDomainEvent(String aggregateId, String eventId, String occurredOn, Builder builder) {
        super(aggregateId,eventId,occurredOn);
        this.tipoFormularioId = builder.tipoFormularioId;
        this.ifc = builder.ifc;
        this.nitCi = builder.nitCi;
        this.codigoDependiente = builder.codigoDependiente;
        this.razonSocial = builder.razonSocial;
        this.expedicionCi = builder.expedicionCi;
        this.mesPeriodo = builder.mesPeriodo;
        this.anioPeriodo = builder.anioPeriodo;
        this.nombreFormulario = builder.nombreFormulario;
        this.cantidadCompras = builder.cantidadCompras;
        this.totalCompras = builder.totalCompras;
        this.determinacionPago = builder.determinacionPago;
        this.lugarDepartamento = builder.lugarDepartamento;
        this.tipoPresentacionId = builder.tipoPresentacionId;
        this.direccion = builder.direccion;
        this.nitEmpleador = builder.nitEmpleador;
        this.nombreEmpleador = builder.nombreEmpleador;
        this.direccionEmpleador = builder.direccionEmpleador;
        this.fechaPresentacion = builder.fechaPresentacion;
        this.periodicidadId = builder.periodicidadId;
        this.cantidadPeriodicidad = builder.cantidadPeriodicidad;
        this.numeroOrden = builder.numeroOrden;
        this.fechaEstado = builder.fechaEstado;
        this.estadoFormularioId = builder.estadoFormularioId;
        this.numeroEnvio = builder.numeroEnvio;
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
        this.totalComprasCfIpn= builder.totalComprasCfIpn;
        this.totalComprasCfOtras=builder.totalComprasCfOtras;
        this.totalComprasSdCf=builder.totalComprasSdCf;
        this.comprasId = builder.comprasId;
        this.datosEspecificos=builder.datosEspecificos;

    }

    public static Builder FormularioRegistradoDomainEvent() {
        return new Builder();
    }


    @Override
    public String eventName() {
        return "formulario.registrado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("tipoFormularioId", tipoFormularioId);
            put("ifc", ifc);
            put("nitCi", nitCi);
            put("codigoDependiente", codigoDependiente);
            put("razonSocial", razonSocial);
            put("expedicionCi", expedicionCi);
            put("mesPeriodo", mesPeriodo);
            put("anioPeriodo", anioPeriodo);
            put("nombreFormulario", nombreFormulario);
            put("cantidadCompras", cantidadCompras);
            put("totalCompras", totalCompras);
            put("determinacionPago", determinacionPago);
            put("lugarDepartamento", lugarDepartamento);
            put("tipoPresentacionId", tipoPresentacionId);
            put("direccion", direccion);
            put("nitEmpleador", nitEmpleador);
            put("nombreEmpleador", nombreEmpleador);
            put("direccionEmpleador", direccionEmpleador);
            put("fechaPresentacion", Utils.localDateToString(fechaPresentacion));
            put("periodicidadId", periodicidadId);
            put("cantidadPeriodicidad", cantidadPeriodicidad);
            put("numeroOrden", numeroOrden);
            put("fechaEstado", Utils.localDateToString(fechaEstado));
            put("estadoFormularioId", estadoFormularioId);
            put("numeroEnvio", numeroEnvio);
            put("usuarioRegistro", usuarioRegistro);
            put("fechaRegistro",  Utils.localDateTimeToString(fechaRegistro));
            put("usuarioUltimaModificacion", usuarioUltimaModificacion);
            put("fechaUltimaModificacion", Utils.localDateTimeToString(fechaUltimaModificacion));
            put("estadoId", estadoId);
            put("totalComprasCfIpn", totalComprasCfIpn);
            put("totalComprasCfOtras", totalComprasCfOtras);
            put("totalComprasSdCf", totalComprasSdCf); 
            put("comprasId", comprasId.toArray());

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        Builder builder = new Builder()
                .tipoFormularioId(body.get("tipoFormularioId") != null ? (String) body.get("tipoFormularioId") : null)
                .ifc(body.get("ifc") != null ? Long.parseLong(body.get("ifc").toString()) : null)
                .nitCi(body.get("nitCi") != null ? Long.parseLong( body.get("nitCi").toString()) : null)
                .codigoDependiente(body.get("codigoDependiente") != null ? Long.parseLong( body.get("codigoDependiente").toString()) : null)
                .razonSocial(body.get("razonSocial") != null ? (String) body.get("razonSocial") : null)
                .expedicionCi(body.get("expedicionCi") != null ? (Integer) body.get("expedicionCi") : null)
                .mesPeriodo(body.get("mesPeriodo") != null ? (Integer) body.get("mesPeriodo") : null)
                .anioPeriodo(body.get("anioPeriodo") != null ? (Integer) body.get("anioPeriodo") : null)
                .nombreFormulario(body.get("nombreFormulario") != null ? (String) body.get("nombreFormulario") : null)
                .cantidadCompras(body.get("cantidadCompras") != null ? (Integer) body.get("cantidadCompras") : null)
                .totalCompras(body.get("totalCompras") != null ? new BigDecimal( body.get("totalCompras").toString()) : null)
                .determinacionPago(body.get("determinacionPago") != null ? new BigDecimal( body.get("determinacionPago").toString()) : null)
                .lugarDepartamento(body.get("lugarDepartamento") != null ? (Integer) body.get("lugarDepartamento") : null)
                .tipoPresentacionId(body.get("tipoPresentacionId") != null ? (String) body.get("tipoPresentacionId") : null)
                .direccion(body.get("direccion") != null ? (String) body.get("direccion") : null)
                .nitEmpleador(body.get("nitEmpleador") != null ? Long.parseLong( body.get("nitEmpleador").toString()) : null)
                .nombreEmpleador(body.get("nombreEmpleador") != null ? (String) body.get("nombreEmpleador") : null)
                .direccionEmpleador(body.get("direccionEmpleador") != null ? (String) body.get("direccionEmpleador") : null)
                .fechaPresentacion(body.get("fechaPresentacion") != null ? Utils.stringToLocalDate(body.get("fechaPresentacion").toString()) : null)
                .periodicidadId(body.get("periodicidadId") != null ? (String) body.get("periodicidadId") : null)
                .cantidadPeriodicidad(body.get("cantidadPeriodicidad") != null ? (String) body.get("cantidadPeriodicidad") : null)
                .numeroOrden(body.get("numeroOrden") != null ? Long.parseLong( body.get("numeroOrden").toString()) : null)
                .fechaEstado(body.get("fechaEstado") != null ? Utils.stringToLocalDate(body.get("fechaEstado").toString()) : null)
                .estadoFormularioId(body.get("estadoFormularioId") != null ? (String) body.get("estadoFormularioId") : null)
                .numeroEnvio(body.get("numeroEnvio") != null ? (Integer) body.get("numeroEnvio") : null)
                .usuarioRegistro(body.get("usuarioRegistro") != null ? Long.parseLong( body.get("usuarioRegistro").toString()) : null)
                .fechaRegistro(body.get("fechaRegistro") != null ? Utils.stringToLocalDateTime(body.get("fechaRegistro").toString()) : null)
                .usuarioUltimaModificacion(body.get("usuarioUltimaModificacion") != null ? Long.parseLong( body.get("usuarioUltimaModificacion").toString()) : null)
                .fechaUltimaModificacion(body.get("fechaUltimaModificacion") != null ? Utils.stringToLocalDateTime( body.get("fechaUltimaModificacion").toString()) : null)
                .estadoId(body.get("estadoId") != null ? (String) body.get("estadoId") : null)
                .comprasId(body.get("comprasId") != null ? (List<String>) body.get("comprasId") : null);
        return new FormularioRegistradoDomainEvent(aggregateId, eventId, occurredOn, builder);



    }


    public String getTipoFormularioId() {
        return tipoFormularioId;
    }

    public Long getIfc() {
        return ifc;
    }

    public Long getNitCi() {
        return nitCi;
    }

    public Long getCodigoDependiente() {
        return codigoDependiente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Integer getExpedicionCi() {
        return expedicionCi;
    }

    public Integer getMesPeriodo() {
        return mesPeriodo;
    }

    public Integer getAnioPeriodo() {
        return anioPeriodo;
    }

    public String getNombreFormulario() {
        return nombreFormulario;
    }

    public Integer getCantidadCompras() {
        return cantidadCompras;
    }

    public BigDecimal getTotalCompras() {
        return totalCompras;
    }

    public BigDecimal getDeterminacionPago() {
        return determinacionPago;
    }

    public Integer getLugarDepartamento() {
        return lugarDepartamento;
    }

    public String getTipoPresentacionId() {
        return tipoPresentacionId;
    }

    public String getDireccion() {
        return direccion;
    }

    public Long getnitEmpleador() {
        return nitEmpleador;
    }

    public String getNombreEmpleador() {
        return nombreEmpleador;
    }

    public String getDireccionEmpleador() {
        return direccionEmpleador;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public String getPeriodicidadId() {
        return periodicidadId;
    }

    public String getCantidadPeriodicidad() {
        return cantidadPeriodicidad;
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public LocalDate getFechaEstado() {
        return fechaEstado;
    }

    public String getEstadoFormularioId() {
        return estadoFormularioId;
    }

    public Integer getNumeroEnvio() {
        return numeroEnvio;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public BigDecimal getTotalComprasCfIpn() {
		return totalComprasCfIpn;
	}

	public BigDecimal getTotalComprasCfOtras() {
		return totalComprasCfOtras;
	}

	public BigDecimal getTotalComprasSdCf() {
		return totalComprasSdCf;
	}

	public String getEstadoId() {
        return estadoId;
    }

    public List<String> getComprasId() {
        return comprasId;
    }
    
    public DatosEspecificos getDatosEspecificos() {
		return datosEspecificos;
	}

	public static final class Builder {
        private String id;
        private String tipoFormularioId;
        private Long ifc;
        private Long nitCi;
        private Long codigoDependiente;
        private String razonSocial;
        private Integer expedicionCi;
        private Integer mesPeriodo;
        private Integer anioPeriodo;
        private String nombreFormulario;
        private Integer cantidadCompras;
        private BigDecimal totalCompras;
        private BigDecimal determinacionPago;
        private Integer lugarDepartamento;
        private String tipoPresentacionId;
        private String direccion;
        private Long nitEmpleador;
        private String nombreEmpleador;
        private String direccionEmpleador;
        private LocalDate fechaPresentacion;
        private String periodicidadId;
        private String cantidadPeriodicidad;
        private Long numeroOrden;
        private LocalDate fechaEstado;
        private String estadoFormularioId;
        private Integer numeroEnvio;
        private Long usuarioRegistro;
        private LocalDateTime fechaRegistro;
        private Long usuarioUltimaModificacion;
        private LocalDateTime fechaUltimaModificacion;
        private String estadoId;
        private BigDecimal totalComprasCfIpn;
        private BigDecimal totalComprasCfOtras;
        private BigDecimal totalComprasSdCf;
        private List<String> comprasId;
        private DatosEspecificos datosEspecificos;

        private Builder() {
        }

        public FormularioRegistradoDomainEvent build() {
            return new FormularioRegistradoDomainEvent(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder tipoFormularioId(String tipoFormularioId) {
            this.tipoFormularioId = tipoFormularioId;
            return this;
        }

        public Builder ifc(Long ifc) {
            this.ifc = ifc;
            return this;
        }

        public Builder nitCi(Long nitCi) {
            this.nitCi = nitCi;
            return this;
        }

        public Builder codigoDependiente(Long codigoDependiente) {
            this.codigoDependiente = codigoDependiente;
            return this;
        }

        public Builder razonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
            return this;
        }

        public Builder expedicionCi(Integer expedicionCi) {
            this.expedicionCi = expedicionCi;
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

        public Builder nombreFormulario(String nombreFormulario) {
            this.nombreFormulario = nombreFormulario;
            return this;
        }

        public Builder cantidadCompras(Integer cantidadCompras) {
            this.cantidadCompras = cantidadCompras;
            return this;
        }

        public Builder totalCompras(BigDecimal totalCompras) {
            this.totalCompras = totalCompras;
            return this;
        }

        public Builder determinacionPago(BigDecimal determinacionPago) {
            this.determinacionPago = determinacionPago;
            return this;
        }

        public Builder lugarDepartamento(Integer lugarDepartamento) {
            this.lugarDepartamento = lugarDepartamento;
            return this;
        }

        public Builder tipoPresentacionId(String tipoPresentacionId) {
            this.tipoPresentacionId = tipoPresentacionId;
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
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

        public Builder numeroOrden(Long numeroOrden) {
            this.numeroOrden = numeroOrden;
            return this;
        }

        public Builder fechaEstado(LocalDate fechaEstado) {
            this.fechaEstado = fechaEstado;
            return this;
        }

        public Builder estadoFormularioId(String estadoFormularioId) {
            this.estadoFormularioId = estadoFormularioId;
            return this;
        }

        public Builder numeroEnvio(Integer numeroEnvio) {
            this.numeroEnvio = numeroEnvio;
            return this;
        }

        public Builder usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }

        public Builder fechaRegistro(LocalDateTime fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Builder usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            return this;
        }

        public Builder fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
            this.fechaUltimaModificacion = fechaUltimaModificacion;
            return this;
        }

        public Builder estadoId(String estadoId) {
            this.estadoId = estadoId;
            return this;
        }
        
        
        public Builder totalComprasCfIpn(BigDecimal totalComprasCfIpn) {
            this.totalComprasCfIpn = totalComprasCfIpn;
            return this;
        }
        
        public Builder totalComprasCfOtras(BigDecimal totalComprasCfOtras) {
            this.totalComprasCfOtras = totalComprasCfOtras;
            return this;
        }
        public Builder totalComprasSdCf(BigDecimal totalComprasSdCf) {
            this.totalComprasSdCf = totalComprasSdCf;
            return this;
        }

        public Builder comprasId(List<String> comprasId) {
            this.comprasId = comprasId;
            return this;
        }
        public Builder datosEspecificos(DatosEspecificos datosespecificos)
        {
        	this.datosEspecificos=datosespecificos;
        	return this;
        }
    }
}
