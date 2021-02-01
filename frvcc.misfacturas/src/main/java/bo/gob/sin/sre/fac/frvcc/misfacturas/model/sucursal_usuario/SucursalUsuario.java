package bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.str.constantes.estado.ConstEstado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SucursalUsuario extends AggregateRoot {
    private final SucursalUsuarioId id;
    private SucursalUsuarioIfcAgente ifcAgente;
    private SucursalUsuarioNitAgente nitAgente;
    private SucursalUsuarioNumeroSucursal nroSucursal;
    private SucursalUsuarioUsuarioReceptor usuarioReceptor;
    private SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor;
    private SucursalUsuarioNombreReceptor nombreUsuarioReceptor;
    private SucursalUsuarioEstadoAsignacion estadoAsignacionId;
    private SucursalUsuarioFechaDesde fechaDesde;
    private SucursalUsuarioFechaHasta fechaHasta;
    private SucursalUsuarioUsuarioRegistro usuarioRegistro;
    private SucursalUsuarioFechaRegistro fechaRegistro;
    private SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion;
    private SucursalUsuarioFechaUltimaModificacion fechaUltimaModificacion;
    private SucursalUsuarioEstadoId estadoId;

    public SucursalUsuario(SucursalUsuarioId id, SucursalUsuarioIfcAgente ifcAgente, SucursalUsuarioNitAgente nitAgente, SucursalUsuarioNumeroSucursal nroSucursal, SucursalUsuarioUsuarioReceptor usuarioReceptor, SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor, SucursalUsuarioNombreReceptor nombreUsuarioReceptor, SucursalUsuarioEstadoAsignacion estadoAsignacionId, SucursalUsuarioFechaDesde fechaDesde, SucursalUsuarioFechaHasta fechaHasta, SucursalUsuarioUsuarioRegistro usuarioRegistro, SucursalUsuarioFechaRegistro fechaRegistro, SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion, SucursalUsuarioFechaUltimaModificacion fechaUltimaModificacion, SucursalUsuarioEstadoId estadoId) {
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

    public SucursalUsuario() {
        this.id=null;
    }


    public static SucursalUsuario registro(SucursalUsuarioId id, SucursalUsuarioIfcAgente ifcAgente, SucursalUsuarioNitAgente nitAgente,
                                           SucursalUsuarioNumeroSucursal nroSucursal, SucursalUsuarioUsuarioReceptor usuarioReceptor,
                                           SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor, SucursalUsuarioNombreReceptor nombreUsuarioReceptor,
                                           SucursalUsuarioUsuarioRegistro usuarioRegistro,
                                           SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion
										   ) {

		SucursalUsuarioEstadoAsignacion estadoAsignacionId=new SucursalUsuarioEstadoAsignacion("AC");
		SucursalUsuarioFechaDesde fechaDesde=new SucursalUsuarioFechaDesde(LocalDate.now());
		SucursalUsuarioFechaHasta fechaHasta=new SucursalUsuarioFechaHasta(null);
		SucursalUsuarioFechaRegistro  fechaRegistro=new SucursalUsuarioFechaRegistro(LocalDateTime.now());
		SucursalUsuarioFechaUltimaModificacion  fechaUltimaModificacion=new SucursalUsuarioFechaUltimaModificacion(LocalDateTime.now());
		SucursalUsuarioEstadoId estadoId=new SucursalUsuarioEstadoId("AC");

		SucursalUsuario vSucursalUsuario=newSucursalUsuario().id(id).ifcAgente(ifcAgente).nitAgente(nitAgente).nroSucursal(nroSucursal)
				.usuarioReceptor(usuarioReceptor).loginUsuarioReceptor(loginUsuarioReceptor).nombreUsuarioReceptor(nombreUsuarioReceptor)
				.estadoAsignacionId(estadoAsignacionId).fechaDesde(fechaDesde).fechaHasta(fechaHasta).usuarioRegistro(usuarioRegistro)
				.fechaRegistro(fechaRegistro).usuarioUltimaModificacion(usuarioUltimaModificacion).fechaUltimaModificacion(fechaUltimaModificacion)
				.estadoId(estadoId).build();

		return vSucursalUsuario;
    }
    public void inhabilitar(SucursalUsuarioUsuarioUltimaModificacion pUsuarioUltimaModificacion)
    {
        this.estadoAsignacionId=new SucursalUsuarioEstadoAsignacion("IN");
        this.fechaHasta=new SucursalUsuarioFechaHasta(LocalDate.now());
        this.usuarioUltimaModificacion=pUsuarioUltimaModificacion;
    }

    public SucursalUsuario(Builder builder) {
        super();
        this.id = builder.id;
        this.ifcAgente = builder.ifcAgente;
        this.nitAgente = builder.nitAgente;
        this.nroSucursal = builder.nroSucursal;
        this.usuarioReceptor = builder.usuarioReceptor;
        this.loginUsuarioReceptor = builder.loginUsuarioReceptor;
        this.nombreUsuarioReceptor = builder.nombreUsuarioReceptor;
        this.estadoAsignacionId = builder.estadoAsignacionId;
        this.fechaDesde = builder.fechaDesde;
        this.fechaHasta = builder.fechaHasta;
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
    }
	public static SucursalUsuario.Builder newSucursalUsuario() {
		return new SucursalUsuario.Builder();
	}
    public SucursalUsuarioId id() {
        return id;
    }

    public SucursalUsuarioIfcAgente ifcAgente() {
        return ifcAgente;
    }

    public SucursalUsuarioNitAgente nitAgente() {
        return nitAgente;
    }

    public SucursalUsuarioNumeroSucursal nroSucursal() {
        return nroSucursal;
    }

    public SucursalUsuarioUsuarioReceptor usuarioReceptor() {
        return usuarioReceptor;
    }

    public SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor() {
        return loginUsuarioReceptor;
    }

    public SucursalUsuarioNombreReceptor nombreUsuarioReceptor() {
        return nombreUsuarioReceptor;
    }

    public SucursalUsuarioEstadoAsignacion estadoAsignacionId() {
        return estadoAsignacionId;
    }

    public SucursalUsuarioFechaDesde fechaDesde() {
        return fechaDesde;
    }

    public SucursalUsuarioFechaHasta fechaHasta() {
        return fechaHasta;
    }

    public SucursalUsuarioUsuarioRegistro usuarioRegistro() {
        return usuarioRegistro;
    }

    public SucursalUsuarioFechaRegistro fechaRegistro() {
        return fechaRegistro;
    }

    public SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public SucursalUsuarioFechaUltimaModificacion fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public SucursalUsuarioEstadoId estadoId() {
        return estadoId;
    }

    public static final class Builder {
        private SucursalUsuarioId id;
        private SucursalUsuarioIfcAgente ifcAgente;
        private SucursalUsuarioNitAgente nitAgente;
        private SucursalUsuarioNumeroSucursal nroSucursal;
        private SucursalUsuarioUsuarioReceptor usuarioReceptor;
        private SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor;
        private SucursalUsuarioNombreReceptor nombreUsuarioReceptor;
        private SucursalUsuarioEstadoAsignacion estadoAsignacionId;
        private SucursalUsuarioFechaDesde fechaDesde;
        private SucursalUsuarioFechaHasta fechaHasta;
        private SucursalUsuarioUsuarioRegistro usuarioRegistro;
        private SucursalUsuarioFechaRegistro fechaRegistro;
        private SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion;
        private SucursalUsuarioFechaUltimaModificacion fechaUltimaModificacion;
        private SucursalUsuarioEstadoId estadoId;

        private Builder() {
        }

        public SucursalUsuario build() {
            return new SucursalUsuario(this);
        }

        public Builder id(SucursalUsuarioId id) {
            this.id = id;
            return this;
        }

        public Builder ifcAgente(SucursalUsuarioIfcAgente ifcAgente) {
            this.ifcAgente = ifcAgente;
            return this;
        }

        public Builder nitAgente(SucursalUsuarioNitAgente nitAgente) {

        	this.nitAgente = nitAgente;
        	return this;
        }

        public Builder nroSucursal(SucursalUsuarioNumeroSucursal nroSucursal) {
            this.nroSucursal = nroSucursal;
            return this;
        }

        public Builder usuarioReceptor(SucursalUsuarioUsuarioReceptor usuarioReceptor) {
            this.usuarioReceptor = usuarioReceptor;
            return this;
        }

        public Builder loginUsuarioReceptor(SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor) {
            this.loginUsuarioReceptor = loginUsuarioReceptor;
            return this;
        }

        public Builder nombreUsuarioReceptor(SucursalUsuarioNombreReceptor nombreUsuarioReceptor) {
            this.nombreUsuarioReceptor = nombreUsuarioReceptor;
            return this;
        }

        public Builder estadoAsignacionId(SucursalUsuarioEstadoAsignacion estadoAsignacionId) {
            this.estadoAsignacionId = estadoAsignacionId;
            return this;
        }

        public Builder fechaDesde(SucursalUsuarioFechaDesde fechaDesde) {
            this.fechaDesde = fechaDesde;
            return this;
        }

        public Builder fechaHasta(SucursalUsuarioFechaHasta fechaHasta) {
            this.fechaHasta = fechaHasta;
            return this;
        }

        public Builder usuarioRegistro(SucursalUsuarioUsuarioRegistro usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }

        public Builder fechaRegistro(SucursalUsuarioFechaRegistro fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Builder usuarioUltimaModificacion(SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion) {
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            return this;
        }

        public Builder fechaUltimaModificacion(SucursalUsuarioFechaUltimaModificacion fechaUltimaModificacion) {
            this.fechaUltimaModificacion = fechaUltimaModificacion;
            return this;
        }

        public Builder estadoId(SucursalUsuarioEstadoId estadoId) {
            this.estadoId = estadoId;
            return this;
        }

    }
}
