package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FormularioResponseGenerico implements Serializable, Cloneable{
    private  String id;
    private  String tipoFormularioId;
    private  Long nitCi;
    private  Long ifc;
    private  Long codigoDependiente;
    private  String razonSocial;
    private  Integer expedicionCi;
    private  Integer mesPeriodo;
    private  Integer anioPeriodo;
    private  String nombreFormulario;
    private  Integer cantidadCompras;
    private  BigDecimal totalCompras;
    private  Integer cantidadComprasCfElec;
    private  Integer cantidadComprasCfIpn;
    private  Integer cantidadComprasCfOtras;
    private  Integer cantidadComprasSdCf;
    private  BigDecimal totalComprasCfElec;
    private  BigDecimal totalComprasCfIpn;
    private  BigDecimal totalComprasCfOtras;
    private  BigDecimal totalComprasSdCf;
    private  BigDecimal determinacionPagoCf;
    private  BigDecimal determinacionPagoCfIpn;
    private  BigDecimal determinacionPagoCfOtras;
    private  BigDecimal determinacionPagoSdCf;
    private  BigDecimal determinacionPago;
    private  Integer lugarDepartamento;
    private  String  tipoPresentacionId;
    private  String direccion;
    private  Long nitEmpleador;
    private  String nombreEmpleador;
    private  String direccionEmpleador;
    private  LocalDate fechaPresentacion;
    private  String periodicidadId;
    private  String cantidadPeriodicidad;
    private  Long numeroOrden;
    private  String estadoFormularioId;
    private  LocalDate fechaEstado;
    private  Integer numeroEnvio;
    private  Long usuarioRegistro;
    private  LocalDateTime fechaRegistro;
    private  Long usuarioUltimaModificacion;
    private  LocalDateTime fechaUltimaModificacion;
    private  String estadoId;
    private  DatosEspecificos datosEspecificos;
    private  List<String> compras;
    private Integer numeroSucursal;
    private Long usuarioReceptor;
    private String loginUsuarioReceptor;
    private String nombreReceptor;
    private String consolidacionId;
    private BigInteger totalComprasCfRed;
    private BigInteger totalComprasCfIpnRed;
    private BigInteger totalComprasCfOtrasRed;
    private BigInteger totalComprasSdCfRed;
    private BigInteger determinacionPagoCfRed;
    private BigInteger determinacionPagoCfIpnRed;
    private BigInteger determinacionPagoCfOtrasRed;
    private BigInteger determinacionPagoSdCfRed;
    private String tipoUsoId;

    public FormularioResponseGenerico() {
    }

    public FormularioResponseGenerico(String id, String tipoFormularioId, Long nitCi, Long ifc, Long codigoDependiente,
                                      String razonSocial, Integer expedicionCi, Integer mesPeriodo, Integer anioPeriodo,
                                      String nombreFormulario, Integer cantidadCompras, BigDecimal totalCompras, Integer cantidadComprasCfElec,
                                      Integer cantidadComprasCfIpn, Integer cantidadComprasCfOtras, Integer cantidadComprasSdCf,
                                      BigDecimal totalComprasCfElec, BigDecimal totalComprasCfIpn, BigDecimal totalComprasCfOtras,
                                      BigDecimal totalComprasSdCf, BigDecimal determinacionPagoCf, BigDecimal determinacionPagoCfIpn,
                                      BigDecimal determinacionPagoCfOtras, BigDecimal determinacionPagoSdCf, BigDecimal determinacionPago,
                                      Integer lugarDepartamento, String tipoPresentacionId, String direccion, Long nitEmpleador,
                                      String nombreEmpleador, String direccionEmpleador, LocalDate fechaPresentacion, String periodicidadId,
                                      String cantidadPeriodicidad, Long numeroOrden, String estadoFormularioId, LocalDate fechaEstado,
                                      Integer numeroEnvio, Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
                                      LocalDateTime fechaUltimaModificacion, String estadoId, DatosEspecificos datosEspecificos,
                                      List<String> compras, Integer numeroSucursal, Long usuarioReceptor, String loginUsuarioReceptor,
                                      String nombreReceptor, String consolidacionId,   BigInteger totalComprasCfRed,
                                      BigInteger totalComprasCfIpnRed,
                                      BigInteger totalComprasCfOtrasRed,
                                      BigInteger totalComprasSdCfRed,
                                      BigInteger determinacionPagoCfRed,
                                      BigInteger determinacionPagoCfIpnRed,
                                      BigInteger determinacionPagoCfOtrasRed,
                                      BigInteger determinacionPagoSdCfRed,
                                      String tipoUsoId) {
        super();
        this.id = id;
        this.tipoFormularioId = tipoFormularioId;
        this.nitCi = nitCi;
        this.ifc = ifc;
        this.codigoDependiente = codigoDependiente;
        this.razonSocial = razonSocial;
        this.expedicionCi = expedicionCi;
        this.mesPeriodo = mesPeriodo;
        this.anioPeriodo = anioPeriodo;
        this.nombreFormulario = nombreFormulario;
        this.cantidadCompras = cantidadCompras;
        this.totalCompras = totalCompras;
        this.cantidadComprasCfElec = cantidadComprasCfElec;
        this.cantidadComprasCfIpn = cantidadComprasCfIpn;
        this.cantidadComprasCfOtras = cantidadComprasCfOtras;
        this.cantidadComprasSdCf = cantidadComprasSdCf;
        this.totalComprasCfElec = totalComprasCfElec;
        this.totalComprasCfIpn = totalComprasCfIpn;
        this.totalComprasCfOtras = totalComprasCfOtras;
        this.totalComprasSdCf = totalComprasSdCf;
        this.determinacionPagoCf = determinacionPagoCf;
        this.determinacionPagoCfIpn = determinacionPagoCfIpn;
        this.determinacionPagoCfOtras = determinacionPagoCfOtras;
        this.determinacionPagoSdCf = determinacionPagoSdCf;
        this.determinacionPago = determinacionPago;
        this.lugarDepartamento = lugarDepartamento;
        this.tipoPresentacionId = tipoPresentacionId;
        this.direccion = direccion;
        this.nitEmpleador = nitEmpleador;
        this.nombreEmpleador = nombreEmpleador;
        this.direccionEmpleador = direccionEmpleador;
        this.fechaPresentacion = fechaPresentacion;
        this.periodicidadId = periodicidadId;
        this.cantidadPeriodicidad = cantidadPeriodicidad;
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaEstado = fechaEstado;
        this.numeroEnvio = numeroEnvio;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.datosEspecificos = datosEspecificos;
        this.compras = compras;
        this.numeroSucursal=numeroSucursal;
        this.usuarioReceptor=usuarioReceptor;
        this.loginUsuarioReceptor=loginUsuarioReceptor;
        this.nombreReceptor=nombreReceptor;
        this.consolidacionId=consolidacionId;
        this.totalComprasCfRed=totalComprasCfRed;
        this.totalComprasCfIpnRed=totalComprasCfIpnRed;
        this.totalComprasCfOtrasRed=totalComprasCfOtrasRed;
        this.totalComprasSdCfRed=totalComprasSdCfRed;
        this.determinacionPagoCfRed=determinacionPagoCfRed;
        this.determinacionPagoCfIpnRed=determinacionPagoCfIpnRed;
        this.determinacionPagoCfOtrasRed=determinacionPagoCfOtrasRed;
        this.determinacionPagoSdCfRed=determinacionPagoSdCfRed;
        this.tipoUsoId =tipoUsoId;

    }

    public static FormularioResponseGenerico fromAggregate(Formulario formulario) {
        return new FormularioResponseGenerico(
                formulario.id() != null ? formulario.id().value() : null,
                formulario.tipoFormularioId() != null ? formulario.tipoFormularioId().value() : null,
                formulario.nitCi() != null ? formulario.nitCi().value() : null,
                formulario.ifc() != null ? formulario.ifc().value() : null,
                formulario.codigoDependiente() != null ? formulario.codigoDependiente().value() : null,
                formulario.razonSocial() != null ? formulario.razonSocial().value() : null,
                formulario.expedicionCi() != null ? formulario.expedicionCi().value() : null,
                formulario.mesPeriodo() != null ? formulario.mesPeriodo().value() : null,
                formulario.anioPeriodo() != null ? formulario.anioPeriodo().value() : null,
                formulario.nombreFormulario() != null ? formulario.nombreFormulario().value() : null,
                formulario.cantidadCompras() != null ? formulario.cantidadCompras().value() : null,
                formulario.totalCompras() != null ? formulario.totalCompras().value() : null,
                formulario.cantidadComprasCfElec()!= null ? formulario.cantidadComprasCfElec().value() : null,
                formulario.cantidadComprasCfIpn()!= null ? formulario.cantidadComprasCfIpn().value() : null,
                formulario.cantidadComprasCfOtras()!= null ? formulario.cantidadComprasCfOtras().value() : null,
                formulario.cantidadComprasSdCf()!= null ? formulario.cantidadComprasSdCf().value() : null,
                formulario.totalComprasCfElec()!= null ? formulario.totalComprasCfElec().value() : null,
                formulario.totalComprasCfIpn()!= null ? formulario.totalComprasCfIpn().value() : null,
                formulario.totalComprasCfOtras()!= null ? formulario.totalComprasCfOtras().value() : null,
                formulario.totalComprasSdCf()!= null ? formulario.totalComprasSdCf().value() : null,
                formulario.determinacionPagoCf()!= null ? formulario.determinacionPagoCf().value() : null,
                formulario.determinacionPagoCfIpn()!= null ? formulario.determinacionPagoCfIpn().value() : null,
                formulario.determinacionPagoCfOtras()!= null ? formulario.determinacionPagoCfOtras().value() : null,
                formulario.determinacionPagoSdCf()!= null ? formulario.determinacionPagoSdCf().value() : null,
                formulario.determinacionPago() != null ? formulario.determinacionPago().value() : null,
                formulario.lugarDepartamento() != null ? formulario.lugarDepartamento().value() : null,
                formulario.tipoPresentacionId() != null ? formulario.tipoPresentacionId().value() : null,
                formulario.direccion() != null ? formulario.direccion().value() : null,
                formulario.nitEmpleador() != null ? formulario.nitEmpleador().value() : null,
                formulario.nombreEmpleador() != null ? formulario.nombreEmpleador().value() : null,
                formulario.direccionEmpleador() != null ? formulario.direccionEmpleador().value() : null,
                formulario.fechaPresentacion() != null ? formulario.fechaPresentacion().value() : null,
                formulario.periodicidadId() != null ? formulario.periodicidadId().value() : null,
                formulario.cantidadPeriodicidad() != null ? formulario.cantidadPeriodicidad().value() : null,
                formulario.numeroOrden() != null ? formulario.numeroOrden().value() : null,
                formulario.estadoFormularioId() != null ? formulario.estadoFormularioId().value() : null,
                formulario.fechaEstado() != null ? formulario.fechaEstado().value() : null,
                formulario.numeroEnvio() != null ? formulario.numeroEnvio().value() : null,
                formulario.usuarioRegistro() != null ? formulario.usuarioRegistro().value() : null,
                formulario.fechaRegistro() != null ? formulario.fechaRegistro().value() : null,
                formulario.usuarioUltimaModificacion() != null ? formulario.usuarioUltimaModificacion().value() : null,
                formulario.fechaUltimaModificacion() != null ? formulario.fechaUltimaModificacion().value() : null,
                formulario.estadoId() != null ? formulario.estadoId().value() : null,
                formulario.datosEspecificos()!=null?formulario.datosEspecificos():null,
                formulario.compras()!=null?formulario.compras().stream().map(compraId -> compraId.value()).collect(Collectors.toList()):null,
                formulario.numeroSucursal()!=null?formulario.numeroSucursal().value():null,
                formulario.usuarioReceptor()!=null?formulario.usuarioReceptor().value():null,
                formulario.loginUsuarioReceptor()!=null?formulario.loginUsuarioReceptor().value():null,
                formulario.nombreReceptor()!=null?formulario.nombreReceptor().value():null,
                formulario.consolidacionId()!=null?formulario.consolidacionId().value():null,
                formulario.totalComprasCfRed()!= null ? formulario.totalComprasCfRed().value() : null,
                formulario.totalComprasCfIpnRed()!= null ? formulario.totalComprasCfIpnRed().value() : null,
                formulario.totalComprasCfOtrasRed()!= null ? formulario.totalComprasCfOtrasRed().value() : null,
                formulario.totalComprasSdCfRed()!= null ? formulario.totalComprasSdCfRed().value() : null,
                formulario.determinacionPagoCfRed()!= null ? formulario.determinacionPagoCfRed().value() : null,
                formulario.determinacionPagoCfIpnRed()!= null ? formulario.determinacionPagoCfIpnRed().value() : null,
                formulario.determinacionPagoCfOtrasRed()!= null ? formulario.determinacionPagoCfOtrasRed().value() : null,
                formulario.determinacionPagoSdCfRed()!= null ? formulario.determinacionPagoSdCfRed().value() : null,
                formulario.tipoUsoId()!=null?formulario.tipoUsoId().value():null);
    }

    public List<String> getCompras() {
        return compras;
    }

    public String getId() {
        return id;
    }

    public String getTipoFormularioId() {
        return tipoFormularioId;
    }

    public Long getNitCi() {
        return nitCi;
    }

    public Long getIfc() {
        return ifc;
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
    public Integer cantidadComprasCfElec()
    {
        return cantidadComprasCfElec;
    }
    public Integer cantidadComprasCfIpn()
    {
        return cantidadComprasCfIpn;
    }
    public Integer cantidadComprasCfOtras()
    {
        return cantidadComprasCfOtras;
    }
    public Integer cantidadComprasSdCf()
    {
        return cantidadComprasSdCf;
    }
    public BigDecimal totalComprasCfElec()
    {
        return totalComprasCfElec;
    }
    public BigDecimal totalComprasCfIpn()
    {
        return totalComprasCfIpn;
    }
    public BigDecimal totalComprasCfOtras()
    {
        return totalComprasCfOtras;
    }
    public BigDecimal totalComprasSdCf()
    {
        return totalComprasSdCf;
    }
    public BigDecimal determinacionPagoCf()
    {
        return determinacionPagoCf;
    }
    public BigDecimal determinacionPagoCfIpn()
    {
        return determinacionPagoCfIpn;
    }
    public BigDecimal determinacionPagoCfOtras()
    {
        return determinacionPagoCfOtras;
    }
    public BigDecimal determinacionPagoSdCf()
    {
        return determinacionPagoSdCf;
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

    public Long getNitEmpleador() {
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

    public String getEstadoFormularioId() {
        return estadoFormularioId;
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

    public DatosEspecificos getDatosEspecificos() {
        return datosEspecificos;
    }
    public List<String> compras()
    {
        return compras;
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


    public void setId(String id) {
        this.id = id;
    }

    public void setTipoFormularioId(String tipoFormularioId) {
        this.tipoFormularioId = tipoFormularioId;
    }

    public void setNitCi(Long nitCi) {
        this.nitCi = nitCi;
    }

    public void setIfc(Long ifc) {
        this.ifc = ifc;
    }

    public void setCodigoDependiente(Long codigoDependiente) {
        this.codigoDependiente = codigoDependiente;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setExpedicionCi(Integer expedicionCi) {
        this.expedicionCi = expedicionCi;
    }

    public void setMesPeriodo(Integer mesPeriodo) {
        this.mesPeriodo = mesPeriodo;
    }

    public void setAnioPeriodo(Integer anioPeriodo) {
        this.anioPeriodo = anioPeriodo;
    }

    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    public void setCantidadCompras(Integer cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

    public void setTotalCompras(BigDecimal totalCompras) {
        this.totalCompras = totalCompras;
    }

    public void setCantidadComprasCfElec(Integer cantidadComprasCfElec) {
        this.cantidadComprasCfElec = cantidadComprasCfElec;
    }

    public void setCantidadComprasCfIpn(Integer cantidadComprasCfIpn) {
        this.cantidadComprasCfIpn = cantidadComprasCfIpn;
    }

    public void setCantidadComprasCfOtras(Integer cantidadComprasCfOtras) {
        this.cantidadComprasCfOtras = cantidadComprasCfOtras;
    }

    public void setCantidadComprasSdCf(Integer cantidadComprasSdCf) {
        this.cantidadComprasSdCf = cantidadComprasSdCf;
    }

    public void setTotalComprasCfElec(BigDecimal totalComprasCfElec) {
        this.totalComprasCfElec = totalComprasCfElec;
    }

    public void setTotalComprasCfIpn(BigDecimal totalComprasCfIpn) {
        this.totalComprasCfIpn = totalComprasCfIpn;
    }

    public void setTotalComprasCfOtras(BigDecimal totalComprasCfOtras) {
        this.totalComprasCfOtras = totalComprasCfOtras;
    }

    public void setTotalComprasSdCf(BigDecimal totalComprasSdCf) {
        this.totalComprasSdCf = totalComprasSdCf;
    }

    public void setDeterminacionPagoCf(BigDecimal determinacionPagoCf) {
        this.determinacionPagoCf = determinacionPagoCf;
    }

    public void setDeterminacionPagoCfIpn(BigDecimal determinacionPagoCfIpn) {
        this.determinacionPagoCfIpn = determinacionPagoCfIpn;
    }

    public void setDeterminacionPagoCfOtras(BigDecimal determinacionPagoCfOtras) {
        this.determinacionPagoCfOtras = determinacionPagoCfOtras;
    }

    public void setDeterminacionPagoSdCf(BigDecimal determinacionPagoSdCf) {
        this.determinacionPagoSdCf = determinacionPagoSdCf;
    }

    public void setDeterminacionPago(BigDecimal determinacionPago) {
        this.determinacionPago = determinacionPago;
    }

    public void setLugarDepartamento(Integer lugarDepartamento) {
        this.lugarDepartamento = lugarDepartamento;
    }

    public void setTipoPresentacionId(String tipoPresentacionId) {
        this.tipoPresentacionId = tipoPresentacionId;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNitEmpleador(Long nitEmpleador) {
        this.nitEmpleador = nitEmpleador;
    }

    public void setNombreEmpleador(String nombreEmpleador) {
        this.nombreEmpleador = nombreEmpleador;
    }

    public void setDireccionEmpleador(String direccionEmpleador) {
        this.direccionEmpleador = direccionEmpleador;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = Utils.stringToLocalDate(fechaPresentacion);
    }
    public void setPeriodicidadId(String periodicidadId) {
        this.periodicidadId = periodicidadId;
    }

    public void setCantidadPeriodicidad(String cantidadPeriodicidad) {
        this.cantidadPeriodicidad = cantidadPeriodicidad;
    }

    public void setNumeroOrden(Long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public void setEstadoFormularioId(String estadoFormularioId) {
        this.estadoFormularioId = estadoFormularioId;
    }

    public void setFechaEstado(LocalDate fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public void setFechaEstado(String fechaEstado) {
        this.fechaEstado = Utils.stringToLocalDate(fechaEstado);
    }

    public void setNumeroEnvio(Integer numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    public void setUsuarioRegistro(Long usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = Utils.stringToLocalDateTime(fechaRegistro);
    }

    public void setUsuarioUltimaModificacion(Long usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
        this.fechaUltimaModificacion = Utils.stringToLocalDateTime(fechaUltimaModificacion);
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public void setDatosEspecificos(DatosEspecificos datosEspecificos) {


        this.datosEspecificos = datosEspecificos;
    }

    public void setCompras(List<String> compras) {
        this.compras = compras;
    }

    public Integer getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(Integer numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public Long getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(Long usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public String getLoginUsuarioReceptor() {
        return loginUsuarioReceptor;
    }

    public void setLoginUsuarioReceptor(String loginUsuarioReceptor) {
        this.loginUsuarioReceptor = loginUsuarioReceptor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getConsolidacionId() {
        return consolidacionId;
    }

    public void setConsolidacionId(String consolidacionId) {
        this.consolidacionId = consolidacionId;
    }

    public BigInteger getTotalComprasCfRed() {
        return totalComprasCfRed;
    }

    public void setTotalComprasCfRed(BigInteger totalComprasCfRed) {
        this.totalComprasCfRed = totalComprasCfRed;
    }

    public BigInteger getTotalComprasCfIpnRed() {
        return totalComprasCfIpnRed;
    }

    public void setTotalComprasCfIpnRed(BigInteger totalComprasCfIpnRed) {
        this.totalComprasCfIpnRed = totalComprasCfIpnRed;
    }

    public BigInteger getTotalComprasCfOtrasRed() {
        return totalComprasCfOtrasRed;
    }

    public void setTotalComprasCfOtrasRed(BigInteger totalComprasCfOtrasRed) {
        this.totalComprasCfOtrasRed = totalComprasCfOtrasRed;
    }

    public BigInteger getTotalComprasSdCfRed() {
        return totalComprasSdCfRed;
    }

    public void setTotalComprasSdCfRed(BigInteger totalComprasSdCfRed) {
        this.totalComprasSdCfRed = totalComprasSdCfRed;
    }

    public BigInteger getDeterminacionPagoCfRed() {
        return determinacionPagoCfRed;
    }

    public void setDeterminacionPagoCfRed(BigInteger determinacionPagoCfRed) {
        this.determinacionPagoCfRed = determinacionPagoCfRed;
    }

    public BigInteger getDeterminacionPagoCfIpnRed() {
        return determinacionPagoCfIpnRed;
    }

    public void setDeterminacionPagoCfIpnRed(BigInteger determinacionPagoCfIpnRed) {
        this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed;
    }

    public BigInteger getDeterminacionPagoCfOtrasRed() {
        return determinacionPagoCfOtrasRed;
    }

    public void setDeterminacionPagoCfOtrasRed(BigInteger determinacionPagoCfOtrasRed) {
        this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed;
    }

    public BigInteger getDeterminacionPagoSdCfRed() {
        return determinacionPagoSdCfRed;
    }

    public void setDeterminacionPagoSdCfRed(BigInteger determinacionPagoSdCfRed) {
        this.determinacionPagoSdCfRed = determinacionPagoSdCfRed;
    }

    public String getTipoUsoId() {
        return tipoUsoId;
    }

    public void setTipoUsoId(String tipoUsoId) {
        this.tipoUsoId = tipoUsoId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
