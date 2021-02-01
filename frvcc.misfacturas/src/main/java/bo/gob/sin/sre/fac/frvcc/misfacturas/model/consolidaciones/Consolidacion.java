package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.consolidaciones.ConsolidacionRealizadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioActulizarImporteCompraSelecionadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public final class Consolidacion extends AggregateRoot {

	private final ConsolidacionId id;

	private ConsolidacionIfcAgente ifcAgente;
	private ConsolidacionNitAgente nitAgente;
	private ConsolidacionRazonSocialAgente razonSocialAgente;
	private ConsolidacionSucursal sucursal;
	private ConsolidacionDireccionSucursal direccionSucursal;
	private ConsolidacionDepartamentoSucursal departamentoSucursal;
	private ConsolidacionAdministracion administracion;
	private ConsolidacionGestion gestion;
	private ConsolidacionPeriodo periodo;
	private ConsolidacionCantidadFormularios cantidadFormularios;
	private ConsolidacionTotalCantidadFacturas totalCantidadFacturas;
	private ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas;
	private ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas;
	private ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas;
	private ConsolidacionTotalImporteFacturas totalImporteFacturas;
	private ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas;
	private ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas;
	private ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas;
	private ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta;
	private ConsolidacionTotalPagoCuenta totalPagoCuenta;
	private ConsolidacionEstadoConsolidadoId estadoConsolidadoId;
	private ConsolidacionFechaConsolidado fechaConsolidado;
	private ConsolidacionUsuarioConsolidador usuarioConsolidador;
	private ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador;
	private ConsolidacionNombreConsolidador nombreConsolidador;
	private ConsolidacionUsuarioRegistro usuarioRegistro;
	private ConsolidacionFechaRegistro  fechaRegistro;
	private ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion;
	private ConsolidacionFechaUltimaModificacion fechaUltimaModificacion;
	private ConsolidacionEstadoId estadoId;
	private ConsolidacionTipoId tipoId;
	private ConsolidacionIdConsolidacionPrincipal consolidacionPrincipalId;
	private List<FormularioId> formularios;
	public Consolidacion(){
		this.id=null;
	}

	public Consolidacion(ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente, ConsolidacionRazonSocialAgente razonSocialAgente,
						 ConsolidacionSucursal sucursal, ConsolidacionDireccionSucursal direccionSucursal, ConsolidacionDepartamentoSucursal departamentoSucursal,
						 ConsolidacionAdministracion administracion, ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
						 ConsolidacionCantidadFormularios cantidadFormularios, ConsolidacionTotalCantidadFacturas totalCantidadFacturas,
						 ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas, ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas,
						 ConsolidacionTotalImporteFacturas totalImporteFacturas, ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas,
						 ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas, ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta,
						 ConsolidacionTotalPagoCuenta totalPagoCuenta, ConsolidacionEstadoConsolidadoId estadoConsolidadoId,
						 ConsolidacionFechaConsolidado fechaConsolidado, ConsolidacionUsuarioConsolidador usuarioConsolidador,
						 ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador, ConsolidacionNombreConsolidador nombreConsolidador,
						 ConsolidacionUsuarioRegistro usuarioRegistro, ConsolidacionFechaRegistro fechaRegistro,
						 ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion, ConsolidacionFechaUltimaModificacion fechaUltimaModificacion,
						 ConsolidacionEstadoId estadoId,ConsolidacionTipoId tipoId,ConsolidacionIdConsolidacionPrincipal consolidacionPrincipalId,List<FormularioId> formularios,
						 ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas,ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas) {
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
	public static Consolidacion registro(ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
										 ConsolidacionRazonSocialAgente razonSocialAgente,
										 ConsolidacionSucursal sucursal, ConsolidacionDireccionSucursal direccionSucursal,
										 ConsolidacionDepartamentoSucursal departamentoSucursal,ConsolidacionAdministracion administracion,
										 ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
										 ConsolidacionCantidadFormularios cantidadFormularios,ConsolidacionTotalCantidadFacturas totalCantidadFacturas,
										 ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas,ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas,
										 ConsolidacionTotalImporteFacturas totalImporteFacturas,ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas,
										 ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas,ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta,
										 ConsolidacionTotalPagoCuenta totalPagoCuenta,ConsolidacionUsuarioConsolidador usuarioConsolidador,
										 ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador,ConsolidacionNombreConsolidador	 nombreConsolidador,
										 ConsolidacionUsuarioRegistro usuarioRegistro, ConsolidacionTipoId tipoId,
										 ConsolidacionIdConsolidacionPrincipal consolidacionPrincipalId,List<FormularioId> formularios,
										 ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas,ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas


	) {

		ConsolidacionEstadoConsolidadoId estadoConsolidadoId=new ConsolidacionEstadoConsolidadoId("AC");

		ConsolidacionFechaRegistro  fechaRegistro=new ConsolidacionFechaRegistro(LocalDateTime.now());
		ConsolidacionFechaUltimaModificacion  fechaUltimaModificacion=new ConsolidacionFechaUltimaModificacion(LocalDateTime.now());
		ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion=new ConsolidacionUsuarioUltimaModificacion(usuarioRegistro.value());
		ConsolidacionEstadoId estadoId=new ConsolidacionEstadoId("AC");
		ConsolidacionFechaConsolidado fechaConsolidado=new ConsolidacionFechaConsolidado(LocalDateTime.now());
		Consolidacion consolidador= new Consolidacion(id, ifcAgente,
				nitAgente, razonSocialAgente,
				sucursal, direccionSucursal,
				 departamentoSucursal,  administracion,
				 gestion,  periodo,  cantidadFormularios,
				totalCantidadFacturas,  totalCantidadOtrasFacturas,
				 totalCantidad7rgFacturas,  totalImporteFacturas,
				 totalImporteOtrasFacturas,  totalImporte7rgFacturas,
				 totalDeterminacionPagoCuenta,  totalPagoCuenta,
				 estadoConsolidadoId,  fechaConsolidado,
				 usuarioConsolidador,  loginUsuarioConsolidador,
				 nombreConsolidador,  usuarioRegistro,
				 fechaRegistro,  usuarioUltimaModificacion,
				 fechaUltimaModificacion, estadoId,tipoId,consolidacionPrincipalId,formularios,
				totalCantidadIpnFacturas,totalImporteIpnFacturas) ;

		return consolidador;
	}
	public Consolidacion registroPrincipal(ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
										 ConsolidacionRazonSocialAgente razonSocialAgente,
										 ConsolidacionSucursal sucursal, ConsolidacionDireccionSucursal direccionSucursal,
										 ConsolidacionDepartamentoSucursal departamentoSucursal,ConsolidacionAdministracion administracion,
										 ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
										 ConsolidacionCantidadFormularios cantidadFormularios,ConsolidacionTotalCantidadFacturas totalCantidadFacturas,
										 ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas,ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas,
										 ConsolidacionTotalImporteFacturas totalImporteFacturas,ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas,
										 ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas,ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta,
										 ConsolidacionTotalPagoCuenta totalPagoCuenta,ConsolidacionUsuarioConsolidador usuarioConsolidador,
										 ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador,ConsolidacionNombreConsolidador	 nombreConsolidador,
										 ConsolidacionUsuarioRegistro usuarioRegistro, ConsolidacionTipoId tipoId,
										 ConsolidacionIdConsolidacionPrincipal consolidacionPrincipalId,List<FormularioId> formularios,
										   ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas,ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas

	) {

		ConsolidacionEstadoConsolidadoId estadoConsolidadoId=new ConsolidacionEstadoConsolidadoId("AC");

		ConsolidacionFechaRegistro  fechaRegistro=new ConsolidacionFechaRegistro(LocalDateTime.now());
		ConsolidacionFechaUltimaModificacion  fechaUltimaModificacion=new ConsolidacionFechaUltimaModificacion(LocalDateTime.now());
		ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion=new ConsolidacionUsuarioUltimaModificacion(usuarioRegistro.value());
		ConsolidacionEstadoId estadoId=new ConsolidacionEstadoId("AC");
		ConsolidacionFechaConsolidado fechaConsolidado=new ConsolidacionFechaConsolidado(LocalDateTime.now());
		Consolidacion consolidador= new Consolidacion(id, ifcAgente,
				nitAgente, razonSocialAgente,
				sucursal, direccionSucursal,
				departamentoSucursal,  administracion,
				gestion,  periodo,  cantidadFormularios,
				totalCantidadFacturas,  totalCantidadOtrasFacturas,
				totalCantidad7rgFacturas,  totalImporteFacturas,
				totalImporteOtrasFacturas,  totalImporte7rgFacturas,
				totalDeterminacionPagoCuenta,  totalPagoCuenta,
				estadoConsolidadoId,  fechaConsolidado,
				usuarioConsolidador,  loginUsuarioConsolidador,
				nombreConsolidador,  usuarioRegistro,
				fechaRegistro,  usuarioUltimaModificacion,
				fechaUltimaModificacion, estadoId,tipoId,consolidacionPrincipalId,formularios,
				totalCantidadIpnFacturas,totalImporteIpnFacturas) ;

		consolidador.record(new ConsolidacionRealizadaDomainEvent(id.value(),
				ifcAgente.value(),
				nitAgente.value(),
				razonSocialAgente.value(),
				sucursal.value(),
				direccionSucursal.value(),
				departamentoSucursal.value(),
				administracion.value(),
				gestion.value(),
				periodo.value(),
				cantidadFormularios.value(),
				totalCantidadFacturas.value(),
				totalCantidadOtrasFacturas.value(),
				totalCantidad7rgFacturas.value(),
				totalImporteFacturas.value(),
				totalImporteOtrasFacturas.value(),
				totalImporte7rgFacturas.value(),
				totalDeterminacionPagoCuenta.value(),
				totalPagoCuenta.value(),
				estadoConsolidadoId.value(),
				fechaConsolidado.value(),
				usuarioConsolidador.value(),
				loginUsuarioConsolidador.value(),
				nombreConsolidador.value(),
				usuarioRegistro.value(),
				fechaRegistro.value(),
				usuarioUltimaModificacion.value(),
				fechaUltimaModificacion.value(),
				estadoId.value(),
				tipoId.value(),
				consolidacionPrincipalId.value(),
				formularios.stream().map(x -> x.value()).collect(Collectors.toList())

		));

		return consolidador;
	}
	public ConsolidacionId id() {
		return id;
	}

	public ConsolidacionIfcAgente ifcAgente() {
		return ifcAgente;
	}

	public ConsolidacionNitAgente nitAgente() {
		return nitAgente;
	}

	public ConsolidacionRazonSocialAgente razonSocialAgente() {
		return razonSocialAgente;
	}

	public ConsolidacionSucursal sucursal() {
		return sucursal;
	}

	public ConsolidacionDireccionSucursal direccionSucursal() {
		return direccionSucursal;
	}

	public ConsolidacionDepartamentoSucursal departamentoSucursal() {
		return departamentoSucursal;
	}

	public ConsolidacionAdministracion administracion() {
		return administracion;
	}

	public ConsolidacionGestion gestion() {
		return gestion;
	}

	public ConsolidacionPeriodo periodo() {
		return periodo;
	}

	public ConsolidacionCantidadFormularios cantidadFormularios() {
		return cantidadFormularios;
	}

	public ConsolidacionTotalCantidadFacturas totalCantidadFacturas() {
		return totalCantidadFacturas;
	}

	public ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas() {
		return totalCantidadOtrasFacturas;
	}

	public ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas() {
		return totalCantidad7rgFacturas;
	}

	public ConsolidacionTotalImporteFacturas totalImporteFacturas() {
		return totalImporteFacturas;
	}

	public ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas() {
		return totalImporteOtrasFacturas;
	}

	public ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas() {
		return totalImporte7rgFacturas;
	}

	public ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta() {
		return totalDeterminacionPagoCuenta;
	}

	public ConsolidacionTotalPagoCuenta totalPagoCuenta() {
		return totalPagoCuenta;
	}

	public ConsolidacionEstadoConsolidadoId estadoConsolidadoId() {
		return estadoConsolidadoId;
	}

	public ConsolidacionFechaConsolidado fechaConsolidado() {
		return fechaConsolidado;
	}

	public ConsolidacionUsuarioConsolidador usuarioConsolidador() {
		return usuarioConsolidador;
	}

	public ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador() {
		return loginUsuarioConsolidador;
	}

	public ConsolidacionNombreConsolidador nombreConsolidador() {
		return nombreConsolidador;
	}

	public ConsolidacionUsuarioRegistro usuarioRegistro() {
		return usuarioRegistro;
	}

	public ConsolidacionFechaRegistro fechaRegistro() {
		return fechaRegistro;
	}

	public ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public ConsolidacionFechaUltimaModificacion fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas()
	{
		return totalCantidadIpnFacturas;
	}
	public ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas()
	{
		return totalImporteIpnFacturas;
	}

	public ConsolidacionEstadoId estadoId() {
		return estadoId;
	}
	public ConsolidacionTipoId tipoId(){return tipoId;}
	public ConsolidacionIdConsolidacionPrincipal consolidacionPrincipalId(){return consolidacionPrincipalId;}
	public List<FormularioId> formularios() {	return formularios;	}

	public static Consolidacion.Builder newConsolidacion() {
		return new Consolidacion.Builder();
	}
	public Consolidacion(Consolidacion.Builder builder) {
		super();
		this.id = builder.id;
		this.ifcAgente = builder.ifcAgente;
		this.nitAgente = builder.nitAgente;
		this.razonSocialAgente = builder.razonSocialAgente;
		this.sucursal = builder.sucursal;
		this.direccionSucursal = builder.direccionSucursal;
		this.departamentoSucursal = builder.departamentoSucursal;
		this.administracion = builder.administracion;
		this.gestion = builder.gestion;
		this.periodo = builder.periodo;
		this.cantidadFormularios = builder.cantidadFormularios;
		this.totalCantidadFacturas = builder.totalCantidadFacturas;
		this.totalCantidadOtrasFacturas = builder.totalCantidadOtrasFacturas;
		this.totalCantidad7rgFacturas = builder.totalCantidad7rgFacturas;
		this.totalImporteFacturas = builder.totalImporteFacturas;
		this.totalImporteOtrasFacturas = builder.totalImporteOtrasFacturas;
		this.totalImporte7rgFacturas = builder.totalImporte7rgFacturas;
		this.totalDeterminacionPagoCuenta = builder.totalDeterminacionPagoCuenta;
		this.totalPagoCuenta = builder.totalPagoCuenta;
		this.estadoConsolidadoId = builder.estadoConsolidadoId;
		this.fechaConsolidado = builder.fechaConsolidado;
		this.usuarioConsolidador = builder.usuarioConsolidador;
		this.loginUsuarioConsolidador = builder.loginUsuarioConsolidador;
		this.nombreConsolidador = builder.nombreConsolidador;
		this.usuarioRegistro = builder.usuarioRegistro;
		this.fechaRegistro = builder.fechaRegistro;
		this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
		this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
		this.estadoId = builder.estadoId;
		this.tipoId=builder.tipoId;
		this.consolidacionPrincipalId=builder.consolidacionPrincipalId;
		this.formularios=builder.formularios;
		this.totalCantidadIpnFacturas=builder.totalCantidadIpnFacturas;
		this.totalImporteIpnFacturas=builder.totalImporteIpnFacturas;
	}
	public static final class Builder {
		private ConsolidacionId id;
		private ConsolidacionIfcAgente ifcAgente;
		private ConsolidacionNitAgente nitAgente;
		private ConsolidacionRazonSocialAgente razonSocialAgente;
		private ConsolidacionSucursal sucursal;
		private ConsolidacionDireccionSucursal direccionSucursal;
		private ConsolidacionDepartamentoSucursal departamentoSucursal;
		private ConsolidacionAdministracion administracion;
		private ConsolidacionGestion gestion;
		private ConsolidacionPeriodo periodo;
		private ConsolidacionCantidadFormularios cantidadFormularios;
		private ConsolidacionTotalCantidadFacturas totalCantidadFacturas;
		private ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas;
		private ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas;
		private ConsolidacionTotalImporteFacturas totalImporteFacturas;
		private ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas;
		private ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas;
		private ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta;
		private ConsolidacionTotalPagoCuenta totalPagoCuenta;
		private ConsolidacionEstadoConsolidadoId estadoConsolidadoId;
		private ConsolidacionFechaConsolidado fechaConsolidado;
		private ConsolidacionUsuarioConsolidador usuarioConsolidador;
		private ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador;
		private ConsolidacionNombreConsolidador nombreConsolidador;
		private ConsolidacionUsuarioRegistro usuarioRegistro;
		private ConsolidacionFechaRegistro fechaRegistro;
		private ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion;
		private ConsolidacionFechaUltimaModificacion fechaUltimaModificacion;
		private ConsolidacionEstadoId estadoId;
		private ConsolidacionTipoId tipoId;
		private ConsolidacionIdConsolidacionPrincipal consolidacionPrincipalId;
		private List<FormularioId> formularios;
		private ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas;
		private ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas;

		private Builder() {
		}

		public Consolidacion build() {
			return new Consolidacion(this);
		}

		public Builder id(ConsolidacionId id) {
			this.id = id;
			return this;
		}

		public Builder ifcAgente(ConsolidacionIfcAgente ifcAgente) {
			this.ifcAgente = ifcAgente;
			return this;
		}

		public Builder nitAgente(ConsolidacionNitAgente nitAgente) {
			this.nitAgente = nitAgente;
			return this;
		}

		public Builder razonSocialAgente(ConsolidacionRazonSocialAgente razonSocialAgente) {
			this.razonSocialAgente = razonSocialAgente;
			return this;
		}

		public Builder sucursal(ConsolidacionSucursal sucursal) {
			this.sucursal = sucursal;
			return this;
		}

		public Builder direccionSucursal(ConsolidacionDireccionSucursal direccionSucursal) {
			this.direccionSucursal = direccionSucursal;
			return this;
		}

		public Builder departamentoSucursal(ConsolidacionDepartamentoSucursal departamentoSucursal) {
			this.departamentoSucursal = departamentoSucursal;
			return this;
		}

		public Builder administracion(ConsolidacionAdministracion administracion) {
			this.administracion = administracion;
			return this;
		}

		public Builder gestion(ConsolidacionGestion gestion) {
			this.gestion = gestion;
			return this;
		}

		public Builder periodo(ConsolidacionPeriodo periodo) {
			this.periodo = periodo;
			return this;
		}

		public Builder cantidadFormularios(ConsolidacionCantidadFormularios cantidadFormularios) {
			this.cantidadFormularios = cantidadFormularios;
			return this;
		}

		public Builder totalCantidadFacturas(ConsolidacionTotalCantidadFacturas totalCantidadFacturas) {
			this.totalCantidadFacturas = totalCantidadFacturas;
			return this;
		}

		public Builder totalCantidadOtrasFacturas(ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas) {
			this.totalCantidadOtrasFacturas = totalCantidadOtrasFacturas;
			return this;
		}

		public Builder totalCantidad7rgFacturas(ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas) {
			this.totalCantidad7rgFacturas = totalCantidad7rgFacturas;
			return this;
		}

		public Builder totalImporteFacturas(ConsolidacionTotalImporteFacturas totalImporteFacturas) {
			this.totalImporteFacturas = totalImporteFacturas;
			return this;
		}

		public Builder totalImporteOtrasFacturas(ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas) {
			this.totalImporteOtrasFacturas = totalImporteOtrasFacturas;
			return this;
		}

		public Builder totalImporte7rgFacturas(ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas) {
			this.totalImporte7rgFacturas = totalImporte7rgFacturas;
			return this;
		}

		public Builder totalDeterminacionPagoCuenta(ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta) {
			this.totalDeterminacionPagoCuenta = totalDeterminacionPagoCuenta;
			return this;
		}

		public Builder totalPagoCuenta(ConsolidacionTotalPagoCuenta totalPagoCuenta) {
			this.totalPagoCuenta = totalPagoCuenta;
			return this;
		}

		public Builder estadoConsolidadoId(ConsolidacionEstadoConsolidadoId estadoConsolidadoId) {
			this.estadoConsolidadoId = estadoConsolidadoId;
			return this;
		}

		public Builder fechaConsolidado(ConsolidacionFechaConsolidado fechaConsolidado) {
			this.fechaConsolidado = fechaConsolidado;
			return this;
		}

		public Builder usuarioConsolidador(ConsolidacionUsuarioConsolidador usuarioConsolidador) {
			this.usuarioConsolidador = usuarioConsolidador;
			return this;
		}

		public Builder loginUsuarioConsolidador(ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador) {
			this.loginUsuarioConsolidador = loginUsuarioConsolidador;
			return this;
		}

		public Builder nombreConsolidador(ConsolidacionNombreConsolidador nombreConsolidador) {
			this.nombreConsolidador = nombreConsolidador;
			return this;
		}

		public Builder usuarioRegistro(ConsolidacionUsuarioRegistro usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder fechaRegistro(ConsolidacionFechaRegistro fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public Builder usuarioUltimaModificacion(ConsolidacionUsuarioUltimaModificacion usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public Builder fechaUltimaModificacion(ConsolidacionFechaUltimaModificacion fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public Builder estadoId(ConsolidacionEstadoId estadoId) {
			this.estadoId = estadoId;
			return this;
		}
		public Builder tipoId(ConsolidacionTipoId tipoId) {
			this.tipoId = tipoId;
			return this;
		}
		public Builder consolidacionPrincipalId(ConsolidacionIdConsolidacionPrincipal  consolidacionPrincipalId)
		{
			this.consolidacionPrincipalId=consolidacionPrincipalId;
			return this;
		}
		public Builder formularios(List<FormularioId> formularios) {
			this.formularios = formularios;
			return this;
		}
		public Builder totalCantidadIpnFacturas(ConsolidacionTotalCantidadIpnFacturas totalCantidadIpnFacturas)
		{
			this.totalCantidadIpnFacturas=totalCantidadIpnFacturas;
			return this;
		}
		public Builder totalImporteIpnFacturas(ConsolidacionTotalImporteIpnFacturas totalImporteIpnFacturas)
		{
			this.totalImporteIpnFacturas=totalImporteIpnFacturas;
			return this;
		}
	}
}
