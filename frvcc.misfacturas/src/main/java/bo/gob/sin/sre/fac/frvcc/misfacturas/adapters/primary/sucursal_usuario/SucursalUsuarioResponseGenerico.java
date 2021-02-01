package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioEstadoAsignacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioEstadoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioFechaDesde;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioFechaHasta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioFechaRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioFechaUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioIfcAgente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioLoginUsuarioReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioNitAgente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioNombreReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioNumeroSucursal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioReceptor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class SucursalUsuarioResponseGenerico implements Serializable, Cloneable {

	private String id;
	private Long ifcAgente;
	private Long nitAgente;
	private Integer nroSucursal;
	private Long usuarioReceptor;
	private String loginUsuarioReceptor;
	private String nombreUsuarioReceptor;
	private String estadoAsignacionId;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private Long usuarioRegistro;
	private LocalDateTime fechaRegistro;
	private Long usuarioUltimaModificacion;
	private LocalDateTime fechaUltimaModificacion;
	private String estadoId;

	public void setId(String id) {
		this.id = id;
	}

	

public SucursalUsuarioResponseGenerico(String id, Long ifcAgente, Long nitAgente, Integer nroSucursal,
			Long usuarioReceptor, String loginUsuarioReceptor, String nombreUsuarioReceptor, String estadoAsignacionId,
			LocalDate fechaDesde, LocalDate fechaHasta, Long usuarioRegistro, LocalDateTime fechaRegistro,
			Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId) {
		super();
		this.id = id;
		this.ifcAgente = ifcAgente;
		this.nitAgente = nitAgente;
		this.nroSucursal = nroSucursal;
		this.usuarioReceptor = usuarioReceptor;
		this.loginUsuarioReceptor = loginUsuarioReceptor;
		this.nombreUsuarioReceptor = nombreUsuarioReceptor;
		this.estadoAsignacionId = estadoAsignacionId;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estadoId = estadoId;
	}



    public static SucursalUsuarioResponseGenerico fromAggregate(SucursalUsuario sucursalUsuario) {
        SucursalUsuarioResponseGenerico sucursalUsuarioResponseGenerico = new SucursalUsuarioResponseGenerico(
        		sucursalUsuario.id() != null ? sucursalUsuario.id().value() : null,
                sucursalUsuario.ifcAgente() != null ? sucursalUsuario.ifcAgente().value() : null,
                sucursalUsuario.nitAgente() != null ? sucursalUsuario.nitAgente().value() : null,
                sucursalUsuario.nroSucursal()!=null? sucursalUsuario.nroSucursal().value() : null,
                sucursalUsuario.usuarioReceptor()!=null? sucursalUsuario.usuarioReceptor().value() : null,
                sucursalUsuario.loginUsuarioReceptor()!=null? sucursalUsuario.loginUsuarioReceptor().value() : null,
                sucursalUsuario.nombreUsuarioReceptor()!=null? sucursalUsuario.nombreUsuarioReceptor().value() : null,
                sucursalUsuario.estadoAsignacionId()!=null? sucursalUsuario.estadoAsignacionId().value() : null,
                sucursalUsuario.fechaDesde()!=null? sucursalUsuario.fechaDesde().value() : null,
                sucursalUsuario.fechaHasta()!=null? sucursalUsuario.fechaHasta().value() : null,
                sucursalUsuario.usuarioRegistro() != null ? sucursalUsuario.usuarioRegistro().value() : null,
                sucursalUsuario.fechaRegistro() != null ? sucursalUsuario.fechaRegistro().value() : null,
                sucursalUsuario.usuarioUltimaModificacion() != null ? sucursalUsuario.usuarioUltimaModificacion().value() : null,
                sucursalUsuario.fechaUltimaModificacion() != null ? sucursalUsuario.fechaUltimaModificacion().value() : null,
                sucursalUsuario.estadoId() != null ? sucursalUsuario.estadoId().value() : null
                );
        return sucursalUsuarioResponseGenerico;

    }

	public SucursalUsuarioResponseGenerico() {
		this.id = null;
		this.ifcAgente = null;
		this.nitAgente = null;
		this.nroSucursal = null;
		this.usuarioReceptor = null;
		this.loginUsuarioReceptor = null;
		this.nombreUsuarioReceptor = null;
		this.estadoAsignacionId = null;
		this.fechaDesde = null;
		this.fechaHasta = null;
		this.usuarioRegistro = null;
		this.fechaRegistro = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
		this.estadoId = null;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Long getIfcAgente() {
		return ifcAgente;
	}

	public void setIfcAgente(Long ifcAgente) {
		this.ifcAgente = ifcAgente;
	}

	public Long getNitAgente() {
		return nitAgente;
	}

	public void setNitAgente(Long nitAgente) {
		this.nitAgente = nitAgente;
	}

	public Integer getNroSucursal() {
		return nroSucursal;
	}

	public void setNroSucursal(Integer nroSucursal) {
		this.nroSucursal = nroSucursal;
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

	public String getNombreUsuarioReceptor() {
		return nombreUsuarioReceptor;
	}

	public void setNombreUsuarioReceptor(String nombreUsuarioReceptor) {
		this.nombreUsuarioReceptor = nombreUsuarioReceptor;
	}

	public String getEstadoAsignacionId() {
		return estadoAsignacionId;
	}

	public void setEstadoAsignacionId(String estadoAsignacionId) {
		this.estadoAsignacionId = estadoAsignacionId;
	}

	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(Long usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public void setUsuarioUltimaModificacion(Long usuarioUltimaModificacion) {
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public String getId() {
		return id;
	}

}
