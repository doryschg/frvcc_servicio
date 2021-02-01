package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.shared.domain.libros.LibroRegistradoDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.EstadoformularioId;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDecrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroDecrementadoImporteNotasDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroIncrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroIncrementadoImporteNotasDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroRectificadoDeclaradoCompraDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.domain.libros.LibroRectificadoDeclaradoNotaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;

public final class Libro extends AggregateRoot {
	private final LibroId id;
	private LibroNit nit;
	private LibroIfc ifc;
	private LibroRazonSocial razonSocial;
	private LibroCodigoAdministracion codAdministracion;
	private LibroAdministracion administracion;
	private LibroMesPeriodo mesPeriodo;
	private LibroAnioPeriodo anioPeriodo;
	private LibroNombreLibro nombreLibro;
	private LibroCantidadComprasCf cantidadCompras;
	private LibroTotalComprasCf totalCompras;
	private LibroCantidadComprasCfElec cantidadComprasCfElec;
	private LibroCantidadComprasCfIpn cantidadComprasCfIpn;
	private LibroCantidadComprasCfOtras cantidadComprasCfOtras;
	private LibroCantidadComprasSdCf cantidadComprasSdCf;
	private LibroTotalComprasCfElec totalComprasCfElec;
	private LibroTotalComprasCfIpn totalComprasCfIpn;
	private LibroTotalComprasCfOtras totalComprasCfOtras;
	private LibroTotalComprasSdCf totalComprasSdCf;
	private LibroImporteBaseComprasCf importeBaseCf;
	private LibroImporteBaseComprasCfElec importeBaseCfElec;
	private LibroImporteBaseComprasCfIpn importeBaseCfIpn;
	private LibroImporteBaseComprasCfOtras importeBaseCfOtras;
	private LibroDeterminacionPagoCf determinacionPagoCf;
	private LibroDeterminacionPagoCfIpn determinacionPagoCfIpn;
	private LibroDeterminacionPagoCfOtras determinacionPagoCfOtras;
	private LibroDeterminacionPagoSdCf determinacionPagoSdCf;
	private LibroDeterminacionPago determinacionPago;
	private LibroCantidadComprasNotas cantidadComprasNotas;
	private LibroTotalComprasNotas totalComprasNotas;
	private LibroCantidadVentasCf cantidadVentas;
	private LibroTotalVentasCf totalVentas;
	private LibroCantidadVentasCfElec cantidadVentasCfElec;
	private LibroCantidadVentasCfOtras cantidadVentasCfOtras;
	private LibroTotalVentasCfElec totalVentasCfElec;
	private LibroTotalVentasCfOtras totalVentasCfOtras;
	private LibroCantidadVentasSdCf cantidadVentasSdCf;
	private LibroCantidadVentasSdCfOtras cantidadVentasSdCfOtras;
	private LibroCantidadVentasSdCfSrg cantidadVentasSdCfSrg;
	private LibroTotalVentasSdCf totalVentasSdCf;
	private LibroTotalVentasSdCfOtras totalVentasSdCfOtras;
	private LibroTotalVentasSdCfSrg totalVentasSdCfSrg;
	
	private LibroCantidadVentasNotas cantidadVentasNotas;
	private LibroTotalVentasNotas totalVentasNotas;
	private LibroTipoPresentacionId tipoPresentacionId;
	private LibroFechaPresentacion fechaPresentacion;
	private LibroPeriodicidadId periodicidadId;
	private LibroCantidadPeriodicidad cantidadPeriodicidad;
	private LibroNumeroOrden numeroOrden;
	private LibroEstadoLibroId estadoLibroId;
	private LibroFechaEstado fechaEstado;
	private LibroNumeroEnvio numeroEnvio;
	private LibroRectificadoId libroRectificadoId;
	private LibroConMovimiento conMovimiento;
	private LibroUsuarioRegistro usuarioRegistro;
	private LibroFechaRegistro fechaRegistro;
	private LibroUsuarioUltimaModificacion usuarioUltimaModificacion;
	private LibroFechaUltimaModificacion fechaUltimaModificacion;
	private LibroEstadoId estadoId;

	private List<CompraId> compras;
	private List<CompraNotaId> comprasNotas;

	
	 public Libro(){
		this.id = null;

	        
	    }
	

	


	public Libro(LibroId id, LibroNit nit, LibroIfc ifc, LibroRazonSocial razonSocial,
			LibroCodigoAdministracion codAdministracion, LibroAdministracion administracion, LibroMesPeriodo mesPeriodo,
			LibroAnioPeriodo anioPeriodo, LibroNombreLibro nombreLibro, LibroCantidadComprasCf cantidadCompras,
			LibroTotalComprasCf totalCompras, LibroCantidadComprasCfElec cantidadComprasCfElec,
			LibroCantidadComprasCfIpn cantidadComprasCfIpn, LibroCantidadComprasCfOtras cantidadComprasCfOtras,
			LibroCantidadComprasSdCf cantidadComprasSdCf, LibroTotalComprasCfElec totalComprasCfElec,
			LibroTotalComprasCfIpn totalComprasCfIpn, LibroTotalComprasCfOtras totalComprasCfOtras,
			LibroTotalComprasSdCf totalComprasSdCf, 
			 LibroImporteBaseComprasCf importeBaseCf,
			 LibroImporteBaseComprasCfElec importeBaseCfElec,
			 LibroImporteBaseComprasCfIpn importeBaseCfIpn,
			 LibroImporteBaseComprasCfOtras importeBaseCfOtras,
			LibroDeterminacionPagoCf determinacionPagoCf,
			LibroDeterminacionPagoCfIpn determinacionPagoCfIpn, LibroDeterminacionPagoCfOtras determinacionPagoCfOtras,
			LibroDeterminacionPagoSdCf determinacionPagoSdCf, LibroDeterminacionPago determinacionPago,
			LibroCantidadComprasNotas cantidadComprasNotas, LibroTotalComprasNotas totalComprasNotas,
			LibroCantidadVentasCf cantidadVentas, LibroTotalVentasCf totalVentas,
			LibroCantidadVentasCfElec cantidadVentasCfElec, LibroCantidadVentasCfOtras cantidadVentasCfOtras,
			LibroTotalVentasCfElec totalVentasCfElec, LibroTotalVentasCfOtras totalVentasCfOtras,
			LibroCantidadVentasSdCf cantidadVentasSdCf, LibroCantidadVentasSdCfOtras cantidadVentasSdCfOtras,
			LibroCantidadVentasSdCfSrg cantidadVentasSdCfSrg, LibroTotalVentasSdCf totalVentasSdCf,
			LibroTotalVentasSdCfOtras totalVentasSdCfOtras, LibroTotalVentasSdCfSrg totalVentasSdCfSrg,
			LibroCantidadVentasNotas cantidadVentasNotas, LibroTotalVentasNotas totalVentasNotas,
			LibroTipoPresentacionId tipoPresentacionId, LibroFechaPresentacion fechaPresentacion,
			LibroPeriodicidadId periodicidadId, LibroCantidadPeriodicidad cantidadPeriodicidad,
			LibroNumeroOrden numeroOrden, LibroEstadoLibroId estadoLibroId, LibroFechaEstado fechaEstado,
			LibroNumeroEnvio numeroEnvio, LibroRectificadoId libroRectificadoId, LibroConMovimiento conMovimiento,
			LibroUsuarioRegistro usuarioRegistro, LibroFechaRegistro fechaRegistro,
			LibroUsuarioUltimaModificacion usuarioUltimaModificacion,
			LibroFechaUltimaModificacion fechaUltimaModificacion, LibroEstadoId estadoId, List<CompraId> compras,
			List<CompraNotaId> comprasNotas) {
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
		 this.importeBaseCf=importeBaseCf;
		 this.importeBaseCfElec=importeBaseCfElec;
		 this.importeBaseCfIpn=importeBaseCfIpn;
		 this.importeBaseCfOtras=importeBaseCfOtras;
		this.determinacionPagoCf=determinacionPagoCf;
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
		this.compras = compras;
		this.comprasNotas = comprasNotas;
	}





	public static Libro registro(LibroId id, 
			LibroNombreLibro nombreLibro, 
			LibroMesPeriodo mesPeriodo,
			LibroAnioPeriodo anioPeriodo, 
			LibroPeriodicidadId periodicidadId, 
			LibroCantidadPeriodicidad cantidadPeriodicidad,
			LibroTipoPresentacionId tipoPresentacionId,
			LibroNit nit, LibroIfc ifc,
			LibroRazonSocial razonSocial,
			LibroCodigoAdministracion codAdministracion,
			LibroAdministracion administracion,
			LibroUsuarioRegistro usuarioRegistro) {
		LibroTotalComprasCf totalCompras = new LibroTotalComprasCf(BigDecimal.ZERO);
		LibroCantidadComprasCf cantidadCompras = new LibroCantidadComprasCf(Integer.valueOf(0));
		LibroTotalComprasNotas totalComprasNotas = new LibroTotalComprasNotas(BigDecimal.ZERO);
		LibroCantidadComprasNotas cantidadComprasNotas = new LibroCantidadComprasNotas(Integer.valueOf(0));
		LibroTotalVentasCf totalVentas = new LibroTotalVentasCf(BigDecimal.ZERO);
		LibroCantidadVentasCf cantidadVentas = new LibroCantidadVentasCf(Integer.valueOf(0));
		LibroTotalVentasNotas totalVentasNotas = new LibroTotalVentasNotas(BigDecimal.ZERO);
		LibroCantidadVentasNotas cantidadVentasNotas = new LibroCantidadVentasNotas(Integer.valueOf(0));
		LibroEstadoLibroId estadoLibroId = new LibroEstadoLibroId(
				"REG");
		LibroFechaRegistro fechaRegistro = new LibroFechaRegistro(LocalDateTime.now());
		LibroUsuarioUltimaModificacion usuarioUltimaModificacion = new LibroUsuarioUltimaModificacion(
				usuarioRegistro.value());
		LibroNumeroOrden numeroOrden = new LibroNumeroOrden(null);
		LibroFechaUltimaModificacion fechaUltimaModificacion = new LibroFechaUltimaModificacion(
				LocalDateTime.now());
		LibroEstadoId estadoId = new LibroEstadoId("AC");
		LibroFechaEstado fechaEstado = new LibroFechaEstado(LocalDate.now());
		LibroNumeroEnvio numeroEnvio = new LibroNumeroEnvio(Integer.valueOf(0));
		LibroRectificadoId libroRectificadoId=new LibroRectificadoId();
		LibroConMovimiento conMovimiento=new LibroConMovimiento("SI");
		LibroFechaPresentacion fechaPresentacion=new LibroFechaPresentacion();
		 LibroCantidadComprasCfElec cantidadComprasCfElec=new LibroCantidadComprasCfElec(Integer.valueOf(0));
			LibroCantidadComprasCfIpn cantidadComprasCfIpn=new LibroCantidadComprasCfIpn(Integer.valueOf(0));
			LibroCantidadComprasCfOtras cantidadComprasCfOtras=new LibroCantidadComprasCfOtras(Integer.valueOf(0));
			LibroCantidadComprasSdCf cantidadComprasSdCf=new LibroCantidadComprasSdCf(Integer.valueOf(0));
			LibroTotalComprasCfElec totalComprasCfElec=new LibroTotalComprasCfElec(BigDecimal.ZERO);
			LibroTotalComprasCfIpn totalComprasCfIpn=new LibroTotalComprasCfIpn(BigDecimal.ZERO);
			LibroTotalComprasCfOtras totalComprasCfOtras=new LibroTotalComprasCfOtras(BigDecimal.ZERO);
			LibroTotalComprasSdCf totalComprasSdCf=new LibroTotalComprasSdCf(BigDecimal.ZERO);
			 LibroImporteBaseComprasCf importeBaseCf=new LibroImporteBaseComprasCf(BigDecimal.ZERO);
			 LibroImporteBaseComprasCfElec importeBaseCfElec=new LibroImporteBaseComprasCfElec(BigDecimal.ZERO);
			 LibroImporteBaseComprasCfIpn importeBaseCfIpn=new LibroImporteBaseComprasCfIpn(BigDecimal.ZERO);
			 LibroImporteBaseComprasCfOtras importeBaseCfOtras=new LibroImporteBaseComprasCfOtras(BigDecimal.ZERO);
			
			LibroDeterminacionPagoCf determinacionPagoCf=new LibroDeterminacionPagoCf(BigDecimal.ZERO);
			LibroDeterminacionPagoCfIpn determinacionPagoCfIpn=new LibroDeterminacionPagoCfIpn(BigDecimal.ZERO);
			LibroDeterminacionPagoCfOtras determinacionPagoCfOtras=new LibroDeterminacionPagoCfOtras(BigDecimal.ZERO);
			LibroDeterminacionPagoSdCf determinacionPagoSdCf=new LibroDeterminacionPagoSdCf(BigDecimal.ZERO);
			LibroDeterminacionPago determinacionPago=new LibroDeterminacionPago(BigDecimal.ZERO);
			LibroCantidadVentasCfElec cantidadVentasCfElec=new LibroCantidadVentasCfElec(Integer.valueOf(0));
			LibroCantidadVentasCfOtras cantidadVentasCfOtras=new LibroCantidadVentasCfOtras(Integer.valueOf(0));
			LibroTotalVentasCfElec totalVentasCfElec=new LibroTotalVentasCfElec(BigDecimal.ZERO);
			LibroTotalVentasCfOtras totalVentasCfOtras=new LibroTotalVentasCfOtras(BigDecimal.ZERO);
			LibroCantidadVentasSdCf cantidadVentasSdCf=new LibroCantidadVentasSdCf(Integer.valueOf(0));
			LibroCantidadVentasSdCfOtras cantidadVentasSdCfOtras=new LibroCantidadVentasSdCfOtras(Integer.valueOf(0));
			LibroCantidadVentasSdCfSrg cantidadVentasSdCfSrg=new LibroCantidadVentasSdCfSrg(Integer.valueOf(0));
			LibroTotalVentasSdCf totalVentasSdCf=new LibroTotalVentasSdCf(BigDecimal.ZERO);
			LibroTotalVentasSdCfOtras totalVentasSdCfOtras=new LibroTotalVentasSdCfOtras(BigDecimal.ZERO);
			LibroTotalVentasSdCfSrg totalVentasSdCfSrg=new LibroTotalVentasSdCfSrg(BigDecimal.ZERO);

		List<CompraId> compras = new ArrayList<>();
		List<CompraNotaId> comprasNotas=new ArrayList<>();

		Libro Libro = new Libro(id,
				nit,
				ifc,
				razonSocial,
				codAdministracion,
				administracion,
				mesPeriodo,
				anioPeriodo,
				nombreLibro,
				cantidadCompras,
				totalCompras,
				cantidadComprasCfElec,
				cantidadComprasCfIpn,
				cantidadComprasCfOtras,
				cantidadComprasSdCf,
				totalComprasCfElec,
				totalComprasCfIpn,
				totalComprasCfOtras,
				totalComprasSdCf,
				importeBaseCf,
				importeBaseCfElec,
				 importeBaseCfIpn,
				 importeBaseCfOtras,
				determinacionPagoCf,
				determinacionPagoCfIpn,
				determinacionPagoCfOtras,
				determinacionPagoSdCf,
				determinacionPago,
				cantidadComprasNotas,
				totalComprasNotas,
				cantidadVentas ,
				totalVentas ,
				cantidadVentasCfElec ,
				cantidadVentasCfOtras ,
				totalVentasCfElec ,
				totalVentasCfOtras ,
				cantidadVentasSdCf ,
				cantidadVentasSdCfOtras ,
				cantidadVentasSdCfSrg ,
				totalVentasSdCf ,
				totalVentasSdCfOtras ,
				totalVentasSdCfSrg ,
				cantidadVentasNotas ,
				totalVentasNotas ,
				tipoPresentacionId ,
				fechaPresentacion ,
				periodicidadId ,
				cantidadPeriodicidad ,
				numeroOrden ,
				estadoLibroId ,
				fechaEstado ,
				numeroEnvio ,
				libroRectificadoId ,
				conMovimiento ,
				usuarioRegistro ,
				fechaRegistro ,
				usuarioUltimaModificacion ,
				fechaUltimaModificacion ,
				estadoId ,
				compras,
				comprasNotas);

		Libro.record(LibroRegistradoDomainEvent.LibroRegistradoDomainEvent().id(id.value())
				.ifc(ifc.value()).nit(nit.value())
				.razonSocial(razonSocial.value())
				.mesPeriodo(mesPeriodo.value()).anioPeriodo(anioPeriodo.value())
				.nombreLibro(nombreLibro.value())
				.cantidadCompras(cantidadCompras.value()).totalCompras(totalCompras.value())
				.cantidadComprasNotas(cantidadComprasNotas.value()).totalComprasNotas(totalComprasNotas.value())
				.cantidadVentas(cantidadVentas.value()).totalVentas(totalVentas.value())
				.cantidadVentasNotas(cantidadVentasNotas.value()).totalVentasNotas(totalVentasNotas.value())
				.tipoPresentacionId(tipoPresentacionId.value())
				.fechaPresentacion(fechaPresentacion.value()).periodicidadId(periodicidadId.value())
				.cantidadPeriodicidad(cantidadPeriodicidad.value()).numeroOrden(numeroOrden.value())
				.fechaEstado(fechaEstado.value()).estadoLibroId(estadoLibroId.value())
				.numeroEnvio(numeroEnvio.value())
				.libroRectificadoId(libroRectificadoId.value())
				.conMovimiento(conMovimiento.value())
				.usuarioRegistro(usuarioRegistro.value())
				.fechaRegistro(fechaRegistro.value()).usuarioUltimaModificacion(usuarioUltimaModificacion.value())
				.fechaUltimaModificacion(fechaUltimaModificacion.value()).estadoId(estadoId.value())
				.comprasId(compras.stream().map(compraId -> compraId.value()).collect(Collectors.toList()))
				.comprasNotasId(comprasNotas.stream().map(compraNotaId -> compraNotaId.value()).collect(Collectors.toList())).build());
		Libro.compras = new ArrayList<>();
		Libro.comprasNotas= new ArrayList<>();
		return Libro;
	}
	public void incrementoImporte(BigDecimal importeBaseCf, BigDecimal creditoFiscal,
			LibroUsuarioUltimaModificacion usuarioUltimaModificacion, CompraId compraId,
			BigDecimal importeTotalCompra,
            CompraMarcaEspecialId marcaEspecialId,String modalidadId) 
	{	
			
		if(marcaEspecialId.value()!=null&&marcaEspecialId.value().equals("IPN"))
		{
			this.totalCompras = this.totalCompras.adicion(importeTotalCompra);
			this.cantidadCompras = this.cantidadCompras.incrementar();
			this.determinacionPagoCf=this.determinacionPagoCf.adicion(creditoFiscal);
			this.importeBaseCf=this.importeBaseCf.adicion(importeBaseCf);
			this.totalComprasCfIpn=this.totalComprasCfIpn.adicion(importeTotalCompra);
			this.cantidadComprasCfIpn=this.cantidadComprasCfIpn.incrementar();
			this.determinacionPagoCfIpn=this.determinacionPagoCfIpn.adicion(creditoFiscal);
			this.importeBaseCfIpn=this.importeBaseCfIpn.adicion(importeBaseCf);
			this.determinacionPago= this.determinacionPago.adicion(creditoFiscal);
						
			
			if(modalidadId.equals("FEL")||modalidadId.equals("FPW")||modalidadId.equals("FCL"))
			{
				this.cantidadComprasCfElec=this.cantidadComprasCfElec.incrementar();
				this.totalComprasCfElec=this.totalComprasCfElec.adicion(importeTotalCompra);
				this.importeBaseCfElec=this.importeBaseCfElec.adicion(importeBaseCf);
			}
		}
		else if(marcaEspecialId.value()!=null&&marcaEspecialId.value().equals("7RG"))
		{
			this.totalComprasSdCf=this.totalComprasSdCf.adicion(importeTotalCompra);
			this.cantidadComprasSdCf=this.cantidadComprasSdCf.incrementar();
			this.determinacionPagoSdCf= this.determinacionPagoSdCf.adicion(creditoFiscal);
			this.determinacionPago= this.determinacionPago.adicion(creditoFiscal);
		
		}
		else if(modalidadId.equals("FEL")||modalidadId.equals("FPW")||modalidadId.equals("FCL"))
		{
			this.totalCompras = this.totalCompras.adicion(importeTotalCompra);
			this.cantidadCompras = this.cantidadCompras.incrementar();
			this.determinacionPagoCf=this.determinacionPagoCf.adicion(creditoFiscal);
			this.determinacionPago= this.determinacionPago.adicion(creditoFiscal);
			this.cantidadComprasCfElec=this.cantidadComprasCfElec.incrementar();
			this.totalComprasCfElec=this.totalComprasCfElec.adicion(importeTotalCompra);
			this.importeBaseCfElec=this.importeBaseCfElec.adicion(importeBaseCf);
			
			
		}
		else
		{
			this.totalCompras = this.totalCompras.adicion(importeTotalCompra);
			this.cantidadCompras = this.cantidadCompras.incrementar();
			this.determinacionPagoCf=this.determinacionPagoCf.adicion(creditoFiscal);
			this.importeBaseCf=this.importeBaseCf.adicion(importeBaseCf);
			this.totalComprasCfOtras=this.totalComprasCfOtras.adicion(importeTotalCompra);
			this.cantidadComprasCfOtras=this.cantidadComprasCfOtras.incrementar();
			this.determinacionPagoCfOtras=this.determinacionPagoCfOtras.adicion(creditoFiscal);
			this.importeBaseCfOtras=this.importeBaseCfOtras.adicion(importeBaseCf);
			this.determinacionPago= this.determinacionPago.adicion(creditoFiscal);
		}
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			this.compras = this.compras == null ? new ArrayList<>() : this.compras;
			this.compras.add(compraId);
			this.record(new LibroIncrementadoImporteDomainEvent(id.value(), this.totalCompras.value(),
					this.cantidadCompras.value(), this.usuarioUltimaModificacion.value()
					,this.mesPeriodo.value(),this.anioPeriodo.value(),this.nombreLibro.value(),compraId.value()));
	}
	public void decrementoImporte(BigDecimal importeBaseCf, BigDecimal creditoFiscal,
			LibroUsuarioUltimaModificacion usuarioUltimaModificacion, CompraId compraId,
			BigDecimal importeTotalCompra,
	        CompraMarcaEspecialId marcaEspecialId,String modalidadId) {
		
		
		if(marcaEspecialId.value()!=null&&marcaEspecialId.value().equals("IPN"))
		{
			this.totalCompras = this.totalCompras.substracion(importeTotalCompra);
			this.cantidadCompras = this.cantidadCompras.decrementar();
			this.determinacionPagoCf=this.determinacionPagoCf.substracion(creditoFiscal);
			this.importeBaseCf=this.importeBaseCf.substracion(importeBaseCf);
			this.totalComprasCfIpn=this.totalComprasCfIpn.substracion(importeTotalCompra);
			this.cantidadComprasCfIpn=this.cantidadComprasCfIpn.decrementar();
			this.determinacionPagoCfIpn=this.determinacionPagoCfIpn.substracion(creditoFiscal);
			this.importeBaseCfIpn=this.importeBaseCfIpn.substracion(importeBaseCf);
			this.determinacionPago= this.determinacionPago.substracion(creditoFiscal);
						
			
			if(modalidadId.equals("FEL")||modalidadId.equals("FPW")||modalidadId.equals("FCL"))
			{
				this.cantidadComprasCfElec=this.cantidadComprasCfElec.decrementar();
				this.totalComprasCfElec=this.totalComprasCfElec.substracion(importeTotalCompra);
				this.importeBaseCfElec=this.importeBaseCfElec.substracion(importeBaseCf);
			}
		}
		else if(marcaEspecialId.value()!=null&&marcaEspecialId.value().equals("7RG"))
		{
			this.totalComprasSdCf=this.totalComprasSdCf.substracion(importeTotalCompra);
			this.cantidadComprasSdCf=this.cantidadComprasSdCf.decrementar();
			this.determinacionPagoSdCf= this.determinacionPagoSdCf.substracion(creditoFiscal);
			this.determinacionPago= this.determinacionPago.substracion(creditoFiscal);
		
		}
		else if(modalidadId.equals("FEL")||modalidadId.equals("FPW")||modalidadId.equals("FCL"))
		{
			this.totalCompras = this.totalCompras.substracion(importeTotalCompra);
			this.cantidadCompras = this.cantidadCompras.decrementar();
			this.determinacionPagoCf=this.determinacionPagoCf.substracion(creditoFiscal);
			this.determinacionPago= this.determinacionPago.substracion(creditoFiscal);
			this.cantidadComprasCfElec=this.cantidadComprasCfElec.decrementar();
			this.totalComprasCfElec=this.totalComprasCfElec.substracion(importeTotalCompra);
			this.importeBaseCfElec=this.importeBaseCfElec.substracion(importeBaseCf);
			
		}
		else
		{
			this.totalCompras = this.totalCompras.substracion(importeTotalCompra);
			this.cantidadCompras = this.cantidadCompras.decrementar();
			this.determinacionPagoCf=this.determinacionPagoCf.substracion(creditoFiscal);
			this.importeBaseCf=this.importeBaseCf.substracion(importeBaseCf);
			this.totalComprasCfOtras=this.totalComprasCfOtras.substracion(importeTotalCompra);
			this.cantidadComprasCfOtras=this.cantidadComprasCfOtras.decrementar();
			this.determinacionPagoCfOtras=this.determinacionPagoCfOtras.substracion(creditoFiscal);
			this.importeBaseCfOtras=this.importeBaseCfOtras.substracion(importeBaseCf);
			this.determinacionPago= this.determinacionPago.substracion(creditoFiscal);
		}
		
		
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = new LibroFechaUltimaModificacion(LocalDateTime.now());
		this.compras = this.compras == null ? new ArrayList<>() : this.compras;

		List<CompraId> compraIds = this.compras.stream().filter(x -> !x.value().equals(compraId.value()))
				.collect(Collectors.toList());

		this.compras = compraIds;
		this.record(new LibroDecrementadoImporteDomainEvent(id.value(), this.totalCompras.value(),
				this.cantidadCompras.value(), this.usuarioUltimaModificacion.value(),
				this.mesPeriodo.value(),this.anioPeriodo.value(),this.nombreLibro.value(),compraId.value()));

	}
	public void incrementoImporteNotas(BigDecimal ImporteTotalNota, BigDecimal creditoFiscalNota,
			LibroUsuarioUltimaModificacion usuarioUltimaModificacion, CompraNotaId compraNotaId) 
	{
			this.totalComprasNotas = this.totalComprasNotas.adicion(ImporteTotalNota);
			this.cantidadComprasNotas = this.cantidadComprasNotas.incrementar();
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			this.fechaUltimaModificacion=new LibroFechaUltimaModificacion(LocalDateTime.now());
			this.comprasNotas = this.comprasNotas == null ? new ArrayList<>() : this.comprasNotas;
			this.comprasNotas.add(compraNotaId);
			this.record(new LibroIncrementadoImporteNotasDomainEvent(id.value(), this.totalComprasNotas.value(),
					this.cantidadComprasNotas.value(), this.usuarioUltimaModificacion.value()
					,this.mesPeriodo.value(),this.anioPeriodo.value(),this.nombreLibro.value(),compraNotaId.value()));
	}
	public void decrementoImporteNotas(BigDecimal pImporteTotalNota, BigDecimal creditoFiscalNota,
			LibroUsuarioUltimaModificacion usuarioUltimaModificacion, CompraNotaId compraNotaId) {
		this.totalComprasNotas = this.totalComprasNotas.substracion(pImporteTotalNota);
		this.cantidadComprasNotas = this.cantidadComprasNotas.decrementar();
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = new LibroFechaUltimaModificacion(LocalDateTime.now());
		this.compras = this.compras == null ? new ArrayList<>() : this.compras;

		List<CompraNotaId> compraNotaIds = this.comprasNotas.stream().filter(x -> !x.value().equals(compraNotaId.value()))
				.collect(Collectors.toList());

		this.comprasNotas = compraNotaIds;
		this.record(new LibroDecrementadoImporteNotasDomainEvent(id.value(), this.totalComprasNotas.value(),
				this.cantidadComprasNotas.value(), this.usuarioUltimaModificacion.value()
				,this.mesPeriodo.value(),this.anioPeriodo.value(),this.nombreLibro.value(),compraNotaId.value()));

	}
	public void declararLibro(LibroNumeroOrden numeroOrden,
			LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		if (this.estadoLibroId.value().equals(EstadoformularioId.REGISTRADO.value())) {
			this.estadoLibroId = new LibroEstadoLibroId(EstadoformularioId.DECLARADO.value());
			this.fechaEstado = new LibroFechaEstado(LocalDate.now());
			this.numeroOrden = numeroOrden;
			this.fechaPresentacion=new LibroFechaPresentacion(LocalDateTime.now());
			this.fechaUltimaModificacion = new LibroFechaUltimaModificacion(LocalDateTime.now());
			this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
			this.numeroEnvio = this.numeroEnvio.incrementar();
			this.record(new LibroDeclaradoEventDomain(this.id.value(), this.numeroOrden.value(),
					this.fechaPresentacion.value(), this.estadoLibroId.value(),
					this.fechaUltimaModificacion.value(), this.usuarioUltimaModificacion.value(),
					this.compras().stream().map(x -> x.value()).collect(Collectors.toList())));
		}
	}
	
	public void inhabilitaFormulario(LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,String pIdLibroRectificado) {
		
		this.estadoLibroId=new LibroEstadoLibroId(EnumEstadoLibroId.RECTIFICADO.value());
		this.fechaUltimaModificacion = new LibroFechaUltimaModificacion(LocalDateTime.now());
		this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
		
		
		this.record(new LibroRectificadoDeclaradoCompraDomainEvent(this.id.value(),
				this.usuarioUltimaModificacion.value(),
				this.compras().stream().map(x -> x.value()).collect(Collectors.toList()), 
				pIdLibroRectificado));
		this.record(new LibroRectificadoDeclaradoNotaDomainEvent(this.id.value(),
					this.usuarioUltimaModificacion.value(),
					this.comprasNotas().stream().map(x -> x.value()).collect(Collectors.toList()), 
					pIdLibroRectificado));
			
	}
	
	public static Libro habilitarRectificatorio(Libro pLibroRectificar,LibroUsuarioUltimaModificacion usuarioUltimaModificacion,String pIdNuevoLibro) 
	{
		
		return new Libro(
				new LibroId(pIdNuevoLibro),
				pLibroRectificar.nit,
				pLibroRectificar.ifc,
				pLibroRectificar.razonSocial,
				pLibroRectificar.codAdministracion,
				pLibroRectificar.administracion,
				pLibroRectificar.mesPeriodo,
				pLibroRectificar.anioPeriodo,
				pLibroRectificar.nombreLibro,
				pLibroRectificar.cantidadCompras,
				pLibroRectificar.totalCompras,
				pLibroRectificar.cantidadComprasCfElec,
				pLibroRectificar.cantidadComprasCfIpn,
				pLibroRectificar.cantidadComprasCfOtras,
				pLibroRectificar.cantidadComprasSdCf,
				pLibroRectificar.totalComprasCfElec,
				pLibroRectificar.totalComprasCfIpn,
				pLibroRectificar.totalComprasCfOtras,
				pLibroRectificar.totalComprasSdCf,
				pLibroRectificar.importeBaseCf,
				pLibroRectificar.importeBaseCfElec,
				pLibroRectificar.importeBaseCfIpn,
				pLibroRectificar.importeBaseCfOtras,
				pLibroRectificar.determinacionPagoCf,
				pLibroRectificar.determinacionPagoCfIpn,
				pLibroRectificar.determinacionPagoCfOtras,
				pLibroRectificar.determinacionPagoSdCf,
				pLibroRectificar.determinacionPago,
				pLibroRectificar.cantidadComprasNotas,
				pLibroRectificar.totalComprasNotas,
				pLibroRectificar.cantidadVentas ,
				pLibroRectificar.totalVentas ,
				pLibroRectificar.cantidadVentasCfElec ,
				pLibroRectificar.cantidadVentasCfOtras ,
				pLibroRectificar.totalVentasCfElec ,
				pLibroRectificar.totalVentasCfOtras ,
				pLibroRectificar.cantidadVentasSdCf ,
				pLibroRectificar.cantidadVentasSdCfOtras ,
				pLibroRectificar.cantidadVentasSdCfSrg ,
				pLibroRectificar.totalVentasSdCf ,
				pLibroRectificar.totalVentasSdCfOtras ,
				pLibroRectificar.totalVentasSdCfSrg ,
				pLibroRectificar.cantidadVentasNotas ,
				pLibroRectificar.totalVentasNotas ,
				new LibroTipoPresentacionId(EnumEstadoLibroId.RECTIFICADO.value()) ,
				pLibroRectificar.fechaPresentacion ,
				pLibroRectificar.periodicidadId ,
				pLibroRectificar.cantidadPeriodicidad ,
				pLibroRectificar.numeroOrden ,
				new LibroEstadoLibroId(EnumEstadoLibroId.REGISTRADO.value()),
				pLibroRectificar.fechaEstado ,
				pLibroRectificar.numeroEnvio ,
				new LibroRectificadoId(pLibroRectificar.id.value()),
				pLibroRectificar.conMovimiento ,
				new LibroUsuarioRegistro(usuarioUltimaModificacion.value()) ,
				new LibroFechaRegistro(LocalDateTime.now()),
				usuarioUltimaModificacion ,
				new LibroFechaUltimaModificacion(LocalDateTime.now()) ,
				pLibroRectificar.estadoId ,
				pLibroRectificar.compras,
				pLibroRectificar.comprasNotas);

	}
	
	

	public LibroId id() {
		return id;
	}

	public LibroNit nit() {
		return nit;
	}

	public LibroIfc ifc() {
		return ifc;
	}

	public LibroRazonSocial razonSocial() {
		return razonSocial;
	}

	public LibroMesPeriodo mesPeriodo() {
		return mesPeriodo;
	}

	public LibroAnioPeriodo anioPeriodo() {
		return anioPeriodo;
	}

	public LibroNombreLibro nombreLibro() {
		return nombreLibro;
	}

	public LibroCantidadComprasCf cantidadCompras() {
		return cantidadCompras;
	}

	public LibroTotalComprasCf totalCompras() {
		return totalCompras;
	}

	public LibroTipoPresentacionId tipoPresentacionId() {
		return tipoPresentacionId;
	}

	public LibroFechaPresentacion fechaPresentacion() {
		return fechaPresentacion;
	}

	public LibroPeriodicidadId periodicidadId() {
		return periodicidadId;
	}

	public LibroCantidadPeriodicidad cantidadPeriodicidad() {
		return cantidadPeriodicidad;
	}

	public LibroNumeroOrden numeroOrden() {
		return numeroOrden;
	}

	public LibroEstadoLibroId estadoLibroId() {
		return estadoLibroId;
	}

	public LibroFechaEstado fechaEstado() {
		return fechaEstado;
	}

	public LibroNumeroEnvio numeroEnvio() {
		return numeroEnvio;
	}

	public LibroUsuarioRegistro usuarioRegistro() {
		return usuarioRegistro;
	}

	public LibroFechaRegistro fechaRegistro() {
		return fechaRegistro;
	}

	public LibroUsuarioUltimaModificacion usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public LibroFechaUltimaModificacion fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public LibroEstadoId estadoId() {
		return estadoId;
	}

	public List<CompraId> compras() {
		return compras;
	}

	public LibroCantidadVentasCf cantidadVentas() {
		return cantidadVentas;
	}

	public LibroTotalVentasCf totalVentas() {
		return totalVentas;
	}


	public LibroCantidadComprasNotas cantidadComprasNotas() {
		return cantidadComprasNotas;
	}


	public LibroTotalComprasNotas totalComprasNotas() {
		return totalComprasNotas;
	}


	public LibroCantidadVentasNotas cantidadVentasNotas() {
		return cantidadVentasNotas;
	}


	public LibroTotalVentasNotas totalVentasNotas() {
		return totalVentasNotas;
	}


	public LibroConMovimiento conMovimiento() {
		return conMovimiento;
	}


	public List<CompraNotaId> comprasNotas() {
		return comprasNotas;
	}


	public LibroRectificadoId libroRectificadoId() {
		return libroRectificadoId;
	}
	
	public LibroCodigoAdministracion codAdministracion()
	{
	    return codAdministracion;
	}
	public LibroAdministracion administracion()
	{
	    return administracion;
	}
	public LibroCantidadComprasCfElec cantidadComprasCfElec()
	{
	    return cantidadComprasCfElec;
	}
	public LibroCantidadComprasCfIpn cantidadComprasCfIpn()
	{
	    return cantidadComprasCfIpn;
	}
	public LibroCantidadComprasCfOtras cantidadComprasCfOtras()
	{
	    return cantidadComprasCfOtras;
	}
	public LibroCantidadComprasSdCf cantidadComprasSdCf()
	{
	    return cantidadComprasSdCf;
	}
	public LibroTotalComprasCfElec totalComprasCfElec()
	{
	    return totalComprasCfElec;
	}
	public LibroTotalComprasCfIpn totalComprasCfIpn()
	{
	    return totalComprasCfIpn;
	}
	public LibroTotalComprasCfOtras totalComprasCfOtras()
	{
	    return totalComprasCfOtras;
	}
	public LibroTotalComprasSdCf totalComprasSdCf()
	{
	    return totalComprasSdCf;
	}
	public LibroDeterminacionPagoCf determinacionPagoCf()
	{
	    return determinacionPagoCf;
	}
	public LibroDeterminacionPagoCfIpn determinacionPagoCfIpn()
	{
	    return determinacionPagoCfIpn;
	}
	public LibroDeterminacionPagoCfOtras determinacionPagoCfOtras()
	{
	    return determinacionPagoCfOtras;
	}
	public LibroDeterminacionPagoSdCf determinacionPagoSdCf()
	{
	    return determinacionPagoSdCf;
	}
	public LibroDeterminacionPago determinacionPago()
	{
	    return determinacionPago;
	}
	public LibroCantidadVentasCfElec cantidadVentasCfElec()
	{
	    return cantidadVentasCfElec;
	}
	public LibroCantidadVentasCfOtras cantidadVentasCfOtras()
	{
	    return cantidadVentasCfOtras;
	}
	public LibroTotalVentasCfElec totalVentasCfElec()
	{
	    return totalVentasCfElec;
	}
	public LibroTotalVentasCfOtras totalVentasCfOtras()
	{
	    return totalVentasCfOtras;
	}
	public LibroCantidadVentasSdCf cantidadVentasSdCf()
	{
	    return cantidadVentasSdCf;
	}
	public LibroCantidadVentasSdCfOtras cantidadVentasSdCfOtras()
	{
	    return cantidadVentasSdCfOtras;
	}
	public LibroCantidadVentasSdCfSrg cantidadVentasSdCfSrg()
	{
	    return cantidadVentasSdCfSrg;
	}
	public LibroTotalVentasSdCf totalVentasSdCf()
	{
	    return totalVentasSdCf;
	}
	public LibroTotalVentasSdCfOtras totalVentasSdCfOtras()
	{
	    return totalVentasSdCfOtras;
	}
	public LibroTotalVentasSdCfSrg totalVentasSdCfSrg()
	{
	    return totalVentasSdCfSrg;
	}
	public LibroImporteBaseComprasCf importeBaseCf()
	{
		return importeBaseCf;
	}
	public LibroImporteBaseComprasCfElec importeBaseCfElec()
	{
		return importeBaseCfElec;
	}
	public LibroImporteBaseComprasCfIpn importeBaseCfIpn()
	{
		return importeBaseCfIpn;
	}
	public LibroImporteBaseComprasCfOtras importeBaseCfOtras()
	{
		return importeBaseCfOtras;
	}
	
}
