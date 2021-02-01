package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.time.LocalDateTime;
import java.util.Objects;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain.VentaAgrupadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.str.constantes.estado.ConstEstado;

public final class Venta extends AggregateRoot {
	private final VentaId id;
	private VentaRecepcionId recepcionId;
	private VentaSecuencia secuencia;
	private VentaIfcProveedor ifcProveedor;
	private VentaNitProveedor nitProveedor;
	private VentaRazonSocialProveedor razonSocialProveedor;
	private VentaNumeroDocumentoCliente numeroDocumentoCliente;
	private VentaNombreCliente nombreCliente;
	private VentaNumeroFactura numeroFactura;
	private VentaCodigoAutorizacion codigoAutorizacion;
	private VentaFechaFactura fechaFactura;
	private VentaImporteTotal importeTotalVenta;
	private VentaImporteIceIehdTasas importeIceIehdTasas;
	private VentaImporteExento importeExento;
	private VentaImporteTasaCero importeTasaCero;
	private VentaSubTotal subtotal;
	private VentaImporteBase importeBase;
	private VentaDebitoFiscal debitoFiscal;
	private VentaCodigoControl codigoControl;
	private VentaDescuento descuento;
	private VentaOrigenId origenId;
	private VentaEstadoVentaId estadoVentaId;
	private VentaLibroId tipoDocumentoCliente;
	private VentaEstadoUsoId estadoUsoId;
	private VentaImpuestoUsoId impuestoUsoId;
	private VentaPeriodoUso periodoUso;
	private VentaNombreFormularioUso nombreArchivoUso;
	private VentaFormularioId formularioId;
	private VentaUsuarioRegistro usuarioRegistro;
	private VentaFechaRegistro fechaRegistro;
	private VentaUsuarioUltimaModificacion usuarioUltimaModificacion;
	private VentaFechaUltimaModificacion fechaUltimaModificacion;
	private VentaEstadoId estadoId;
	private VentaModalidadId modalidadId;
	private VentaNombreFormularioUso nombreFormularioUso;
	private VentaLibroId libroId;
	private VentaConDerechoDf conDerechoDf;
	private VentaMarcaEspecialId marcaEspecialId;

	private VentaModalidadId complementoDocumentoCliente;
	private VentaGestionUso gestionUso;

	private VentaImporteNoSujetoDf importeNoSujetoDf;

	private Venta(Builder builder) {
		this.id = builder.id;
		this.recepcionId = builder.recepcionId;
		this.secuencia = builder.secuencia;
		this.ifcProveedor = builder.ifcProveedor;
		this.nitProveedor = builder.nitProveedor;
		this.razonSocialProveedor = builder.razonSocialProveedor;
		this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
		this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
		this.nombreCliente = builder.nombreCliente;
		this.numeroFactura = builder.numeroFactura;
		this.codigoAutorizacion = builder.codigoAutorizacion;
		this.fechaFactura = builder.fechaFactura;
		this.importeTotalVenta = builder.importeTotalVenta;
		this.importeNoSujetoDf = builder.importeNoSujetoDf;
		this.importeIceIehdTasas = builder.importeIceIehdTasas;
		this.importeExento = builder.importeExento;
		this.importeTasaCero = builder.importeTasaCero;
		this.subtotal = builder.subTotal;
		this.modalidadId = builder.modalidadId;
		this.nombreFormularioUso = builder.nombreFormularioUso;
		this.libroId = builder.libroId;
		this.conDerechoDf = builder.conDerechoDf;
		this.marcaEspecialId = builder.marcaEspecialId;
		this.gestionUso = builder.gestionUso;

		this.importeBase = builder.importeBase;
		this.debitoFiscal = builder.debitoFiscal;
		this.codigoControl = builder.codigoControl;
		this.descuento = builder.descuento;
		this.origenId = builder.origenId;
		this.estadoVentaId = builder.estadoVentaId;
		this.tipoDocumentoCliente = builder.tipoDocumentoCliente;

		this.usuarioRegistro = builder.usuarioRegistro;
		this.fechaRegistro = builder.fechaRegistro;
		this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
		this.fechaUltimaModificacion = builder.fechaUltimaModificacion;

		this.estadoUsoId = builder.estadoUsoId;
		this.impuestoUsoId = builder.impuestoUsoId;
		this.periodoUso = builder.periodoUso;
		this.nombreArchivoUso = builder.nombreArchivoUso;
		this.formularioId = builder.formularioId;
		this.estadoId = builder.estadoId;
	}

	public static Builder newVenta() {
		return new Builder();
	}

	public static Builder registro() {
		return new Builder();
	}

	public VentaId id() {
		return id;
	}

	public VentaRecepcionId recepcionId() {
		return recepcionId;
	}

	public VentaSecuencia secuencia() {
		return secuencia;
	}

	public VentaIfcProveedor ifcProveedor() {
		return ifcProveedor;
	}

	public VentaNitProveedor nitProveedor() {
		return nitProveedor;
	}

	public VentaRazonSocialProveedor razonSocialProveedor() {
		return razonSocialProveedor;
	}

	public VentaNumeroDocumentoCliente numeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public VentaModalidadId complementoDocumentoCliente() {
		return complementoDocumentoCliente;
	}

	public VentaNombreCliente nombreCliente() {
		return nombreCliente;
	}

	public VentaNumeroFactura numeroFactura() {
		return numeroFactura;
	}

	public VentaCodigoAutorizacion codigoAutorizacion() {
		return codigoAutorizacion;
	}

	public VentaFechaFactura fechaFactura() {
		return fechaFactura;
	}

	public VentaImporteTotal importeTotal() {
		return importeTotalVenta;
	}

	public VentaImporteIceIehdTasas importeIceIehdTasas() {
		return importeIceIehdTasas;
	}

	public VentaImporteExento importeExento() {
		return importeExento;
	}

	public VentaImporteTasaCero importeTasaCero() {
		return importeTasaCero;
	}

	public VentaSubTotal subtotal() {
		return subtotal;
	}

	public VentaImporteBase importeBase() {
		return importeBase;
	}

	public VentaDebitoFiscal debitoFiscal() {
		return debitoFiscal;
	}

	public VentaCodigoControl codigoControl() {
		return codigoControl;
	}

	public VentaDescuento descuento() {
		return descuento;
	}

	public VentaOrigenId origenId() {
		return origenId;
	}

	public VentaEstadoVentaId estadoVentaId() {
		return estadoVentaId;
	}

	public VentaLibroId tipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}

	public VentaEstadoUsoId estadoUsoId() {
		return estadoUsoId;
	}

	public VentaImpuestoUsoId impuestoUsoId() {
		return impuestoUsoId;
	}

	public VentaPeriodoUso periodoUso() {
		return periodoUso;
	}

	public VentaNombreFormularioUso nombreArchivoUso() {
		return nombreArchivoUso;
	}

	public VentaFormularioId formularioId() {
		return formularioId;
	}

	public VentaUsuarioRegistro usuarioRegistro() {
		return usuarioRegistro;
	}

	public VentaFechaRegistro fechaRegistro() {
		return fechaRegistro;
	}

	public VentaUsuarioUltimaModificacion usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public VentaFechaUltimaModificacion fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public VentaEstadoId estadoId() {
		return estadoId;
	}

	public VentaModalidadId modalidadId() {
		return modalidadId;
	}

	public VentaGestionUso gestionUso() {
		return gestionUso;
	}

	public Venta() {
		this.id = null;
	}

	public static Venta registro(Builder builder) {
		Venta venta = Venta.newVenta().id(builder.id).recepcionId(builder.recepcionId).secuencia(builder.secuencia)
				.ifcProveedor(builder.ifcProveedor).nitProveedor(builder.nitProveedor)
				.razonSocialProveedor(builder.razonSocialProveedor)
				.numeroDocumentoCliente(builder.numeroDocumentoCliente).nombreCliente(builder.nombreCliente)
				.numeroFactura(builder.numeroFactura).codigoAutorizacion(builder.codigoAutorizacion)
				.fechaFactura(builder.fechaFactura).importeTotal(builder.importeTotalVenta)
				.importeIceIehdTasas(builder.importeIceIehdTasas).importeExento(builder.importeExento)
				.importeTasaCero(builder.importeTasaCero).subTotal(builder.subTotal).descuento(builder.descuento)
				.importeBase(builder.importeBase).debitoFiscal(builder.debitoFiscal)
				.codigoControl(builder.codigoControl).origenId(builder.origenId).estadoVentaId(builder.estadoVentaId)
				.estadoUsoId(builder.estadoUsoId).impuestoUsoId(builder.impuestoUsoId).periodoUso(builder.periodoUso)
				.nombreArchivoUso(builder.nombreArchivoUso).formularioId(builder.formularioId)
				.fechaRegistro(builder.fechaRegistro).usuarioUltimaModificacion(builder.usuarioUltimaModificacion)
				.fechaUltimaModificacion(builder.fechaUltimaModificacion).estadoId(builder.estadoId)
				.libroId(builder.libroId).modalidadId(builder.modalidadId).build();
		return venta;
	}

	public void recepcionAgrupada(VentaId pId, VentaRecepcionId pRecepcionId, VentaIfcProveedor pIfcProveedor,
			Long pFila, VentaNitProveedor pNitProveedor, VentaFechaFactura pFechaFactura, Long pNumeroFacturaDel,
			Long pNumeroFacturaHasta, VentaCodigoAutorizacion pCodigoAutorizacion, VentaImporteTotal pImporteTotalVenta,
			VentaUsuarioRegistro pUsuarioRegistro, VentaFechaRegistro pFechaRegistro, VentaOrigenId pOrigenId,
			VentaEstadoId pEstadoVenta) {

		this.usuarioUltimaModificacion = new VentaUsuarioUltimaModificacion(pUsuarioRegistro.value());
		this.fechaUltimaModificacion = new VentaFechaUltimaModificacion(LocalDateTime.now());

		this.record(new VentaAgrupadaDomainEvent(pId.value(), pFila, pId.value(), pRecepcionId.value(),
				pIfcProveedor.value(), pNitProveedor.value(), pFechaFactura.value(), pNumeroFacturaDel,
				pNumeroFacturaHasta, pCodigoAutorizacion.value(), pImporteTotalVenta.value(), pOrigenId.value(),
				pUsuarioRegistro.value(), pFechaRegistro.value(), usuarioUltimaModificacion.value(),
				fechaUltimaModificacion.value(), pEstadoVenta.value()));

	}

	public static Venta registro(VentaId id, VentaRecepcionId recepcionId, VentaIfcProveedor ifcProveedor,
			VentaNitProveedor nitProveedor, VentaRazonSocialProveedor razonSocialProveedor,
			VentaNumeroDocumentoCliente numeroDocumentoCliente, VentaNombreCliente nombreCliente,
			VentaNumeroFactura numeroFactura, VentaCodigoAutorizacion codigoAutorizacion,
			VentaFechaFactura fechaFactura, VentaImporteTotal importeTotalVenta, VentaCodigoControl codigoControl,
			VentaImporteBase importeBaseDf, VentaOrigenId origenId, VentaUsuarioRegistro usuarioRegistro,
			VentaConDerechoDf ventaConDerechoDf, VentaMarcaEspecialId ventaMarcaEspecialId,
			VentaDescuento ventaDescuento, VentaDebitoFiscal ventaDebitoFiscal,
			VentaImporteIceIehdTasas ventaImporteIceIehdTasas, VentaImporteTasaCero ventaImporteTasaCero,
			VentaImporteNoSujetoDf ventaImporteNoSujetoDf, VentaImporteExento ventaImporteExento,
			VentaSubTotal ventaSubTotal) {

		VentaEstadoUsoId estadoUsoId = new VentaEstadoUsoId(EstadoUsoId.REGISTRADO.value());
		VentaImpuestoUsoId impuestoUsoId = new VentaImpuestoUsoId(null);
		VentaSecuencia secuencia = new VentaSecuencia(null);
		VentaPeriodoUso periodoUso = new VentaPeriodoUso(null);
		VentaGestionUso gestionUso = new VentaGestionUso(null);
		VentaNombreFormularioUso nombreFormularioUso = new VentaNombreFormularioUso(null);
		VentaFormularioId formularioId = new VentaFormularioId(null);
		VentaLibroId libroId = new VentaLibroId(null);

		// Todo: revisar
		VentaModalidadId modalidadId = new VentaModalidadId("MAN");

		VentaEstadoVentaId estadoVentaId = new VentaEstadoVentaId(EstadoVentaId.VIGENTE.value());
		VentaFechaRegistro fechaRegistro = new VentaFechaRegistro(LocalDateTime.now());
		VentaFechaUltimaModificacion fechaUltimaModificacion = new VentaFechaUltimaModificacion(LocalDateTime.now());
		VentaUsuarioUltimaModificacion usuarioUltimaModificacion = new VentaUsuarioUltimaModificacion(
				usuarioRegistro.value());
		VentaEstadoId estadoId = new VentaEstadoId(ConstEstado.ESTADO_ACTIVO);

		// TODO: sergio.ichaso quitar
		VentaConDerechoDf vVentaConDerechoDf = new VentaConDerechoDf("SI");
		ventaMarcaEspecialId = new VentaMarcaEspecialId("SM");

		Venta venta = Venta.newVenta().id(id).recepcionId(recepcionId).secuencia(secuencia).ifcProveedor(ifcProveedor)
				.nitProveedor(nitProveedor).razonSocialProveedor(razonSocialProveedor)
				.numeroDocumentoCliente(numeroDocumentoCliente).nombreCliente(nombreCliente)
				.numeroFactura(numeroFactura).codigoAutorizacion(codigoAutorizacion).fechaFactura(fechaFactura)
				.importeTotal(importeTotalVenta).importeIceIehdTasas(ventaImporteIceIehdTasas)
				.importeExento(ventaImporteExento).importeTasaCero(ventaImporteTasaCero).subTotal(ventaSubTotal)
				.descuento(ventaDescuento).importeBase(importeBaseDf).debitoFiscal(ventaDebitoFiscal)
				.codigoControl(codigoControl).origenId(origenId).estadoVentaId(estadoVentaId).estadoUsoId(estadoUsoId)
				.impuestoUsoId(impuestoUsoId).periodoUso(periodoUso).nombreArchivoUso(nombreFormularioUso)
				.formularioId(formularioId).fechaRegistro(fechaRegistro).usuarioRegistro(usuarioRegistro)
				.usuarioUltimaModificacion(usuarioUltimaModificacion).fechaUltimaModificacion(fechaUltimaModificacion)
				.estadoId(estadoId).importeNoSujetoDf(ventaImporteNoSujetoDf).libroId(libroId).modalidadId(modalidadId)
				.conDerechoDf(vVentaConDerechoDf).marcaEspecialId(ventaMarcaEspecialId).gestionUso(gestionUso).build();

		return venta;
	}

	public void anularVenta(VentaUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		this.estadoVentaId = new VentaEstadoVentaId(EstadoVentaId.ANULADO.value());
		this.estadoId = new VentaEstadoId(ConstEstado.ESTADO_ANULADO);
		this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
		this.fechaUltimaModificacion = new VentaFechaUltimaModificacion(LocalDateTime.now());

	}

	public static Venta modificar(VentaId id, VentaRecepcionId recepcionId, VentaIfcProveedor ifcProveedor,
			VentaNitProveedor nitProveedor, VentaRazonSocialProveedor razonSocialProveedor,
			VentaNumeroDocumentoCliente numeroDocumentoCliente, VentaNombreCliente nombreCliente,
			VentaNumeroFactura numeroFactura, VentaCodigoAutorizacion codigoAutorizacion,
			VentaFechaFactura fechaFactura, VentaImporteTotal importeTotalVenta, VentaCodigoControl codigoControl,
			VentaImporteBase importeBaseDf, VentaOrigenId origenId, VentaUsuarioRegistro usuarioRegistro,
			VentaUsuarioUltimaModificacion usuarioUltimaModificacion, VentaConDerechoDf ventaConDerechoDf,
			VentaMarcaEspecialId ventaMarcaEspecialId, VentaDescuento ventaDescuento,
			VentaDebitoFiscal ventaDebitoFiscal, VentaImporteIceIehdTasas ventaImporteIceIehdTasas,
			VentaImporteTasaCero ventaImporteTasaCero, VentaImporteNoSujetoDf ventaImporteNoSujetoDf,
			VentaImporteExento ventaImporteExento, VentaSubTotal ventaSubTotal, VentaFechaRegistro ventaFechaRegistro,
			VentaModalidadId ventaModalidadId) {

		VentaSecuencia secuencia = new VentaSecuencia(null);
		VentaFechaUltimaModificacion fechaUltimaModificacion = new VentaFechaUltimaModificacion(LocalDateTime.now());
		VentaEstadoId estadoId = new VentaEstadoId(ConstEstado.ESTADO_ACTIVO);
		VentaEstadoUsoId estadoUsoId = new VentaEstadoUsoId(EstadoUsoId.REGISTRADO.value());
		VentaEstadoVentaId estadoVentaId = new VentaEstadoVentaId(EstadoVentaId.VIGENTE.value());

		VentaPeriodoUso periodoUso = new VentaPeriodoUso(null);
		VentaNombreFormularioUso nombreArchivoUso = new VentaNombreFormularioUso();
		VentaImpuestoUsoId impuestoUsoId = new VentaImpuestoUsoId(null);
		VentaFormularioId formularioId = new VentaFormularioId(null);
		VentaLibroId libroId = new VentaLibroId(null);

		Venta venta = Venta.newVenta().id(id).recepcionId(recepcionId).secuencia(secuencia).ifcProveedor(ifcProveedor)
				.nitProveedor(nitProveedor).razonSocialProveedor(razonSocialProveedor)
				.numeroDocumentoCliente(numeroDocumentoCliente).nombreCliente(nombreCliente)
				.numeroFactura(numeroFactura).codigoAutorizacion(codigoAutorizacion).fechaFactura(fechaFactura)
				.importeTotal(importeTotalVenta).importeIceIehdTasas(ventaImporteIceIehdTasas)
				.importeExento(ventaImporteExento).importeTasaCero(ventaImporteTasaCero).subTotal(ventaSubTotal)
				.descuento(ventaDescuento).importeBase(importeBaseDf).debitoFiscal(ventaDebitoFiscal)
				.codigoControl(codigoControl).origenId(origenId).estadoVentaId(estadoVentaId).estadoUsoId(estadoUsoId)
				.impuestoUsoId(impuestoUsoId).periodoUso(periodoUso).nombreArchivoUso(nombreArchivoUso)
				.formularioId(formularioId).fechaRegistro(ventaFechaRegistro).usuarioRegistro(usuarioRegistro)
				.usuarioUltimaModificacion(usuarioUltimaModificacion).fechaUltimaModificacion(fechaUltimaModificacion)
				.estadoId(estadoId).importeNoSujetoDf(ventaImporteNoSujetoDf).modalidadId(ventaModalidadId)
				.libroId(libroId).conDerechoDf(ventaConDerechoDf).marcaEspecialId(ventaMarcaEspecialId).build();
		return venta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Venta venta = (Venta) o;
		return Objects.equals(id, venta.id) && Objects.equals(recepcionId, venta.recepcionId)
				&& Objects.equals(secuencia, venta.secuencia) && Objects.equals(ifcProveedor, venta.ifcProveedor)
				&& Objects.equals(nitProveedor, venta.nitProveedor)
				&& Objects.equals(razonSocialProveedor, venta.razonSocialProveedor)
				&& Objects.equals(numeroDocumentoCliente, venta.numeroDocumentoCliente)
				&& Objects.equals(nombreCliente, venta.nombreCliente)
				&& Objects.equals(numeroFactura, venta.numeroFactura)
				&& Objects.equals(codigoAutorizacion, venta.codigoAutorizacion)
				&& Objects.equals(fechaFactura, venta.fechaFactura)
				&& Objects.equals(importeTotalVenta, venta.importeTotalVenta)
				&& Objects.equals(importeIceIehdTasas, venta.importeIceIehdTasas)
				&& Objects.equals(importeExento, venta.importeExento)
				&& Objects.equals(importeTasaCero, venta.importeTasaCero) && Objects.equals(subtotal, venta.subtotal)
				&& Objects.equals(importeBase, venta.importeBase) && Objects.equals(debitoFiscal, venta.debitoFiscal)
				&& Objects.equals(codigoControl, venta.codigoControl) && Objects.equals(descuento, venta.descuento)
				&& Objects.equals(origenId, venta.origenId) && Objects.equals(estadoVentaId, venta.estadoVentaId)
				&& Objects.equals(tipoDocumentoCliente, venta.tipoDocumentoCliente)
				&& Objects.equals(estadoUsoId, venta.estadoUsoId) && Objects.equals(impuestoUsoId, venta.impuestoUsoId)
				&& Objects.equals(periodoUso, venta.periodoUso)
				&& Objects.equals(nombreArchivoUso, venta.nombreArchivoUso)
				&& Objects.equals(formularioId, venta.formularioId)
				&& Objects.equals(usuarioRegistro, venta.usuarioRegistro)
				&& Objects.equals(fechaRegistro, venta.fechaRegistro)
				&& Objects.equals(usuarioUltimaModificacion, venta.usuarioUltimaModificacion)
				&& Objects.equals(fechaUltimaModificacion, venta.fechaUltimaModificacion)
				&& Objects.equals(estadoId, venta.estadoId) && Objects.equals(modalidadId, venta.modalidadId)
				&& Objects.equals(nombreFormularioUso, venta.nombreFormularioUso)
				&& Objects.equals(libroId, venta.libroId) && Objects.equals(conDerechoDf, venta.conDerechoDf)
				&& Objects.equals(marcaEspecialId, venta.marcaEspecialId)
				&& Objects.equals(complementoDocumentoCliente, venta.complementoDocumentoCliente)
				&& Objects.equals(gestionUso, venta.gestionUso)
				&& Objects.equals(importeNoSujetoDf, venta.importeNoSujetoDf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, recepcionId, secuencia, ifcProveedor, nitProveedor, razonSocialProveedor,
				numeroDocumentoCliente, nombreCliente, numeroFactura, codigoAutorizacion, fechaFactura,
				importeTotalVenta, importeIceIehdTasas, importeExento, importeTasaCero, subtotal, importeBase,
				debitoFiscal, codigoControl, descuento, origenId, estadoVentaId, tipoDocumentoCliente, estadoUsoId,
				impuestoUsoId, periodoUso, nombreArchivoUso, formularioId, usuarioRegistro, fechaRegistro,
				usuarioUltimaModificacion, fechaUltimaModificacion, estadoId, modalidadId, nombreFormularioUso, libroId,
				conDerechoDf, marcaEspecialId, complementoDocumentoCliente, gestionUso, importeNoSujetoDf);
	}

	public static final class Builder {
		private VentaId id;
		private VentaRecepcionId recepcionId;
		private VentaSecuencia secuencia;
		private VentaIfcProveedor ifcProveedor;
		private VentaNitProveedor nitProveedor;
		private VentaRazonSocialProveedor razonSocialProveedor;
		private VentaNumeroDocumentoCliente numeroDocumentoCliente;
		private VentaNombreCliente nombreCliente;
		private VentaNumeroFactura numeroFactura;
		private VentaCodigoAutorizacion codigoAutorizacion;
		private VentaFechaFactura fechaFactura;
		private VentaImporteTotal importeTotalVenta;
		private VentaImporteIceIehdTasas importeIceIehdTasas;
		private VentaImporteExento importeExento;
		private VentaImporteTasaCero importeTasaCero;
		private VentaSubTotal subTotal;
		private VentaImporteBase importeBase;
		private VentaImporteNoSujetoDf importeNoSujetoDf;
		private VentaModalidadId modalidadId;
		private VentaLibroId libroId;
		private VentaConDerechoDf conDerechoDf;
		private VentaMarcaEspecialId marcaEspecialId;
		private VentaNombreFormularioUso nombreFormularioUso;
		private VentaDebitoFiscal debitoFiscal;
		private VentaCodigoControl codigoControl;
		private VentaDescuento descuento;
		private VentaOrigenId origenId;
		private VentaEstadoVentaId estadoVentaId;
		private VentaLibroId tipoDocumentoCliente;
		private VentaEstadoUsoId estadoUsoId;
		private VentaImpuestoUsoId impuestoUsoId;
		private VentaPeriodoUso periodoUso;
		private VentaNombreFormularioUso nombreArchivoUso;
		private VentaFormularioId formularioId;
		private VentaUsuarioRegistro usuarioRegistro;
		private VentaFechaRegistro fechaRegistro;
		private VentaUsuarioUltimaModificacion usuarioUltimaModificacion;
		private VentaFechaUltimaModificacion fechaUltimaModificacion;

		private VentaModalidadId complementoDocumentoCliente;
		private VentaGestionUso gestionUso;
		private VentaEstadoId estadoId;

		private Builder() {
		}

		public Venta build() {
			return new Venta(this);
		}

		public Builder id(VentaId id) {
			this.id = id;
			return this;
		}

		public Builder gestionUso(VentaGestionUso gestionUso) {
			this.gestionUso = gestionUso;
			return this;
		}

		public Builder estadoId(VentaEstadoVentaId estadoVentaId) {
			this.estadoVentaId = estadoVentaId;
			return this;
		}

		public Builder recepcionId(VentaRecepcionId recepcionId) {
			this.recepcionId = recepcionId;
			return this;
		}

		public Builder secuencia(VentaSecuencia secuencia) {
			this.secuencia = secuencia;
			return this;
		}

		public Builder ifcProveedor(VentaIfcProveedor ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
			return this;
		}

		public Builder nitProveedor(VentaNitProveedor nitProveedor) {
			this.nitProveedor = nitProveedor;
			return this;
		}

		public Builder razonSocialProveedor(VentaRazonSocialProveedor razonSocialProveedor) {
			this.razonSocialProveedor = razonSocialProveedor;
			return this;
		}

		public Builder numeroDocumentoCliente(VentaNumeroDocumentoCliente numeroDocumentoCliente) {
			this.numeroDocumentoCliente = numeroDocumentoCliente;
			return this;
		}

		public Builder nombreCliente(VentaNombreCliente nombreCliente) {
			this.nombreCliente = nombreCliente;
			return this;
		}

		public Builder numeroFactura(VentaNumeroFactura numeroFactura) {
			this.numeroFactura = numeroFactura;
			return this;
		}

		public Builder codigoAutorizacion(VentaCodigoAutorizacion codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			return this;
		}

		public Builder fechaFactura(VentaFechaFactura fechaFactura) {
			this.fechaFactura = fechaFactura;
			return this;
		}

		public Builder importeTotal(VentaImporteTotal importeTotal) {
			this.importeTotalVenta = importeTotal;
			return this;
		}

		public Builder importeIceIehdTasas(VentaImporteIceIehdTasas importeIceIehdTasas) {
			this.importeIceIehdTasas = importeIceIehdTasas;
			return this;
		}

		public Builder modalidadId(VentaModalidadId modalidadId) {
			this.modalidadId = modalidadId;
			return this;
		}

		public Builder nombreFormularioUso(VentaNombreFormularioUso nombreFormularioUso) {
			this.nombreFormularioUso = nombreFormularioUso;
			return this;
		}

		public Builder importeNoSujetoDf(VentaImporteNoSujetoDf importeNoSujetoDf) {
			this.importeNoSujetoDf = importeNoSujetoDf;
			return this;
		}

		public Builder conDerechoDf(VentaConDerechoDf conDerechoDf) {
			this.conDerechoDf = conDerechoDf;
			return this;
		}

		public Builder marcaEspecialId(VentaMarcaEspecialId marcaEspecialId) {
			this.marcaEspecialId = marcaEspecialId;
			return this;
		}

		public Builder importeExento(VentaImporteExento importeExento) {
			this.importeExento = importeExento;
			return this;
		}

		public Builder importeTasaCero(VentaImporteTasaCero importeTasaCero) {
			this.importeTasaCero = importeTasaCero;
			return this;
		}

		public Builder subTotal(VentaSubTotal subTotal) {
			this.subTotal = subTotal;
			return this;
		}

		public Builder importeBase(VentaImporteBase importeBase) {
			this.importeBase = importeBase;
			return this;
		}

		public Builder debitoFiscal(VentaDebitoFiscal debitoFiscal) {
			this.debitoFiscal = debitoFiscal;
			return this;
		}

		public Builder codigoControl(VentaCodigoControl codigoControl) {
			this.codigoControl = codigoControl;
			return this;
		}

		public Builder descuento(VentaDescuento descuento) {
			this.descuento = descuento;
			return this;
		}

		public Builder origenId(VentaOrigenId origenId) {
			this.origenId = origenId;
			return this;
		}

		public Builder estadoVentaId(VentaEstadoVentaId estadoVentaId) {
			this.estadoVentaId = estadoVentaId;
			return this;
		}

		public Builder tipoDocumentoCliente(VentaLibroId tipoDocumentoCliente) {
			this.tipoDocumentoCliente = tipoDocumentoCliente;
			return this;
		}

		public Builder estadoUsoId(VentaEstadoUsoId estadoUsoId) {
			this.estadoUsoId = estadoUsoId;
			return this;
		}

		public Builder impuestoUsoId(VentaImpuestoUsoId impuestoUsoId) {
			this.impuestoUsoId = impuestoUsoId;
			return this;
		}

		public Builder periodoUso(VentaPeriodoUso periodoUso) {
			this.periodoUso = periodoUso;
			return this;
		}

		public Builder nombreArchivoUso(VentaNombreFormularioUso nombreArchivoUso) {
			this.nombreArchivoUso = nombreArchivoUso;
			return this;
		}

		public Builder formularioId(VentaFormularioId formularioId) {
			this.formularioId = formularioId;
			return this;
		}

		public Builder usuarioRegistro(VentaUsuarioRegistro usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder fechaRegistro(VentaFechaRegistro fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public Builder libroId(VentaLibroId libroId) {
			this.libroId = libroId;
			return this;
		}

		public Builder usuarioUltimaModificacion(VentaUsuarioUltimaModificacion usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public Builder fechaUltimaModificacion(VentaFechaUltimaModificacion fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public Builder estadoId(VentaEstadoId estadoId) {
			this.estadoId = estadoId;
			return this;
		}

		public Builder complementoDocumentoCliente(VentaModalidadId complementoDocumentoCliente) {
			this.complementoDocumentoCliente = complementoDocumentoCliente;
			return this;
		}
	}
}
