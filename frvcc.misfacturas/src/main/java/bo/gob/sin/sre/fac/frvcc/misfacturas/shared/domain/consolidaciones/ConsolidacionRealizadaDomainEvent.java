package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class ConsolidacionRealizadaDomainEvent extends DomainEvent {

    private final Long ifcAgente;
    private final Long nitAgente;
    private final String razonSocialAgente;
    private final Integer sucursal;
    private final String direccionSucursal;
    private final String departamentoSucursal;
    private final Long administracion;
    private final Integer gestion;
    private final Integer periodo;
    private final Long cantidadFormularios;
    private final Integer totalCantidadFacturas;
    private final Integer totalCantidadOtrasFacturas;
    private final Integer totalCantidad7rgFacturas;
    private final BigInteger totalImporteFacturas;
    private final BigInteger totalImporteOtrasFacturas;
    private final BigInteger totalImporte7rgFacturas;
    private final BigInteger totalDeterminacionPagoCuenta;
    private final BigInteger totalPagoCuenta;
    private final String estadoConsolidadoId;
    private final LocalDateTime fechaConsolidado;
    private final Long usuarioConsolidador;
    private final String loginUsuarioConsolidador;
    private final String nombreConsolidador;
    private final Long usuarioRegistro;
    private final LocalDateTime  fechaRegistro;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;
    private final String tipoId;
    private final String consolidacionPrincipalId;
    private final List<String> formularios;


    public ConsolidacionRealizadaDomainEvent() {
        this.ifcAgente=null;
        this.nitAgente=null;
        this.razonSocialAgente=null;
        this.sucursal=null;
        this.direccionSucursal=null;
        this.departamentoSucursal=null;
        this.administracion=null;
        this.gestion=null;
        this.periodo=null;
        this.cantidadFormularios=null;
        this.totalCantidadFacturas=null;
        this.totalCantidadOtrasFacturas=null;
        this.totalCantidad7rgFacturas=null;
        this.totalImporteFacturas=null;
        this.totalImporteOtrasFacturas=null;
        this.totalImporte7rgFacturas=null;
        this.totalDeterminacionPagoCuenta=null;
        this.totalPagoCuenta=null;
        this.estadoConsolidadoId=null;
        this.fechaConsolidado=null;
        this.usuarioConsolidador=null;
        this.loginUsuarioConsolidador=null;
        this.nombreConsolidador=null;
        this.usuarioRegistro=null;
        this.fechaRegistro=null;
        this.usuarioUltimaModificacion=null;
        this.fechaUltimaModificacion=null;
        this.estadoId=null;
        this.tipoId=null;
        this.consolidacionPrincipalId=null;
        this.formularios=null;


    }


    public ConsolidacionRealizadaDomainEvent(String aggregateId, Long ifcAgente, Long nitAgente, String razonSocialAgente, Integer sucursal, String direccionSucursal, String departamentoSucursal, Long administracion, Integer gestion, Integer periodo, Long cantidadFormularios, Integer totalCantidadFacturas, Integer totalCantidadOtrasFacturas, Integer totalCantidad7rgFacturas, BigInteger totalImporteFacturas, BigInteger totalImporteOtrasFacturas, BigInteger totalImporte7rgFacturas, BigInteger totalDeterminacionPagoCuenta, BigInteger totalPagoCuenta, String estadoConsolidadoId, LocalDateTime fechaConsolidado, Long usuarioConsolidador, String loginUsuarioConsolidador, String nombreConsolidador, Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId, String tipoId, String consolidacionPrincipalId, List<String> formularios) {
        super(aggregateId);
        this.ifcAgente = ifcAgente;
        this.nitAgente = nitAgente;
        this.razonSocialAgente = razonSocialAgente;
        this.sucursal = sucursal;
        this.direccionSucursal = direccionSucursal;
        this.departamentoSucursal = departamentoSucursal;
        this.administracion = administracion;
        this.gestion = gestion;
        this.periodo = periodo;
        this.cantidadFormularios = cantidadFormularios;
        this.totalCantidadFacturas = totalCantidadFacturas;
        this.totalCantidadOtrasFacturas = totalCantidadOtrasFacturas;
        this.totalCantidad7rgFacturas = totalCantidad7rgFacturas;
        this.totalImporteFacturas = totalImporteFacturas;
        this.totalImporteOtrasFacturas = totalImporteOtrasFacturas;
        this.totalImporte7rgFacturas = totalImporte7rgFacturas;
        this.totalDeterminacionPagoCuenta = totalDeterminacionPagoCuenta;
        this.totalPagoCuenta = totalPagoCuenta;
        this.estadoConsolidadoId = estadoConsolidadoId;
        this.fechaConsolidado = fechaConsolidado;
        this.usuarioConsolidador = usuarioConsolidador;
        this.loginUsuarioConsolidador = loginUsuarioConsolidador;
        this.nombreConsolidador = nombreConsolidador;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.tipoId = tipoId;
        this.consolidacionPrincipalId = consolidacionPrincipalId;
        this.formularios = formularios;
    }

    public ConsolidacionRealizadaDomainEvent(String aggregateId, String eventId, String occurredOn, Long ifcAgente, Long nitAgente, String razonSocialAgente, Integer sucursal, String direccionSucursal, String departamentoSucursal, Long administracion, Integer gestion, Integer periodo, Long cantidadFormularios, Integer totalCantidadFacturas, Integer totalCantidadOtrasFacturas, Integer totalCantidad7rgFacturas, BigInteger totalImporteFacturas, BigInteger totalImporteOtrasFacturas, BigInteger totalImporte7rgFacturas, BigInteger totalDeterminacionPagoCuenta, BigInteger totalPagoCuenta, String estadoConsolidadoId, LocalDateTime fechaConsolidado, Long usuarioConsolidador, String loginUsuarioConsolidador, String nombreConsolidador, Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId, String tipoId, String consolidacionPrincipalId, List<String> formularios) {
        super(aggregateId, eventId, occurredOn);
        this.ifcAgente = ifcAgente;
        this.nitAgente = nitAgente;
        this.razonSocialAgente = razonSocialAgente;
        this.sucursal = sucursal;
        this.direccionSucursal = direccionSucursal;
        this.departamentoSucursal = departamentoSucursal;
        this.administracion = administracion;
        this.gestion = gestion;
        this.periodo = periodo;
        this.cantidadFormularios = cantidadFormularios;
        this.totalCantidadFacturas = totalCantidadFacturas;
        this.totalCantidadOtrasFacturas = totalCantidadOtrasFacturas;
        this.totalCantidad7rgFacturas = totalCantidad7rgFacturas;
        this.totalImporteFacturas = totalImporteFacturas;
        this.totalImporteOtrasFacturas = totalImporteOtrasFacturas;
        this.totalImporte7rgFacturas = totalImporte7rgFacturas;
        this.totalDeterminacionPagoCuenta = totalDeterminacionPagoCuenta;
        this.totalPagoCuenta = totalPagoCuenta;
        this.estadoConsolidadoId = estadoConsolidadoId;
        this.fechaConsolidado = fechaConsolidado;
        this.usuarioConsolidador = usuarioConsolidador;
        this.loginUsuarioConsolidador = loginUsuarioConsolidador;
        this.nombreConsolidador = nombreConsolidador;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.tipoId = tipoId;
        this.consolidacionPrincipalId = consolidacionPrincipalId;
        this.formularios = formularios;
    }


    @Override
    public String eventName() {
        return "consolidacion_realizada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap() {{
            put("ifcAgente",getIfcAgente());
            put("nitAgente",getNitAgente());
            put("razonSocialAgente",getRazonSocialAgente());
            put("sucursal",getSucursal());
            put("direccionSucursal",getDireccionSucursal());
            put("departamentoSucursal",getDepartamentoSucursal());
            put("administracion",getAdministracion());
            put("gestion",getGestion());
            put("periodo",getPeriodo());
            put("cantidadFormularios",getCantidadFormularios());
            put("totalCantidadFacturas",getTotalCantidadFacturas());
            put("totalCantidadOtrasFacturas",getTotalCantidadOtrasFacturas());
            put("totalCantidad7rgFacturas",getTotalCantidad7rgFacturas());
            put("totalImporteFacturas",getTotalImporteFacturas());
            put("totalImporteOtrasFacturas",getTotalImporteOtrasFacturas());
            put("totalImporte7rgFacturas",getTotalImporte7rgFacturas());
            put("totalDeterminacionPagoCuenta",getTotalDeterminacionPagoCuenta());
            put("totalPagoCuenta",getTotalPagoCuenta());
            put("estadoConsolidadoId",getEstadoConsolidadoId());
            put("fechaConsolidado",getFechaConsolidado());
            put("usuarioConsolidador",getUsuarioConsolidador());
            put("loginUsuarioConsolidador",getLoginUsuarioConsolidador());
            put("nombreConsolidador",getNombreConsolidador());
            put("usuarioRegistro",getUsuarioRegistro());
            put("fechaRegistro",getFechaRegistro());
            put("usuarioUltimaModificacion",getUsuarioUltimaModificacion());
            put("fechaUltimaModificacion",getFechaUltimaModificacion());
            put("estadoId",getEstadoId());
            put("tipoId",getTipoId());
            put("consolidacionPrincipalId",getConsolidacionPrincipalId());
            put("formularios",getFormularios());


        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ConsolidacionRealizadaDomainEvent(aggregateId, eventId, occurredOn,
                (Long) body.get("ifcAgente"),
                (Long) body.get("nitAgente"),
                (String)body.get("razonSocialAgente").toString(),
                (Integer)body.get("sucursal"),
                (String) body.get("direccionSucursal"),
                (String) body.get("departamentoSucursal"),
                (Long)body.get("administracion"),
                (Integer) body.get("gestion"),
                (Integer) body.get("periodo"),
                (Long) body.get("cantidadFormularios"),
                (Integer) body.get("totalCantidadFacturas"),
                (Integer) body.get("totalCantidadOtrasFacturas"),
                (Integer) body.get("totalCantidad7rgFacturas"),
                new BigInteger(body.get("totalImporteFacturas").toString()),
                new BigInteger(body.get("totalImporteOtrasFacturas").toString()),
                new BigInteger(body.get("totalImporte7rgFacturas").toString()),
                new BigInteger(body.get("totalDeterminacionPagoCuenta").toString()),
                new BigInteger(body.get("totalPagoCuenta").toString()),
                (String) body.get("estadoConsolidadoId"),
                Utils.stringToLocalDateTime(body.get("fechaConsolidado").toString()),
                (Long) body.get("usuarioConsolidador"),
                (String) body.get("loginUsuarioConsolidador"),
                (String) body.get("nombreConsolidador"),
                (Long) body.get("usuarioRegistro"),
                Utils.stringToLocalDateTime(body.get("fechaRegistro").toString()),
                (Long) body.get("usuarioUltimaModificacion"),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                (String) body.get("estadoId"),
                (String) body.get("tipoId"),
                (String) body.get("consolidacionPrincipalId"),
                (List<String>) body.get("formularios")
                );
    }

    public Long getIfcAgente() {
        return ifcAgente;
    }

    public Long getNitAgente() {
        return nitAgente;
    }

    public String getRazonSocialAgente() {
        return razonSocialAgente;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public String getDepartamentoSucursal() {
        return departamentoSucursal;
    }

    public Long getAdministracion() {
        return administracion;
    }

    public Integer getGestion() {
        return gestion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public Long getCantidadFormularios() {
        return cantidadFormularios;
    }

    public Integer getTotalCantidadFacturas() {
        return totalCantidadFacturas;
    }

    public Integer getTotalCantidadOtrasFacturas() {
        return totalCantidadOtrasFacturas;
    }

    public Integer getTotalCantidad7rgFacturas() {
        return totalCantidad7rgFacturas;
    }

    public BigInteger getTotalImporteFacturas() {
        return totalImporteFacturas;
    }

    public BigInteger getTotalImporteOtrasFacturas() {
        return totalImporteOtrasFacturas;
    }

    public BigInteger getTotalImporte7rgFacturas() {
        return totalImporte7rgFacturas;
    }

    public BigInteger getTotalDeterminacionPagoCuenta() {
        return totalDeterminacionPagoCuenta;
    }

    public BigInteger getTotalPagoCuenta() {
        return totalPagoCuenta;
    }

    public String getEstadoConsolidadoId() {
        return estadoConsolidadoId;
    }

    public LocalDateTime getFechaConsolidado() {
        return fechaConsolidado;
    }

    public Long getUsuarioConsolidador() {
        return usuarioConsolidador;
    }

    public String getLoginUsuarioConsolidador() {
        return loginUsuarioConsolidador;
    }

    public String getNombreConsolidador() {
        return nombreConsolidador;
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

    public String getTipoId() {
        return tipoId;
    }

    public String getConsolidacionPrincipalId() {
        return consolidacionPrincipalId;
    }

    public List<String> getFormularios() {
        return formularios;
    }
}
