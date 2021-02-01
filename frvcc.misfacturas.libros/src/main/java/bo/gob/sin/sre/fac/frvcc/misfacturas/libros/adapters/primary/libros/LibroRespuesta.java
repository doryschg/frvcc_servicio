package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
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


public class LibroRespuesta {
	private final String id;
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
	
	


	public LibroRespuesta(String id, Long nit, Long ifc, String razonSocial, Long codAdministracion,
			String administracion, Integer mesPeriodo, Integer anioPeriodo, String nombreLibro, Integer cantidadCompras,
			BigDecimal totalCompras, Integer cantidadComprasCfElec, Integer cantidadComprasCfIpn,
			Integer cantidadComprasCfOtras, Integer cantidadComprasSdCf, BigDecimal totalComprasCfElec,
			BigDecimal totalComprasCfIpn, BigDecimal totalComprasCfOtras, BigDecimal totalComprasSdCf,
			BigDecimal importeBaseCf, BigDecimal importeBaseCfElec, BigDecimal importeBaseCfIpn,
			BigDecimal importeBaseCfOtras, BigDecimal determinacionPagoCf, BigDecimal determinacionPagoCfIpn,
			BigDecimal determinacionPagoCfOtras, BigDecimal determinacionPagoSdCf, BigDecimal determinacionPago,
			Integer cantidadComprasNotas, BigDecimal totalComprasNotas, Integer cantidadVentas, BigDecimal totalVentas,
			Integer cantidadVentasCfElec, Integer cantidadVentasCfOtras, BigDecimal totalVentasCfElec,
			BigDecimal totalVentasCfOtras, Integer cantidadVentasSdCf, Integer cantidadVentasSdCfOtras,
			Integer cantidadVentasSdCfSrg, BigDecimal totalVentasSdCf, BigDecimal totalVentasSdCfOtras,
			BigDecimal totalVentasSdCfSrg, Integer cantidadVentasNotas, BigDecimal totalVentasNotas,
			String tipoPresentacionId, LocalDateTime fechaPresentacion, String periodicidadId,
			String cantidadPeriodicidad, Long numeroOrden, String estadoLibroId, LocalDate fechaEstado,
			Integer numeroEnvio, String libroRectificadoId, String conMovimiento, Long usuarioRegistro,
			LocalDateTime fechaRegistro, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion,
			String estadoId, List<String> comprasId, List<String> comprasNotasId) {
		super();
		this.id = id;
		this.nit = nit;
		this.ifc = ifc;
		this.razonSocial = razonSocial;
		this.codAdministracion = codAdministracion;
		this.administracion = administracion;
		this.mesPeriodo = mesPeriodo;
		this.anioPeriodo = anioPeriodo;
		this.nombreLibro = nombreLibro;
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
		this.importeBaseCf = importeBaseCf;
		this.importeBaseCfElec = importeBaseCfElec;
		this.importeBaseCfIpn = importeBaseCfIpn;
		this.importeBaseCfOtras = importeBaseCfOtras;
		this.determinacionPagoCf = determinacionPagoCf;
		this.determinacionPagoCfIpn = determinacionPagoCfIpn;
		this.determinacionPagoCfOtras = determinacionPagoCfOtras;
		this.determinacionPagoSdCf = determinacionPagoSdCf;
		this.determinacionPago = determinacionPago;
		this.cantidadComprasNotas = cantidadComprasNotas;
		this.totalComprasNotas = totalComprasNotas;
		this.cantidadVentas = cantidadVentas;
		this.totalVentas = totalVentas;
		this.cantidadVentasCfElec = cantidadVentasCfElec;
		this.cantidadVentasCfOtras = cantidadVentasCfOtras;
		this.totalVentasCfElec = totalVentasCfElec;
		this.totalVentasCfOtras = totalVentasCfOtras;
		this.cantidadVentasSdCf = cantidadVentasSdCf;
		this.cantidadVentasSdCfOtras = cantidadVentasSdCfOtras;
		this.cantidadVentasSdCfSrg = cantidadVentasSdCfSrg;
		this.totalVentasSdCf = totalVentasSdCf;
		this.totalVentasSdCfOtras = totalVentasSdCfOtras;
		this.totalVentasSdCfSrg = totalVentasSdCfSrg;
		this.cantidadVentasNotas = cantidadVentasNotas;
		this.totalVentasNotas = totalVentasNotas;
		this.tipoPresentacionId = tipoPresentacionId;
		this.fechaPresentacion = fechaPresentacion;
		this.periodicidadId = periodicidadId;
		this.cantidadPeriodicidad = cantidadPeriodicidad;
		this.numeroOrden = numeroOrden;
		this.estadoLibroId = estadoLibroId;
		this.fechaEstado = fechaEstado;
		this.numeroEnvio = numeroEnvio;
		this.libroRectificadoId = libroRectificadoId;
		this.conMovimiento = conMovimiento;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
		this.comprasId = comprasId;
		this.comprasNotasId = comprasNotasId;
	}

	public static LibroRespuesta fromAggregate(Libro Libro) {
	        return new LibroRespuesta(
	        		Libro.id()!=null?Libro.id().value():null,
	    					Libro.nit()!=null?Libro.nit().value():null,
	    					Libro.ifc()!=null?Libro.ifc().value():null,
	    					Libro.razonSocial()!=null?Libro.razonSocial().value():null,
	    					Libro.codAdministracion()!=null?Libro.codAdministracion().value():null,
	    					Libro.administracion()!=null?Libro.administracion().value():null,
	    					Libro.mesPeriodo()!=null?Libro.mesPeriodo().value():null,
	    					Libro.anioPeriodo()!=null?Libro.anioPeriodo().value():null,
	    					Libro.nombreLibro()!=null?Libro.nombreLibro().value():null,
	    					Libro.cantidadCompras()!=null?Libro.cantidadCompras().value():null,
	    					Libro.totalCompras()!=null?Libro.totalCompras().value():null,
	    					Libro.cantidadComprasCfElec()!=null?Libro.cantidadComprasCfElec().value():null,
	    					Libro.cantidadComprasCfIpn()!=null?Libro.cantidadComprasCfIpn().value():null,
	    					Libro.cantidadComprasCfOtras()!=null?Libro.cantidadComprasCfOtras().value():null,
	    					Libro.cantidadComprasSdCf()!=null?Libro.cantidadComprasSdCf().value():null,
	    					Libro.totalComprasCfElec()!=null?Libro.totalComprasCfElec().value():null,
	    					Libro.totalComprasCfIpn()!=null?Libro.totalComprasCfIpn().value():null,
	    					Libro.totalComprasCfOtras()!=null?Libro.totalComprasCfOtras().value():null,
	    					Libro.totalComprasSdCf()!=null?Libro.totalComprasSdCf().value():null,
	    					Libro.importeBaseCf()!=null?Libro.importeBaseCf().value():null,
	    					Libro.importeBaseCfElec()!=null?Libro.importeBaseCfElec().value():null,
	    					Libro.importeBaseCfIpn()!=null?Libro.importeBaseCfIpn().value():null,
	    					Libro.importeBaseCfOtras()!=null?Libro.importeBaseCfOtras().value():null,
	    					Libro.determinacionPagoCf()!=null?Libro.determinacionPagoCf().value():null,
	    					Libro.determinacionPagoCfIpn()!=null?Libro.determinacionPagoCfIpn().value():null,
	    					Libro.determinacionPagoCfOtras()!=null?Libro.determinacionPagoCfOtras().value():null,
	    					Libro.determinacionPagoSdCf()!=null?Libro.determinacionPagoSdCf().value():null,
	    					Libro.determinacionPago()!=null?Libro.determinacionPago().value():null,
	    					Libro.cantidadComprasNotas()!=null?Libro.cantidadComprasNotas().value():null,
	    					Libro.totalComprasNotas()!=null?Libro.totalComprasNotas().value():null,
	    					Libro.cantidadVentas()!=null?Libro.cantidadVentas().value():null,
	    					Libro.totalVentas()!=null?Libro.totalVentas().value():null,
	    					Libro.cantidadVentasCfElec()!=null?Libro.cantidadVentasCfElec().value():null,
	    					Libro.cantidadVentasCfOtras()!=null?Libro.cantidadVentasCfOtras().value():null,
	    					Libro.totalVentasCfElec()!=null?Libro.totalVentasCfElec().value():null,
	    					Libro.totalVentasCfOtras()!=null?Libro.totalVentasCfOtras().value():null,
	    					Libro.cantidadVentasSdCf()!=null?Libro.cantidadVentasSdCf().value():null,
	    					Libro.cantidadVentasSdCfOtras()!=null?Libro.cantidadVentasSdCfOtras().value():null,
	    					Libro.cantidadVentasSdCfSrg()!=null?Libro.cantidadVentasSdCfSrg().value():null,
	    					Libro.totalVentasSdCf()!=null?Libro.totalVentasSdCf().value():null,
	    					Libro.totalVentasSdCfOtras()!=null?Libro.totalVentasSdCfOtras().value():null,
	    					Libro.totalVentasSdCfSrg()!=null?Libro.totalVentasSdCfSrg().value():null,
	    					Libro.cantidadVentasNotas()!=null?Libro.cantidadVentasNotas().value():null,
	    					Libro.totalVentasNotas()!=null?Libro.totalVentasNotas().value():null,
	    					Libro.tipoPresentacionId()!=null?Libro.tipoPresentacionId().value():null,
	    					Libro.fechaPresentacion()!=null?Libro.fechaPresentacion().value():null,
	    					Libro.periodicidadId()!=null?Libro.periodicidadId().value():null,
	    					Libro.cantidadPeriodicidad()!=null?Libro.cantidadPeriodicidad().value():null,
	    					Libro.numeroOrden()!=null?Libro.numeroOrden().value():null,
	    					Libro.estadoLibroId()!=null?Libro.estadoLibroId().value():null,
	    					Libro.fechaEstado()!=null?Libro.fechaEstado().value():null,
	    					Libro.numeroEnvio()!=null?Libro.numeroEnvio().value():null,
	    					Libro.libroRectificadoId()!=null?Libro.libroRectificadoId().value():null,
	    					Libro.conMovimiento()!=null?Libro.conMovimiento().value():null,
	    					Libro.usuarioRegistro()!=null?Libro.usuarioRegistro().value():null,
	    					Libro.fechaRegistro()!=null?Libro.fechaRegistro().value():null,
	    					Libro.usuarioUltimaModificacion()!=null?Libro.usuarioUltimaModificacion().value():null,
	    					Libro.fechaUltimaModificacion()!=null?Libro.fechaUltimaModificacion().value():null,
	    					Libro.estadoId()!=null?Libro.estadoId().value():null,
	                Libro.compras()!=null?Libro.compras().stream().map(compraId -> compraId.value()).collect(Collectors.toList()):null,
	                Libro.comprasNotas()!=null? Libro.comprasNotas().stream().map(compraNotaId -> compraNotaId.value()).collect(Collectors.toList()):null
	        );

	    }
	
	public String id() {
		return id;
	}
	public Long nit() {
		return nit;
	}
	public Long ifc() {
		return ifc;
	}
	public String razonSocial() {
		return razonSocial;
	}
	public Integer mesPeriodo() {
		return mesPeriodo;
	}
	public Integer anioPeriodo() {
		return anioPeriodo;
	}
	public String nombreLibro() {
		return nombreLibro;
	}
	public Integer cantidadCompras() {
		return cantidadCompras;
	}
	public BigDecimal totalCompras() {
		return totalCompras;
	}
	public Integer cantidadVentas() {
		return cantidadVentas;
	}
	public BigDecimal totalVentas() {
		return totalVentas;
	}
	public String tipoPresentacionId() {
		return tipoPresentacionId;
	}
	public LocalDateTime fechaPresentacion() {
		return fechaPresentacion;
	}
	public String periodicidadId() {
		return periodicidadId;
	}
	public String cantidadPeriodicidad() {
		return cantidadPeriodicidad;
	}
	public Long numeroOrden() {
		return numeroOrden;
	}
	public String estadoLibroId() {
		return estadoLibroId;
	}
	public LocalDate fechaEstado() {
		return fechaEstado;
	}
	public Integer numeroEnvio() {
		return numeroEnvio;
	}
	public Long usuarioRegistro() {
		return usuarioRegistro;
	}
	public LocalDateTime fechaRegistro() {
		return fechaRegistro;
	}
	public Long usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}
	public LocalDateTime fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public String estadoId() {
		return estadoId;
	}
	public Long codAdministracion()
	{
	    return codAdministracion;
	}
	public String administracion()
	{
	    return administracion;
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
	public BigDecimal determinacionPago()
	{
	    return determinacionPago;
	}
	public Integer cantidadVentasCfElec()
	{
	    return cantidadVentasCfElec;
	}
	public Integer cantidadVentasCfOtras()
	{
	    return cantidadVentasCfOtras;
	}
	public BigDecimal totalVentasCfElec()
	{
	    return totalVentasCfElec;
	}
	public BigDecimal totalVentasCfOtras()
	{
	    return totalVentasCfOtras;
	}
	public Integer cantidadVentasSdCf()
	{
	    return cantidadVentasSdCf;
	}
	public Integer cantidadVentasSdCfOtras()
	{
	    return cantidadVentasSdCfOtras;
	}
	public Integer cantidadVentasSdCfSrg()
	{
	    return cantidadVentasSdCfSrg;
	}
	public BigDecimal totalVentasSdCf()
	{
	    return totalVentasSdCf;
	}
	public BigDecimal totalVentasSdCfOtras()
	{
	    return totalVentasSdCfOtras;
	}
	public BigDecimal totalVentasSdCfSrg()
	{
	    return totalVentasSdCfSrg;
	}
	public BigDecimal importeBaseCf()
	{
		return importeBaseCf;
	}
	public BigDecimal importeBaseCfElec()
	{
		return importeBaseCfElec;
	}
	public BigDecimal importeBaseCfIpn()
	{
		return importeBaseCfIpn;
	}
	public BigDecimal importeBaseCfOtras()
	{
		return importeBaseCfOtras;
	}
	
	
	
	public String getId() {
		return id;
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
	public LocalDateTime getFechaPresentacion() {
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

	public List<String> getComprasId() {
		return comprasId;
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
	    
    
    
    
}
