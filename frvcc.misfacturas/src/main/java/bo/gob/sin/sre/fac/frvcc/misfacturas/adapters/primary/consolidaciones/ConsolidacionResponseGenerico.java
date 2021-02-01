package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public final class ConsolidacionResponseGenerico implements Serializable, Cloneable {

    private  String id;

    private Long ifcAgente;
    private Long nitAgente;
    private String razonSocialAgente;
    private Integer sucursal;
    private String direccionSucursal;
    private String departamentoSucursal;
    private Long administracion;
    private Integer gestion;
    private Integer periodo;
    private Long cantidadFormularios;
    private Integer totalCantidadFacturas;
    private Integer totalCantidadOtrasFacturas;
    private Integer totalCantidad7rgFacturas;
    private BigInteger totalImporteFacturas;
    private BigInteger totalImporteOtrasFacturas;
    private BigInteger totalImporte7rgFacturas;
    private BigInteger totalDeterminacionPagoCuenta;
    private BigInteger totalPagoCuenta;
    private String estadoConsolidadoId;
    private LocalDateTime fechaConsolidado;
    private Long usuarioConsolidador;
    private String loginUsuarioConsolidador;
    private String nombreConsolidador;
    private Long usuarioRegistro;
    private LocalDateTime  fechaRegistro;
    private Long usuarioUltimaModificacion;
    private LocalDateTime fechaUltimaModificacion;
    private String estadoId;
    private String tipoId;
    private String consolidacionPrincipalId;
    private List<String> formularios;
    private Integer totalCantidadIpnFacturas;
    private BigInteger totalImporteIpnFacturas;
    public ConsolidacionResponseGenerico() {
    }

    public String getId() {
        return id;
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

    public Integer getTotalCantidadIpnFacturas() {
        return totalCantidadIpnFacturas;
    }

    public BigInteger getTotalImporteIpnFacturas() {
        return totalImporteIpnFacturas;
    }

    public List<String> getFormularios() {
        return formularios;
    }

    public ConsolidacionResponseGenerico(String id,
                                         Long ifcAgente,
                                         Long nitAgente,
                                         String razonSocialAgente,
                                         Integer sucursal,
                                         String direccionSucursal,
                                         String departamentoSucursal,
                                         Long administracion,
                                         Integer gestion,
                                         Integer periodo,
                                         Long cantidadFormularios,
                                         Integer totalCantidadFacturas,
                                         Integer totalCantidadOtrasFacturas,
                                         Integer totalCantidad7rgFacturas,
                                         BigInteger totalImporteFacturas,
                                         BigInteger totalImporteOtrasFacturas,
                                         BigInteger totalImporte7rgFacturas,
                                         BigInteger totalDeterminacionPagoCuenta,
                                         BigInteger totalPagoCuenta,
                                         String estadoConsolidadoId,
                                         LocalDateTime fechaConsolidado,
                                         Long usuarioConsolidador,
                                         String loginUsuarioConsolidador,
                                         String nombreConsolidador,
                                         Long usuarioRegistro,
                                         LocalDateTime fechaRegistro,
                                         Long usuarioUltimaModificacion,
                                         LocalDateTime fechaUltimaModificacion,
                                         String estadoId,
                                         String tipoId,
                                         String consolidacionPrincipalId,
                                         List<String> formularios,
                                         Integer totalCantidadIpnFacturas,
                                         BigInteger totalImporteIpnFacturas) {
        this.id = id;
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
        this.tipoId=tipoId;
        this.consolidacionPrincipalId=consolidacionPrincipalId;
        this.formularios=formularios;
        this.totalCantidadIpnFacturas=totalCantidadIpnFacturas;
        this.totalImporteIpnFacturas=totalImporteIpnFacturas;
    }
    public static ConsolidacionResponseGenerico fromAggregate(Consolidacion pConsolidacion){
        return new ConsolidacionResponseGenerico(
                pConsolidacion.id() != null ? pConsolidacion.id().value(): null,
                pConsolidacion.ifcAgente() != null ? pConsolidacion.ifcAgente().value(): null,
                pConsolidacion.nitAgente() != null ? pConsolidacion.nitAgente().value(): null,
                pConsolidacion.razonSocialAgente() != null ? pConsolidacion.razonSocialAgente().value(): null,
                pConsolidacion.sucursal() != null ? pConsolidacion.sucursal().value(): null,
                pConsolidacion.direccionSucursal() != null ? pConsolidacion.direccionSucursal().value(): null,
                pConsolidacion.departamentoSucursal() != null ? pConsolidacion.departamentoSucursal().value(): null,
                pConsolidacion.administracion() != null ? pConsolidacion.administracion().value(): null,
                pConsolidacion.gestion() != null ? pConsolidacion.gestion().value(): null,
                pConsolidacion.periodo() != null ? pConsolidacion.periodo().value(): null,
                pConsolidacion.cantidadFormularios() != null ? pConsolidacion.cantidadFormularios().value(): null,
                pConsolidacion.totalCantidadFacturas() != null ? pConsolidacion.totalCantidadFacturas().value(): null,
                pConsolidacion.totalCantidadOtrasFacturas() != null ? pConsolidacion.totalCantidadOtrasFacturas().value(): null,
                pConsolidacion.totalCantidad7rgFacturas() != null ? pConsolidacion.totalCantidad7rgFacturas().value(): null,
                pConsolidacion.totalImporteFacturas() != null ? pConsolidacion.totalImporteFacturas().value(): null,
                pConsolidacion.totalImporteOtrasFacturas() != null ? pConsolidacion.totalImporteOtrasFacturas().value(): null,
                pConsolidacion.totalImporte7rgFacturas() != null ? pConsolidacion.totalImporte7rgFacturas().value(): null,
                pConsolidacion.totalDeterminacionPagoCuenta() != null ? pConsolidacion.totalDeterminacionPagoCuenta().value(): null,
                pConsolidacion.totalPagoCuenta() != null ? pConsolidacion.totalPagoCuenta().value(): null,
                pConsolidacion.estadoConsolidadoId() != null ? pConsolidacion.estadoConsolidadoId().value(): null,
                pConsolidacion.fechaConsolidado() != null ? pConsolidacion.fechaConsolidado().value(): null,
                pConsolidacion.usuarioConsolidador() != null ? pConsolidacion.usuarioConsolidador().value(): null,
                pConsolidacion.loginUsuarioConsolidador() != null ? pConsolidacion.loginUsuarioConsolidador().value(): null,
                pConsolidacion.nombreConsolidador() != null ? pConsolidacion.nombreConsolidador().value(): null,
                pConsolidacion.usuarioRegistro() != null ? pConsolidacion.usuarioRegistro().value(): null,
                pConsolidacion.fechaRegistro() != null ? pConsolidacion.fechaRegistro().value(): null,
                pConsolidacion.usuarioUltimaModificacion() != null ? pConsolidacion.usuarioUltimaModificacion().value(): null,
                pConsolidacion.fechaUltimaModificacion() != null ? pConsolidacion.fechaUltimaModificacion().value(): null,
                pConsolidacion.estadoId() != null ? pConsolidacion.estadoId().value(): null,
                pConsolidacion.tipoId()!=null?pConsolidacion.tipoId().value():null,
                pConsolidacion.consolidacionPrincipalId()!=null?pConsolidacion.consolidacionPrincipalId().value():null,
                pConsolidacion.formularios()!=null ? pConsolidacion.formularios().stream().map(formularioId -> formularioId.value()).collect(Collectors.toList()):null,
                pConsolidacion.totalCantidadIpnFacturas()!=null?pConsolidacion.totalCantidadIpnFacturas().value():null,
                pConsolidacion.totalImporteIpnFacturas()!=null?pConsolidacion.totalImporteIpnFacturas().value():null
                );
    }
}
