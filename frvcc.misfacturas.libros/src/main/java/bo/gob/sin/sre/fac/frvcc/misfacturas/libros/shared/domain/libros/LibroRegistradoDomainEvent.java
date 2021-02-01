package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.shared.domain.libros;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroAdministracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadComprasCfElec;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadComprasCfIpn;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadComprasCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadComprasSdCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadVentasCfElec;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadVentasCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadVentasSdCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadVentasSdCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCantidadVentasSdCfSrg;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroCodigoAdministracion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroDeterminacionPago;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroDeterminacionPagoCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroDeterminacionPagoCfIpn;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroDeterminacionPagoCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroDeterminacionPagoSdCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroImporteBaseComprasCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroImporteBaseComprasCfElec;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroImporteBaseComprasCfIpn;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroImporteBaseComprasCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalComprasCfElec;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalComprasCfIpn;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalComprasCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalComprasSdCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalVentasCfElec;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalVentasCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalVentasSdCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalVentasSdCfOtras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroTotalVentasSdCfSrg;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public final class LibroRegistradoDomainEvent extends DomainEvent {
//	private final String id;
    private final Long nit;
    private final Long ifc;
    private final String razonSocial;
    private final Long codAdministracion;
	private final String administracion;
    private final Integer mesPeriodo;
    private final Integer anioPeriodo;
    private final String nombreLibro;
    private final Integer cantidadCompras;
    private final BigDecimal totalCompras;
    
    private final Integer cantidadComprasCfElec;
	private final Integer cantidadComprasCfIpn;
	private final Integer cantidadComprasCfOtras;
	private final Integer cantidadComprasSdCf;
	private final BigDecimal totalComprasCfElec;
	private final BigDecimal totalComprasCfIpn;
	private final BigDecimal totalComprasCfOtras;
	private final BigDecimal totalComprasSdCf;
	private final BigDecimal importeBaseCf;
	private final BigDecimal importeBaseCfElec;
	private final BigDecimal importeBaseCfIpn;
	private final BigDecimal importeBaseCfOtras;
	private final BigDecimal determinacionPagoCf;
	private final BigDecimal determinacionPagoCfIpn;
	private final BigDecimal determinacionPagoCfOtras;
	private final BigDecimal determinacionPagoSdCf;
	private final BigDecimal determinacionPago;
    
    private final Integer cantidadComprasNotas;
    private final BigDecimal totalComprasNotas;
    private final Integer cantidadVentas;
    private final BigDecimal totalVentas;
    
    private final Integer  cantidadVentasCfElec;
	private final Integer  cantidadVentasCfOtras;
	private final BigDecimal totalVentasCfElec;
	private final BigDecimal totalVentasCfOtras;
	private final Integer cantidadVentasSdCf;
	private final Integer cantidadVentasSdCfOtras;
	private final Integer cantidadVentasSdCfSrg;
	private final BigDecimal totalVentasSdCf;
	private final BigDecimal totalVentasSdCfOtras;
	private final BigDecimal totalVentasSdCfSrg;
    
    private final Integer cantidadVentasNotas;
    private final BigDecimal totalVentasNotas;
    private final String  tipoPresentacionId;
    private final LocalDateTime fechaPresentacion;
    private final String periodicidadId;
    private final String cantidadPeriodicidad;
    private final Long numeroOrden;
    private final String estadoLibroId;
    private final LocalDate fechaEstado;
    private final Integer numeroEnvio;
    private final String libroRectificadoId;
    private final String conMovimiento;
    private final Long usuarioRegistro;
    private final LocalDateTime fechaRegistro;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;
    private final List<String> comprasId;
    private final List<String> comprasNotasId;


    public LibroRegistradoDomainEvent() {

        this.ifc = null;
        this.nit= null;
        this.razonSocial = null;
        this.codAdministracion=null;
        this.administracion=null;
        this.mesPeriodo = null;
        this.anioPeriodo = null;
        this.nombreLibro = null;
        this.totalCompras = null;
        this.cantidadCompras = null;
        this.cantidadComprasCfElec=null;
    	this.cantidadComprasCfIpn=null;
    	this.cantidadComprasCfOtras=null;
    	this.cantidadComprasSdCf=null;
    	this.totalComprasCfElec=null;
    	this.totalComprasCfIpn=null;
    	this.totalComprasCfOtras=null;
    	this.totalComprasSdCf=null;
    	this.importeBaseCf=null;
    	this.importeBaseCfElec=null;
    	this.importeBaseCfIpn=null;
    	this.importeBaseCfOtras=null;
    	this.determinacionPagoCf=null;
    	this.determinacionPagoCfIpn=null;
    	this.determinacionPagoCfOtras=null;
    	this.determinacionPagoSdCf=null;
    	this.determinacionPago=null;
        this.totalVentas = null;
        this.cantidadVentas = null;
        this.cantidadVentasCfElec = null;
    	this.cantidadVentasCfOtras = null;
    	this.totalVentasCfElec = null;
    	this.totalVentasCfOtras = null;
    	this.cantidadVentasSdCf = null;
    	this.cantidadVentasSdCfOtras = null;
    	this.cantidadVentasSdCfSrg = null;
    	this.totalVentasSdCf = null;
    	this.totalVentasSdCfOtras = null;
    	this.totalVentasSdCfSrg = null;
        this.totalComprasNotas = null;
        this.cantidadComprasNotas = null;
        this.totalVentasNotas = null;
        this.cantidadVentasNotas = null;
        this.tipoPresentacionId = null;
		this.estadoLibroId = "";
        this.numeroEnvio = null;
        this.usuarioRegistro = null;
        this.fechaRegistro = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.estadoId = null;
        this.fechaPresentacion = null;
        this.periodicidadId = null;
        this.cantidadPeriodicidad = null;
        this.libroRectificadoId=null;
        this.conMovimiento=null;
        this.numeroOrden = null;
        this.fechaEstado = null;
        this.comprasId = null;
        this.comprasNotasId=null;
    }

    private LibroRegistradoDomainEvent(Builder builder) {
        super(builder.id);
        this.nit=builder.nit;
        this.ifc=builder.ifc;
        this.razonSocial=builder.razonSocial;
        this.codAdministracion=builder.codAdministracion;
    	this.administracion=builder.administracion;
        this.mesPeriodo=builder.mesPeriodo;
        this.anioPeriodo=builder.anioPeriodo;
        this.nombreLibro=builder.nombreLibro;
        this.cantidadCompras=builder.cantidadCompras;
        this.totalCompras=builder.totalCompras;
        this.cantidadComprasCfElec=builder.cantidadComprasCfElec;
    	this.cantidadComprasCfIpn=builder.cantidadComprasCfIpn;
    	this.cantidadComprasCfOtras=builder.cantidadComprasCfOtras;
    	this.cantidadComprasSdCf=builder.cantidadComprasSdCf;
    	this.totalComprasCfElec=builder.totalComprasCfElec;
    	this.totalComprasCfIpn=builder.totalComprasCfIpn;
    	this.totalComprasCfOtras=builder.totalComprasCfOtras;
    	this.totalComprasSdCf=builder.totalComprasSdCf;
    	this.importeBaseCf=builder.importeBaseCf;
    	this.importeBaseCfElec=builder.importeBaseCfElec;
    	this.importeBaseCfIpn=builder.importeBaseCfIpn;
    	this.importeBaseCfOtras=builder.importeBaseCfOtras;
    	this.determinacionPagoCf=builder.determinacionPagoCf;
    	this.determinacionPagoCfIpn=builder.determinacionPagoCfIpn;
    	this.determinacionPagoCfOtras=builder.determinacionPagoCfOtras;
    	this.determinacionPagoSdCf=builder.determinacionPagoSdCf;
    	this.determinacionPago=builder.determinacionPago;
        this.cantidadComprasNotas=builder.cantidadComprasNotas;
        this.totalComprasNotas=builder.totalComprasNotas;
        this.cantidadVentas=builder.cantidadVentas;
        this.totalVentas=builder.totalVentas;
        this.cantidadVentasCfElec=builder.cantidadVentasCfElec;
    	this.cantidadVentasCfOtras=builder.cantidadVentasCfOtras;
    	this.totalVentasCfElec=builder.totalVentasCfElec;
    	this.totalVentasCfOtras=builder.totalVentasCfOtras;
    	this.cantidadVentasSdCf=builder.cantidadVentasSdCf;
    	this.cantidadVentasSdCfOtras=builder.cantidadVentasSdCfOtras;
    	this.cantidadVentasSdCfSrg=builder.cantidadVentasSdCfSrg;
    	this.totalVentasSdCf=builder.totalVentasSdCf;
    	this.totalVentasSdCfOtras=builder.totalVentasSdCfOtras;
    	this.totalVentasSdCfSrg=builder.totalVentasSdCfSrg;
        this.cantidadVentasNotas=builder.cantidadVentasNotas;
        this.totalVentasNotas=builder.totalVentasNotas;
        this.tipoPresentacionId=builder.tipoPresentacionId;
        this.fechaPresentacion=builder.fechaPresentacion;
        this.periodicidadId=builder.periodicidadId;
        this.cantidadPeriodicidad=builder.cantidadPeriodicidad;
        this.numeroOrden=builder.numeroOrden;
        this.estadoLibroId=builder.estadoLibroId;
        this.fechaEstado=builder.fechaEstado;
        this.numeroEnvio=builder.numeroEnvio;
        this.libroRectificadoId=builder.libroRectificadoId;
        this.conMovimiento=builder.conMovimiento;
        this.usuarioRegistro=builder.usuarioRegistro;
        this.fechaRegistro=builder.fechaRegistro;
        this.usuarioUltimaModificacion=builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion=builder.fechaUltimaModificacion;
        this.estadoId=builder.estadoId;
        this.comprasId=builder.comprasId;
        this.comprasNotasId=builder.comprasNotasId;
    }

    public LibroRegistradoDomainEvent(String aggregateId, String eventId, String occurredOn, Builder builder) {
        super(aggregateId,eventId,occurredOn);
        this.nit=builder.nit;
        this.ifc=builder.ifc;
        this.razonSocial=builder.razonSocial;
        this.codAdministracion=builder.codAdministracion;
    	this.administracion=builder.administracion;
        this.mesPeriodo=builder.mesPeriodo;
        this.anioPeriodo=builder.anioPeriodo;
        this.nombreLibro=builder.nombreLibro;
        this.cantidadCompras=builder.cantidadCompras;
        this.totalCompras=builder.totalCompras;
        this.cantidadComprasCfElec=builder.cantidadComprasCfElec;
    	this.cantidadComprasCfIpn=builder.cantidadComprasCfIpn;
    	this.cantidadComprasCfOtras=builder.cantidadComprasCfOtras;
    	this.cantidadComprasSdCf=builder.cantidadComprasSdCf;
    	this.totalComprasCfElec=builder.totalComprasCfElec;
    	this.totalComprasCfIpn=builder.totalComprasCfIpn;
    	this.totalComprasCfOtras=builder.totalComprasCfOtras;
    	this.totalComprasSdCf=builder.totalComprasSdCf;
    	this.importeBaseCf=builder.importeBaseCf;
    	this.importeBaseCfElec=builder.importeBaseCfElec;
    	this.importeBaseCfIpn=builder.importeBaseCfIpn;
    	this.importeBaseCfOtras=builder.importeBaseCfOtras;
    	this.determinacionPagoCf=builder.determinacionPagoCf;
    	this.determinacionPagoCfIpn=builder.determinacionPagoCfIpn;
    	this.determinacionPagoCfOtras=builder.determinacionPagoCfOtras;
    	this.determinacionPagoSdCf=builder.determinacionPagoSdCf;
    	this.determinacionPago=builder.determinacionPago;
        this.cantidadComprasNotas=builder.cantidadComprasNotas;
        this.totalComprasNotas=builder.totalComprasNotas;
        this.cantidadVentas=builder.cantidadVentas;
        this.totalVentas=builder.totalVentas;
        this.cantidadVentasCfElec=builder.cantidadVentasCfElec;
    	this.cantidadVentasCfOtras=builder.cantidadVentasCfOtras;
    	this.totalVentasCfElec=builder.totalVentasCfElec;
    	this.totalVentasCfOtras=builder.totalVentasCfOtras;
    	this.cantidadVentasSdCf=builder.cantidadVentasSdCf;
    	this.cantidadVentasSdCfOtras=builder.cantidadVentasSdCfOtras;
    	this.cantidadVentasSdCfSrg=builder.cantidadVentasSdCfSrg;
    	this.totalVentasSdCf=builder.totalVentasSdCf;
    	this.totalVentasSdCfOtras=builder.totalVentasSdCfOtras;
    	this.totalVentasSdCfSrg=builder.totalVentasSdCfSrg;
        this.cantidadVentasNotas=builder.cantidadVentasNotas;
        this.totalVentasNotas=builder.totalVentasNotas;
        this.tipoPresentacionId=builder.tipoPresentacionId;
        this.fechaPresentacion=builder.fechaPresentacion;
        this.periodicidadId=builder.periodicidadId;
        this.cantidadPeriodicidad=builder.cantidadPeriodicidad;
        this.numeroOrden=builder.numeroOrden;
        this.estadoLibroId=builder.estadoLibroId;
        this.fechaEstado=builder.fechaEstado;
        this.numeroEnvio=builder.numeroEnvio;
        this.libroRectificadoId=builder.libroRectificadoId;
        this.conMovimiento=builder.conMovimiento;
        this.usuarioRegistro=builder.usuarioRegistro;
        this.fechaRegistro=builder.fechaRegistro;
        this.usuarioUltimaModificacion=builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion=builder.fechaUltimaModificacion;
        this.estadoId=builder.estadoId;
        this.comprasId=builder.comprasId;
        this.comprasNotasId=builder.comprasNotasId;

    }

    public static Builder LibroRegistradoDomainEvent() {
        return new Builder();
    }


    @Override
    public String eventName() {
        return "libro.registrado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("ifc", ifc);
            put("nit", nit);
            put("razonSocial", razonSocial);
            put("mesPeriodo", mesPeriodo);
            put("anioPeriodo", anioPeriodo);
            put("nombreLibro", nombreLibro);
            put("cantidadCompras", cantidadCompras);
            put("totalCompras", totalCompras);
            put("totalComprasNotas", totalComprasNotas);
            put("cantidadComprasNotas", cantidadComprasNotas);
            put("cantidadVentas", cantidadVentas);
            put("totalVentas", totalVentas);
            put("cantidadVentasNotas", cantidadVentasNotas);
            put("totalVentasNotas", totalVentasNotas);
            put("tipoPresentacionId", tipoPresentacionId);
            put("fechaPresentacion", Utils.localDateTimeToString(fechaPresentacion));
            put("periodicidadId", periodicidadId);
            put("cantidadPeriodicidad", cantidadPeriodicidad);
            put("numeroOrden", numeroOrden);
            put("fechaEstado", Utils.localDateToString(fechaEstado));
            put("estadoLibroId", estadoLibroId);
            put("numeroEnvio", numeroEnvio);
            put("libroRectificadoId", libroRectificadoId);
            put("conMovimiento", conMovimiento);
            put("usuarioRegistro", usuarioRegistro);
            put("fechaRegistro",  Utils.localDateTimeToString(fechaRegistro));
            put("usuarioUltimaModificacion", usuarioUltimaModificacion);
            put("fechaUltimaModificacion", Utils.localDateTimeToString(fechaUltimaModificacion));
            put("estadoId", estadoId);
            put("comprasId", comprasId.toArray());
            put("comprasNotasId", comprasNotasId.toArray());

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        Builder builder = new Builder()
                .ifc(body.get("ifc") != null ? Long.parseLong(body.get("ifc").toString()) : null)
                .nit(body.get("nit") != null ? Long.parseLong( body.get("nit").toString()) : null)
                .razonSocial(body.get("razonSocial") != null ? (String) body.get("razonSocial") : null)
                .mesPeriodo(body.get("mesPeriodo") != null ? (Integer) body.get("mesPeriodo") : null)
                .anioPeriodo(body.get("anioPeriodo") != null ? (Integer) body.get("anioPeriodo") : null)
                .nombreLibro(body.get("nombreLibro") != null ? (String) body.get("nombreLibro") : null)
                .cantidadCompras(body.get("cantidadCompras") != null ? (Integer) body.get("cantidadCompras") : null)
                .totalCompras(body.get("totalCompras") != null ? new BigDecimal( body.get("totalCompras").toString()) : null)
                .cantidadComprasNotas(body.get("cantidadComprasNotas") != null ? (Integer) body.get("cantidadComprasNotas") : null)
                .totalComprasNotas(body.get("totalComprasNotas") != null ? new BigDecimal( body.get("totalComprasNotas").toString()) : null)
                .cantidadVentas(body.get("cantidadVentas") != null ? (Integer) body.get("cantidadVentas") : null)
                .totalVentas(body.get("totalVentas") != null ? new BigDecimal( body.get("totalVentas").toString()) : null)
                .cantidadVentasNotas(body.get("cantidadVentasNotas") != null ? (Integer) body.get("cantidadVentasNotas") : null)
                .totalVentasNotas(body.get("totalVentasNotas") != null ? new BigDecimal( body.get("totalVentasNotas").toString()) : null)
                .tipoPresentacionId(body.get("tipoPresentacionId") != null ? (String) body.get("tipoPresentacionId") : null)
                .fechaPresentacion(body.get("fechaPresentacion") != null ? Utils.stringToLocalDateTime(body.get("fechaPresentacion").toString()) : null)
                .periodicidadId(body.get("periodicidadId") != null ? (String) body.get("periodicidadId") : null)
                .cantidadPeriodicidad(body.get("cantidadPeriodicidad") != null ? (String) body.get("cantidadPeriodicidad") : null)
                .numeroOrden(body.get("numeroOrden") != null ? Long.parseLong( body.get("numeroOrden").toString()) : null)
                .fechaEstado(body.get("fechaEstado") != null ? Utils.stringToLocalDate(body.get("fechaEstado").toString()) : null)
                .estadoLibroId(body.get("estadoLibroId") != null ? (String) body.get("estadoLibroId") : null)
                .numeroEnvio(body.get("numeroEnvio") != null ? (Integer) body.get("numeroEnvio") : null)
                .libroRectificadoId(body.get("libroRectificadoId") != null ? (String) body.get("libroRectificadoId") : null)
                .conMovimiento(body.get("conMovimiento") != null ? (String) body.get("conMovimiento") : null)
                .usuarioRegistro(body.get("usuarioRegistro") != null ? Long.parseLong( body.get("usuarioRegistro").toString()) : null)
                .fechaRegistro(body.get("fechaRegistro") != null ? Utils.stringToLocalDateTime(body.get("fechaRegistro").toString()) : null)
                .usuarioUltimaModificacion(body.get("usuarioUltimaModificacion") != null ? Long.parseLong( body.get("usuarioUltimaModificacion").toString()) : null)
                .fechaUltimaModificacion(body.get("fechaUltimaModificacion") != null ? Utils.stringToLocalDateTime( body.get("fechaUltimaModificacion").toString()) : null)
                .estadoId(body.get("estadoId") != null ? (String) body.get("estadoId") : null)
                .comprasId(body.get("comprasId") != null ? (List<String>) body.get("comprasId") : null)
                .comprasNotasId(body.get("comprasNotasId") != null ? (List<String>) body.get("comprasNotasId") : null);
        return new LibroRegistradoDomainEvent(aggregateId, eventId, occurredOn, builder);



    }


    
    public Long getNit() {
		return nit;
	}

	public Long getIfc() {
		return ifc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public Integer getMesPeriodo() {
		return mesPeriodo;
	}

	public Integer getAnioPeriodo() {
		return anioPeriodo;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public Integer getCantidadCompras() {
		return cantidadCompras;
	}

	public BigDecimal getTotalCompras() {
		return totalCompras;
	}

	public Integer getCantidadVentas() {
		return cantidadVentas;
	}

	public BigDecimal getTotalVentas() {
		return totalVentas;
	}

	public String getTipoPresentacionId() {
		return tipoPresentacionId;
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

	public String getEstadoLibroId() {
		return estadoLibroId;
	}

	public LocalDate getFechaEstado() {
		return fechaEstado;
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

	public String getEstadoId() {
		return estadoId;
	}

	public List<String> getComprasId() {
		return comprasId;
	}
	


	public Integer getCantidadComprasNotas() {
		return cantidadComprasNotas;
	}

	public BigDecimal getTotalComprasNotas() {
		return totalComprasNotas;
	}

	public Integer getCantidadVentasNotas() {
		return cantidadVentasNotas;
	}

	public BigDecimal getTotalVentasNotas() {
		return totalVentasNotas;
	}

	public String getLibroRectificadoId() {
		return libroRectificadoId;
	}

	public String getConMovimiento() {
		return conMovimiento;
	}

	public List<String> getComprasNotasId() {
		return comprasNotasId;
	}
	public Long getCodAdministracion() {
		return codAdministracion;
	}

	public String getAdministracion() {
		return administracion;
	}

	public Integer getCantidadComprasCfElec() {
		return cantidadComprasCfElec;
	}

	public Integer getCantidadComprasCfIpn() {
		return cantidadComprasCfIpn;
	}

	public Integer getCantidadComprasCfOtras() {
		return cantidadComprasCfOtras;
	}

	public Integer getCantidadComprasSdCf() {
		return cantidadComprasSdCf;
	}

	public BigDecimal getTotalComprasCfElec() {
		return totalComprasCfElec;
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

	public BigDecimal getImporteBaseCf() {
		return importeBaseCf;
	}

	public BigDecimal getImporteBaseCfElec() {
		return importeBaseCfElec;
	}

	public BigDecimal getImporteBaseCfIpn() {
		return importeBaseCfIpn;
	}

	public BigDecimal getImporteBaseCfOtras() {
		return importeBaseCfOtras;
	}

	public BigDecimal getDeterminacionPagoCf() {
		return determinacionPagoCf;
	}

	public BigDecimal getDeterminacionPagoCfIpn() {
		return determinacionPagoCfIpn;
	}

	public BigDecimal getDeterminacionPagoCfOtras() {
		return determinacionPagoCfOtras;
	}

	public BigDecimal getDeterminacionPagoSdCf() {
		return determinacionPagoSdCf;
	}

	public BigDecimal getDeterminacionPago() {
		return determinacionPago;
	}

	public Integer getCantidadVentasCfElec() {
		return cantidadVentasCfElec;
	}

	public Integer getCantidadVentasCfOtras() {
		return cantidadVentasCfOtras;
	}

	public BigDecimal getTotalVentasCfElec() {
		return totalVentasCfElec;
	}

	public BigDecimal getTotalVentasCfOtras() {
		return totalVentasCfOtras;
	}

	public Integer getCantidadVentasSdCf() {
		return cantidadVentasSdCf;
	}

	public Integer getCantidadVentasSdCfOtras() {
		return cantidadVentasSdCfOtras;
	}

	public Integer getCantidadVentasSdCfSrg() {
		return cantidadVentasSdCfSrg;
	}

	public BigDecimal getTotalVentasSdCf() {
		return totalVentasSdCf;
	}

	public BigDecimal getTotalVentasSdCfOtras() {
		return totalVentasSdCfOtras;
	}

	public BigDecimal getTotalVentasSdCfSrg() {
		return totalVentasSdCfSrg;
	}

	public LocalDateTime getFechaPresentacion() {
		return fechaPresentacion;
	}





	public static final class Builder {
    	private  String id;
        private  Long nit;
        private  Long ifc;
        private  String razonSocial;
        private  Long codAdministracion;
    	private  String administracion;
        private  Integer mesPeriodo;
        private  Integer anioPeriodo;
        private  String nombreLibro;
        private  Integer cantidadCompras;
        private  BigDecimal totalCompras;
        
        private Integer cantidadComprasCfElec;
    	private Integer cantidadComprasCfIpn;
    	private Integer cantidadComprasCfOtras;
    	private Integer cantidadComprasSdCf;
    	private BigDecimal totalComprasCfElec;
    	private BigDecimal totalComprasCfIpn;
    	private BigDecimal totalComprasCfOtras;
    	private BigDecimal totalComprasSdCf;
    	private BigDecimal importeBaseCf;
    	private BigDecimal importeBaseCfElec;
    	private BigDecimal importeBaseCfIpn;
    	private BigDecimal importeBaseCfOtras;
    	private BigDecimal determinacionPagoCf;
    	private BigDecimal determinacionPagoCfIpn;
    	private BigDecimal determinacionPagoCfOtras;
    	private BigDecimal determinacionPagoSdCf;
    	private BigDecimal determinacionPago;
        
        private  Integer cantidadComprasNotas;
        private  BigDecimal totalComprasNotas;
        private  Integer cantidadVentas;
        private  BigDecimal totalVentas;
        
        private Integer  cantidadVentasCfElec;
    	private Integer  cantidadVentasCfOtras;
    	private BigDecimal totalVentasCfElec;
    	private BigDecimal totalVentasCfOtras;
    	private Integer cantidadVentasSdCf;
    	private Integer cantidadVentasSdCfOtras;
    	private Integer cantidadVentasSdCfSrg;
    	private BigDecimal totalVentasSdCf;
    	private BigDecimal totalVentasSdCfOtras;
    	private BigDecimal totalVentasSdCfSrg;
        
        private  Integer cantidadVentasNotas;
        private  BigDecimal totalVentasNotas;
        private  String  tipoPresentacionId;
        private  LocalDateTime fechaPresentacion;
        private  String periodicidadId;
        private  String cantidadPeriodicidad;
        private  Long numeroOrden;
        private  String estadoLibroId;
        private  LocalDate fechaEstado;
        private  Integer numeroEnvio;
        private  String libroRectificadoId;
        private  String conMovimiento;
        private  Long usuarioRegistro;
        private  LocalDateTime fechaRegistro;
        private  Long usuarioUltimaModificacion;
        private  LocalDateTime fechaUltimaModificacion;
        private  String estadoId;
        private List<String> comprasId;
        private List<String> comprasNotasId;

        private Builder() {
        }

        public LibroRegistradoDomainEvent build() {
            return new LibroRegistradoDomainEvent(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }
     
        public Builder ifc(Long ifc) {
            this.ifc = ifc;
            return this;
        }

        public Builder nit(Long nit) {
            this.nit = nit;
            return this;
        }

        public Builder razonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
            return this;
        }

        public Builder mesPeriodo(Integer mesPeriodo) {
            this.mesPeriodo = mesPeriodo;
            return this;
        }
        
        public Builder codAdministracion(Long codAdministracion)
        {
        	this.codAdministracion=codAdministracion;
        	return this;
        }
    	public Builder administracion(String administracion)
    	{
    		this.administracion=administracion;
    		return this;
    	}
        
        public Builder anioPeriodo(Integer anioPeriodo) {
            this.anioPeriodo = anioPeriodo;
            return this;
        }

        public Builder nombreLibro(String nombreLibro) {
            this.nombreLibro = nombreLibro;
            return this;
        }

        public Builder cantidadCompras(Integer cantidadCompras) {
            this.cantidadCompras = cantidadCompras;
            return this;
        }

        public Builder totalComprasNotas(BigDecimal totalComprasNotas) {
            this.totalComprasNotas = totalComprasNotas;
            return this;
        }
        public Builder cantidadComprasNotas(Integer cantidadComprasNotas) {
            this.cantidadComprasNotas = cantidadComprasNotas;
            return this;
        }

        public Builder totalCompras(BigDecimal totalCompras) {
            this.totalCompras = totalCompras;
            return this;
        }

        public Builder cantidadVentas(Integer cantidadVentas) {
            this.cantidadVentas = cantidadVentas;
            return this;
        }

        public Builder totalVentas(BigDecimal totalVentas) {
            this.totalVentas = totalVentas;
            return this;
        }
        public Builder cantidadVentasNotas(Integer cantidadVentasNotas) {
            this.cantidadVentasNotas= cantidadVentasNotas;
            return this;
        }

        public Builder totalVentasNotas(BigDecimal totalVentasNotas) {
            this.totalVentasNotas = totalVentasNotas;
            return this;
        }
        public Builder tipoPresentacionId(String tipoPresentacionId) {
            this.tipoPresentacionId = tipoPresentacionId;
            return this;
        }

        public Builder fechaPresentacion(LocalDateTime fechaPresentacion) {
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

        public Builder estadoLibroId(String estadoLibroId) {
            this.estadoLibroId = estadoLibroId;
            return this;
        }

        public Builder numeroEnvio(Integer numeroEnvio) {
            this.numeroEnvio = numeroEnvio;
            return this;
        }
        public Builder libroRectificadoId(String libroRectificadoId) {
            this.libroRectificadoId = libroRectificadoId;
            return this;
        }

        public Builder conMovimiento(String conMovimiento) {
            this.conMovimiento = conMovimiento;
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

        public Builder comprasId(List<String> comprasId) {
            this.comprasId = comprasId;
            return this;
        }
        public Builder comprasNotasId(List<String> comprasNotasId) {
            this.comprasNotasId = comprasNotasId;
            return this;
        }
        public Builder  cantidadComprasCfElec(Integer cantidadComprasCfElec)
        {
        	this.cantidadComprasCfElec=cantidadComprasCfElec;
            return this;
        }
    	public Builder cantidadComprasCfIpn(Integer cantidadComprasCfIpn)
        {
    		this.cantidadComprasCfIpn=cantidadComprasCfIpn;
            return this;
        }
    	public Builder  cantidadComprasCfOtras(Integer cantidadComprasCfOtras)
        {
    		this.cantidadComprasCfOtras=cantidadComprasCfOtras;
            return this;
        }
    	public Builder cantidadComprasSdCf(Integer cantidadComprasSdCf)
        {
    		this.cantidadComprasSdCf=cantidadComprasSdCf;
            return this;
        }
    	public Builder totalComprasCfElec(BigDecimal totalComprasCfElec)
        {
    		this.totalComprasCfElec=totalComprasCfElec;
            return this;
        }
    	public Builder totalComprasCfIpn(BigDecimal totalComprasCfIpn)
        {
    		this.totalComprasCfIpn=totalComprasCfIpn;
            return this;
        }
    	public Builder totalComprasCfOtras(BigDecimal totalComprasCfOtras)
        {
    		this.totalComprasCfOtras=totalComprasCfOtras;
            return this;
        }
    	public Builder totalComprasSdCf(BigDecimal totalComprasSdCf)
        {
    		this.totalComprasSdCf=totalComprasSdCf;
            return this;
        }
    	public Builder importeBaseCf(BigDecimal importeBaseCf)
        {
    		this.importeBaseCf=importeBaseCf;
            return this;
        }
    	public Builder importeBaseCfElec(BigDecimal importeBaseCfElec)
        {
    		this.importeBaseCfElec=importeBaseCfElec;
            return this;
        }
    	public Builder importeBaseCfIpn(BigDecimal importeBaseCfIpn)
        {
    		this.importeBaseCfIpn=importeBaseCfIpn;
            return this;
        }
    	public Builder importeBaseCfOtras(BigDecimal importeBaseCfOtras)
        {
    		this.importeBaseCfOtras=importeBaseCfOtras;
            return this;
        }
    	public Builder determinacionPagoCf(BigDecimal determinacionPagoCf)
        {
    		this.determinacionPagoCf=determinacionPagoCf;
            return this;
        }
    	public Builder determinacionPagoCfIpn(BigDecimal determinacionPagoCfIpn)
        {
    		this.determinacionPagoCfIpn=determinacionPagoCfIpn;
            return this;
        }
    	public Builder determinacionPagoCfOtras(BigDecimal determinacionPagoCfOtras)
        {
    		this.determinacionPagoCfOtras=determinacionPagoCfOtras;
            return this;
        }
    	public Builder determinacionPagoSdCf(BigDecimal determinacionPagoSdCf)
        {
    		this.determinacionPagoSdCf=determinacionPagoSdCf;
            return this;
        }
    	public Builder determinacionPago(BigDecimal determinacionPago)
        {
    		this.determinacionPago=determinacionPago;
            return this;
        }
    	public Builder cantidadVentasCfElec(Integer  cantidadVentasCfElec){
            this.cantidadVentasCfElec=cantidadVentasCfElec;
            return this;
        }
    	public Builder cantidadVentasCfOtras(Integer  cantidadVentasCfOtras){
            this.cantidadVentasCfOtras=cantidadVentasCfOtras;
            return this;
        }
    	public Builder totalVentasCfElec(BigDecimal totalVentasCfElec){
            this.totalVentasCfElec=totalVentasCfElec;
            return this;
        }
    	public Builder totalVentasCfOtras(BigDecimal totalVentasCfOtras){
            this.totalVentasCfOtras=totalVentasCfOtras;
            return this;
        }
    	public Builder cantidadVentasSdCf(Integer cantidadVentasSdCf){
            this.cantidadVentasSdCf=cantidadVentasSdCf;
            return this;
        }
    	public Builder cantidadVentasSdCfOtras(Integer cantidadVentasSdCfOtras){
            this.cantidadVentasSdCfOtras=cantidadVentasSdCfOtras;
            return this;
        }
    	public Builder cantidadVentasSdCfSrg(Integer cantidadVentasSdCfSrg){
            this.cantidadVentasSdCfSrg=cantidadVentasSdCfSrg;
            return this;
        }
    	public Builder totalVentasSdCf(BigDecimal totalVentasSdCf){
            this.totalVentasSdCf=totalVentasSdCf;
            return this;
        }
    	public Builder totalVentasSdCfOtras(BigDecimal totalVentasSdCfOtras){
            this.totalVentasSdCfOtras=totalVentasSdCfOtras;
            return this;
        }
    	public Builder totalVentasSdCfSrg(BigDecimal totalVentasSdCfSrg){
            this.totalVentasSdCfSrg=totalVentasSdCfSrg;
            return this;
        }
    	
    }
}
