package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.EnumTipoFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.*;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.str.constantes.estado.ConstEstado;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Compra extends AggregateRoot {
    private final CompraId id;
    private CompraIfcProveedorNb ifcProveedorNb;
    private CompraNitProveedor nitProveedor;
    private CompraRazonSocialProveedor razonSocialProveedor;
    private CompraNumeroFactura numeroFactura;
    private CompraNumeroDui numeroDui;
    private CompraCodigoAutorizacion codigoAutorizacion;
    private CompraFechaFactura fechaFactura;
    private CompraImporteTotalCompra importeTotalCompra;
    private CompraImporteNoSujetoCf importeNoSujetoCf;
    private CompraSubtotal subtotal;
    private CompraDescuento descuento;
    private CompraImporteBaseCf importeBaseCf;
    private CompraCreditoFiscal creditoFiscal;
    private CompraCodigoControl codigoControl;
    private CompraTipoDocumentoId tipoDocumentoId;
    private CompraTipoSectorId tipoSectorId;
    private CompraModalidadId modalidadId;
    private CompraEstadoCompraId estadoCompraId;
    private CompraTipoDocumentoCliente tipoDocumentoCliente;
    private CompraNumeroDocumentoCliente numeroDocumentoCliente;
    private CompraComplementoDocumentoCliente complementoDocumentoCliente;
    private CompraNombreCliente nombreCliente;
    private CompraOrigenId origenId;
    private CompraEstadoUsoId estadoUsoId;
    private CompraImpuestoUsoId impuestoUsoId;
    private CompraGestionUso gestionUso;
    private CompraPeriodoUso periodoUso;
    private CompraNombreFormularioUso nombreFormularioUso;
    private CompraFormularioId formularioId;
    private CompraLibroId libroId;
    private CompraVentaId ventaId;
    private CompraRecepcionId recepcionId;
    private CompraSecuencia secuencia;

    private CompraConDerechoCf conDerechoCf;
    private CompraTipoCompraId tipoCompraId;
    private CompraTipoObservacionId tipoObservacionId;
    private CompraMarcaEspecialId marcaEspecialId;

    private CompraUsuarioRegistro usuarioRegistro;
    private CompraFechaRegistro fechaRegistro;
    private CompraUsuarioUltimaModificacion usuarioUltimaModificacion;
    private CompraFechaUltimaModificacion fechaUltimaModificacion;
    private CompraEstadoId estadoId;

    private Compra(Builder builder) {
        this.id = builder.id;
        this.ifcProveedorNb = builder.ifcProveedorNb;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.numeroFactura = builder.numeroFactura;
        this.numeroDui = builder.numeroDui;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaFactura = builder.fechaFactura;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeNoSujetoCf = builder.importeNoSujetoCf;
        this.subtotal = builder.subtotal;
        this.descuento = builder.descuento;
        this.importeBaseCf = builder.importeBaseCf;
        this.creditoFiscal = builder.creditoFiscal;
        this.codigoControl = builder.codigoControl;
        this.tipoDocumentoId = builder.tipoDocumentoId;
        this.tipoSectorId = builder.tipoSectorId;

        this.modalidadId = builder.modalidadId;

        this.estadoCompraId = builder.estadoCompraId;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.nombreCliente = builder.nombreCliente;
        this.origenId = builder.origenId;
        this.estadoUsoId = builder.estadoUsoId;
        this.impuestoUsoId = builder.impuestoUsoId;
        this.gestionUso = builder.gestionUso;
        this.periodoUso = builder.periodoUso;
        this.nombreFormularioUso = builder.nombreFormularioUso;
        this.formularioId = builder.formularioId;
        this.libroId = builder.libroId;
        this.ventaId = builder.ventaId;
        this.recepcionId = builder.recepcionId;
        this.secuencia = builder.secuencia;

        this.conDerechoCf = builder.conDerechoCf;
        this.tipoCompraId = builder.tipoCompraId;
        this.tipoObservacionId = builder.tipoObservacionId;
        this.marcaEspecialId = builder.marcaEspecialId;

        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
    }

    public static Builder newCompra() {
        return new Builder();
    }



    public CompraConDerechoCf conDerechoCf() {
        return conDerechoCf;
    }

    public CompraTipoCompraId tipoCompraId() {
        return tipoCompraId;
    }

    public CompraTipoObservacionId tipoObservacionId() {
        return tipoObservacionId;
    }

    public CompraMarcaEspecialId marcaEspecialId() {
        return marcaEspecialId;
    }

    public CompraImporteNoSujetoCf importeNoSujetoCf() {
        return importeNoSujetoCf;
    }

    public CompraModalidadId modalidadId() {
        return modalidadId;
    }

    public CompraSecuencia secuencia() {
        return secuencia;
    }

    public CompraIfcProveedorNb ifcProveedorNb() {
        return ifcProveedorNb;
    }

    public CompraNombreCliente nombreCliente() {
        return nombreCliente;
    }

    public CompraOrigenId origenId() {
        return origenId;
    }

    public CompraTipoDocumentoCliente tipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public CompraNumeroDocumentoCliente numeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public CompraComplementoDocumentoCliente complementoDocumentoCliente() {
        return complementoDocumentoCliente;
    }

    public CompraEstadoId estadoId() {
        return estadoId;
    }

    public CompraId id() {
        return id;
    }

    public CompraRecepcionId recepcionId() {
        return recepcionId;
    }

    public CompraTipoDocumentoId tipoDocumentoId() {
        return tipoDocumentoId;
    }

    public CompraFechaFactura fechaFactura() {
        return fechaFactura;
    }

    public CompraNitProveedor nitProveedor() {
        return nitProveedor;
    }

    public CompraRazonSocialProveedor razonSocialProveedor() {
        return razonSocialProveedor;
    }

    public CompraNumeroFactura numeroFactura() {
        return numeroFactura;
    }

    public CompraNumeroDui numeroDui() {
        return numeroDui;
    }

    public CompraCodigoAutorizacion codigoAutorizacion() {
        return codigoAutorizacion;
    }

    public CompraImporteTotalCompra importeTotalCompra() {
        return importeTotalCompra;
    }


    public CompraSubtotal subtotal() {
        return subtotal;
    }

    public CompraDescuento descuento() {
        return descuento;
    }

    public CompraImporteBaseCf importeBaseCf() {
        return importeBaseCf;
    }

    public CompraCreditoFiscal creditoFiscal() {
        return creditoFiscal;
    }

    public CompraCodigoControl codigoControl() {
        return codigoControl;
    }

    public CompraTipoSectorId tipoSectorId() {
        return tipoSectorId;
    }

    public CompraEstadoCompraId estadoCompraId() {
        return estadoCompraId;
    }

    public CompraEstadoUsoId estadoUsoId() {
        return estadoUsoId;
    }

    public CompraImpuestoUsoId impuestoUsoId() {
        return impuestoUsoId;
    }

    public CompraPeriodoUso periodoUso() {
        return periodoUso;
    }

    public CompraNombreFormularioUso nombreFormularioUso() {
        return nombreFormularioUso;
    }

    public CompraFormularioId formularioId() {
        return formularioId;
    }

    public CompraVentaId ventaId() {
        return ventaId;
    }

    public CompraUsuarioRegistro usuarioRegistro() {
        return usuarioRegistro;
    }

    public CompraFechaRegistro fechaRegistro() {
        return fechaRegistro;
    }

    public CompraUsuarioUltimaModificacion usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public CompraFechaUltimaModificacion fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public CompraLibroId libroId() {
        return libroId;
    }

    public CompraGestionUso gestionUso() {
        return gestionUso;
    }

    public Compra() {
        this.id = null;
    }

    // Registro individal compra Compra Individual

    public static Compra registro(CompraId id, CompraFechaFactura fechaFactura, CompraIfcProveedorNb ifcProveedorNb,
                                  CompraNitProveedor nitProveedor, CompraRazonSocialProveedor razonSocialProveedor,
                                  CompraNumeroFactura numeroFactura, CompraCodigoAutorizacion codigoAutorizacion,
                                  CompraImporteTotalCompra importeTotalCompra, CompraImporteBaseCf importeBaseCf,
                                  CompraCodigoControl codigoControl, CompraUsuarioRegistro usuarioRegistro,
                                  CompraNombreCliente nombreCliente, CompraTipoDocumentoCliente tipoDocumentoCliente,
                                  CompraNumeroDocumentoCliente numeroDocumentoCliente,
                                  CompraComplementoDocumentoCliente complementoDocumentoCliente, CompraOrigenId origenId,
                                  CompraModalidadId modalidadId, CompraCreditoFiscal creditoFiscal, CompraMarcaEspecialId marcaEspecialId, CompraConDerechoCf pConDerechoCf, CompraTipoSectorId pTipoSectorId) {

        CompraImporteBaseCf vImporteBaseCf = CompraImporteBaseCf.ajusteImporteBaseCf(pConDerechoCf, importeBaseCf);
        CompraImporteNoSujetoCf importeNoSujetoCf = new CompraImporteNoSujetoCf(BigDecimal.ZERO);
        CompraDescuento descuento = new CompraDescuento(BigDecimal.ZERO);
        CompraTipoCompraId tipoCompraId = new CompraTipoCompraId(null);
        return registro(id, fechaFactura, ifcProveedorNb, nitProveedor, razonSocialProveedor, numeroFactura,
                codigoAutorizacion, importeTotalCompra, vImporteBaseCf, codigoControl, usuarioRegistro, nombreCliente,
                tipoDocumentoCliente, numeroDocumentoCliente, complementoDocumentoCliente, origenId, importeNoSujetoCf,
                descuento, tipoCompraId, modalidadId, creditoFiscal, marcaEspecialId, pConDerechoCf, pTipoSectorId);
    }

    public static Compra registro(CompraId id, CompraFechaFactura fechaFactura, CompraIfcProveedorNb ifcProveedorNb,
                                  CompraNitProveedor nitProveedor, CompraRazonSocialProveedor razonSocialProveedor,
                                  CompraNumeroFactura numeroFactura, CompraCodigoAutorizacion codigoAutorizacion,
                                  CompraImporteTotalCompra importeTotalCompra, CompraImporteBaseCf importeBaseCf,
                                  CompraCodigoControl codigoControl, CompraUsuarioRegistro usuarioRegistro,
                                  CompraNombreCliente nombreCliente, CompraTipoDocumentoCliente tipoDocumentoCliente,
                                  CompraNumeroDocumentoCliente numeroDocumentoCliente,
                                  CompraComplementoDocumentoCliente complementoDocumentoCliente, CompraOrigenId origenId,
                                  CompraImporteNoSujetoCf importeNoSujetoCf, CompraDescuento descuento, CompraTipoCompraId tipoCompraId,
                                  CompraModalidadId modalidadId, CompraCreditoFiscal creditoFiscal, CompraMarcaEspecialId marcaEspecialId,
                                  CompraConDerechoCf pConDerechoCf,
                                  CompraTipoSectorId pTipoSectorId) {
        CompraTipoDocumentoId tipoDocumentoId = new CompraTipoDocumentoId(TipoDocumentoId.FACTURA.value());
        CompraNumeroDui numeroDui = new CompraNumeroDui(NumeroDui.ZERO.value());
        CompraSubtotal subtotal = new CompraSubtotal(BigDecimal.ZERO);
        CompraEstadoCompraId estadoCompraId = new CompraEstadoCompraId(EstadoCompraId.VIGENTE.value());
        CompraEstadoUsoId estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.REGISTRADO.value());
        CompraImpuestoUsoId impuestoUsoId = new CompraImpuestoUsoId(null);
        CompraGestionUso gestionUso = new CompraGestionUso(null);
        CompraPeriodoUso periodoUso = new CompraPeriodoUso(null);
        CompraNombreFormularioUso nombreFormularioUso = new CompraNombreFormularioUso(null);
        CompraFormularioId formularioId = new CompraFormularioId(null);
        CompraLibroId libroId = new CompraLibroId(null);
        CompraVentaId ventaId = new CompraVentaId(null);
        CompraRecepcionId recepcionId = new CompraRecepcionId(null);
        CompraSecuencia secuencia = new CompraSecuencia(null);
        CompraConDerechoCf conDerechoCf = new CompraConDerechoCf(pConDerechoCf.value());
        CompraTipoObservacionId tipoObservacionId = new CompraTipoObservacionId(null);
        CompraFechaRegistro fechaRegistro = new CompraFechaRegistro(LocalDateTime.now());
        CompraUsuarioUltimaModificacion usuarioUltimaModificacion = new CompraUsuarioUltimaModificacion(usuarioRegistro.value());
        CompraFechaUltimaModificacion fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        CompraEstadoId estadoId = new CompraEstadoId(ConstEstado.ESTADO_ACTIVO);
        Compra compra = newCompra().id(id).ifcProveedorNb(ifcProveedorNb).nitProveedor(nitProveedor)
                .razonSocialProveedor(razonSocialProveedor).numeroFactura(numeroFactura).numeroDui(numeroDui)
                .codigoAutorizacion(codigoAutorizacion).fechaFactura(fechaFactura)
                .importeTotalCompra(importeTotalCompra).importeNoSujetoCf(importeNoSujetoCf).subtotal(subtotal)
                .descuento(descuento).importeBaseCf(importeBaseCf).creditoFiscal(creditoFiscal)
                .codigoControl(codigoControl).tipoDocumentoId(tipoDocumentoId).tipoSectorId(pTipoSectorId)
                .modalidadId(modalidadId).estadoCompraId(estadoCompraId).tipoDocumentoCliente(tipoDocumentoCliente)
                .numeroDocumentoCliente(numeroDocumentoCliente).complementoDocumentoCliente(complementoDocumentoCliente)
                .nombreCliente(nombreCliente).origenId(origenId).estadoUsoId(estadoUsoId).impuestoUsoId(impuestoUsoId)
                .gestionUso(gestionUso).periodoUso(periodoUso).nombreFormularioUso(nombreFormularioUso)
                .formularioId(formularioId).libroId(libroId).ventaId(ventaId).recepcionId(recepcionId)
                .secuencia(secuencia).conDerechoCf(conDerechoCf).tipoCompraId(tipoCompraId)
                .tipoObservacionId(tipoObservacionId).marcaEspecialId(marcaEspecialId).usuarioRegistro(usuarioRegistro)
                .fechaRegistro(fechaRegistro).usuarioUltimaModificacion(usuarioUltimaModificacion)
                .fechaUltimaModificacion(fechaUltimaModificacion).estadoId(estadoId).build();
        return compra;
    }


    public static Compra registroCompraLibro(
            CompraId pId,
            CompraIfcProveedorNb pIfcProveedorNb,
            CompraNitProveedor pNitProveedor,
            CompraRazonSocialProveedor pRazonSocialProveedor,
            CompraNumeroFactura pNumeroFactura,
            CompraNumeroDui pNumeroDui,
            CompraCodigoAutorizacion pCodigoAutorizacion,
            CompraFechaFactura pFechaFactura,
            CompraImporteTotalCompra pImporteTotalCompra,
            CompraImporteNoSujetoCf pImporteNoSujetoCf,
            CompraDescuento pDescuento,
            CompraImporteBaseCf pImporteBaseCf,
            CompraCreditoFiscal pCreditoFiscal,
            CompraCodigoControl pCodigoControl,
            CompraTipoDocumentoCliente pTipoDocumentoCliente,
            CompraNumeroDocumentoCliente pNumeroDocumentoCliente,
            CompraComplementoDocumentoCliente pComplementoDocumentoCliente,
            CompraNombreCliente pNombreCliente,
            CompraOrigenId pOrigenId,
            CompraModalidadId pModalidadId,
            CompraMarcaEspecialId pMarcaEspecialId,
            CompraUsuarioRegistro pUsuarioRegistro,
            CompraConDerechoCf pConDerechoCf) {

        CompraSubtotal subtotal = CompraSubtotal.subTotal(pImporteTotalCompra.value(), pImporteNoSujetoCf.value());
        CompraTipoDocumentoId tipoDocumentoId = new CompraTipoDocumentoId(TipoDocumentoId.FACTURA.value());
        CompraTipoSectorId tipoSectorId = new CompraTipoSectorId(null);
        CompraEstadoCompraId estadoCompraId = new CompraEstadoCompraId(EstadoCompraId.VIGENTE.value());
        CompraEstadoUsoId estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.REGISTRADO.value());
        CompraImpuestoUsoId impuestoUsoId = new CompraImpuestoUsoId(null);
        CompraGestionUso gestionUso = new CompraGestionUso(null);
        CompraPeriodoUso periodoUso = new CompraPeriodoUso(null);
        CompraNombreFormularioUso nombreFormularioUso = new CompraNombreFormularioUso(null);
        CompraFormularioId formularioId = new CompraFormularioId(null);
        CompraLibroId libroId = new CompraLibroId(null);
        CompraVentaId ventaId = new CompraVentaId(null);
        CompraRecepcionId recepcionId = new CompraRecepcionId(null);
        CompraSecuencia secuencia = new CompraSecuencia(null);
        CompraConDerechoCf conDerechoCf = new CompraConDerechoCf(pConDerechoCf.value());
        CompraTipoCompraId tipoCompraId = new CompraTipoCompraId(null);
        CompraTipoObservacionId tipoObservacionId = new CompraTipoObservacionId(null);
        CompraFechaRegistro fechaRegistro = new CompraFechaRegistro(LocalDateTime.now());
        CompraUsuarioUltimaModificacion usuarioUltimaModificacion = new CompraUsuarioUltimaModificacion(pUsuarioRegistro.value());
        CompraFechaUltimaModificacion fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        CompraEstadoId estadoId = new CompraEstadoId(ConstEstado.ESTADO_ACTIVO);

        Compra compra = newCompra().id(pId).ifcProveedorNb(pIfcProveedorNb).nitProveedor(pNitProveedor)
                .razonSocialProveedor(pRazonSocialProveedor).numeroFactura(pNumeroFactura).numeroDui(pNumeroDui)
                .codigoAutorizacion(pCodigoAutorizacion).fechaFactura(pFechaFactura)
                .importeTotalCompra(pImporteTotalCompra).importeNoSujetoCf(pImporteNoSujetoCf).subtotal(subtotal)
                .descuento(pDescuento).importeBaseCf(pImporteBaseCf).creditoFiscal(pCreditoFiscal)
                .codigoControl(pCodigoControl).tipoDocumentoId(tipoDocumentoId).tipoSectorId(tipoSectorId)
                .modalidadId(pModalidadId).estadoCompraId(estadoCompraId).tipoDocumentoCliente(pTipoDocumentoCliente)
                .numeroDocumentoCliente(pNumeroDocumentoCliente)
                .complementoDocumentoCliente(pComplementoDocumentoCliente).nombreCliente(pNombreCliente)
                .origenId(pOrigenId).estadoUsoId(estadoUsoId).impuestoUsoId(impuestoUsoId).gestionUso(gestionUso)
                .periodoUso(periodoUso).nombreFormularioUso(nombreFormularioUso).formularioId(formularioId)
                .libroId(libroId).ventaId(ventaId).recepcionId(recepcionId).secuencia(secuencia)
                .conDerechoCf(conDerechoCf).tipoCompraId(tipoCompraId).tipoObservacionId(tipoObservacionId)
                .marcaEspecialId(pMarcaEspecialId).usuarioRegistro(pUsuarioRegistro).fechaRegistro(fechaRegistro)
                .usuarioUltimaModificacion(usuarioUltimaModificacion).fechaUltimaModificacion(fechaUltimaModificacion)
                .estadoId(estadoId).build();
        return compra;
    }

    public static Compra registro(Builder builder) {
        Compra compra = newCompra().id(builder.id).ifcProveedorNb(builder.ifcProveedorNb)
                .nitProveedor(builder.nitProveedor).razonSocialProveedor(builder.razonSocialProveedor)
                .numeroFactura(builder.numeroFactura).numeroDui(builder.numeroDui)
                .codigoAutorizacion(builder.codigoAutorizacion).fechaFactura(builder.fechaFactura)
                .importeTotalCompra(builder.importeTotalCompra).importeNoSujetoCf(builder.importeNoSujetoCf)
                .subtotal(builder.subtotal).descuento(builder.descuento).importeBaseCf(builder.importeBaseCf)
                .creditoFiscal(builder.creditoFiscal).codigoControl(builder.codigoControl)
                .tipoDocumentoId(builder.tipoDocumentoId).tipoSectorId(builder.tipoSectorId)
                .modalidadId(builder.modalidadId).estadoCompraId(builder.estadoCompraId)
                .tipoDocumentoCliente(builder.tipoDocumentoCliente)
                .numeroDocumentoCliente(builder.numeroDocumentoCliente)
                .complementoDocumentoCliente(builder.complementoDocumentoCliente).nombreCliente(builder.nombreCliente)
                .origenId(builder.origenId).estadoUsoId(builder.estadoUsoId).impuestoUsoId(builder.impuestoUsoId)
                .gestionUso(builder.gestionUso).periodoUso(builder.periodoUso)
                .nombreFormularioUso(builder.nombreFormularioUso).formularioId(builder.formularioId)
                .libroId(builder.libroId).ventaId(builder.ventaId).recepcionId(builder.recepcionId)
                .secuencia(builder.secuencia).conDerechoCf(builder.conDerechoCf).tipoCompraId(builder.tipoCompraId)
                .tipoObservacionId(builder.tipoObservacionId).marcaEspecialId(builder.marcaEspecialId)
                .usuarioRegistro(builder.usuarioRegistro).fechaRegistro(builder.fechaRegistro)
                .usuarioUltimaModificacion(builder.usuarioUltimaModificacion)
                .fechaUltimaModificacion(builder.fechaUltimaModificacion).estadoId(builder.estadoId).build();
        return compra;
    }

    public void calcularImpuesto(String pTipoFormularioId) {
        if (pTipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_111.value())) {
            this.impuestoUsoId = new CompraImpuestoUsoId(ImpuestoUsoId.RCIVA.value());
        }
        if (pTipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_110.value())) {
            this.impuestoUsoId = new CompraImpuestoUsoId(ImpuestoUsoId.RCIVA.value());
        }
        if (pTipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_110_AF610.value())) {

            this.impuestoUsoId = new CompraImpuestoUsoId(ImpuestoUsoId.RCIVA.value());
        }
        if (pTipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_110_AF510.value())) {

            this.impuestoUsoId = new CompraImpuestoUsoId(ImpuestoUsoId.IUE.value());
        }
        if (pTipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_110_AF702.value())) {
            if (this.marcaEspecialId != null && this.marcaEspecialId.value().equals(EnumMarcaEspecialId.IPN.value())) {
                this.creditoFiscal = CompraCreditoFiscal.creditoFiscal(this.importeBaseCf.value(),
                        Utils.IMPUESTO_IPN_STI);
            } else if (this.marcaEspecialId != null
                    && this.marcaEspecialId.value().equals(EnumMarcaEspecialId.SIETERG.value())) {
                this.creditoFiscal = CompraCreditoFiscal.creditoFiscal(this.importeTotalCompra.value(),
                        Utils.IMPUESTO_7RG);
            } else {
                this.creditoFiscal = CompraCreditoFiscal.creditoFiscal(this.importeBaseCf.value(), Utils.IMPUESTO_STI);
            }

            this.impuestoUsoId = new CompraImpuestoUsoId(ImpuestoUsoId.IVA.value());
        }
        if (pTipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_111.value())) {
            this.creditoFiscal = CompraCreditoFiscal.creditoFiscal(this.importeBaseCf.value(), Utils.IMPUESTO_RRIVA);
            this.impuestoUsoId = new CompraImpuestoUsoId(ImpuestoUsoId.RRIVA.value());
        }

    }

    public void calcularImpuestoLibro() {
        this.creditoFiscal = CompraCreditoFiscal.creditoFiscal(this.importeBaseCf.value(), Utils.IMPUESTO_IVA);
    }

    // Asigancion de formulario
    public void asignarAFormulario(CompraFormularioId pFormularioId,
                                   CompraPeriodoUso pPeriodoUso,
                                   CompraNombreFormularioUso pNombreFormularioUso,
                                   CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                                   CompraGestionUso pGestionUso,
                                   String pTipoFormularioId) {

        if (this.estadoUsoId.value().equals(EstadoUsoId.REGISTRADO.value())) {
            this.record(
                    new CompraAsignadaDomainEvent(
                            this.id.value(),
                            this.formularioId != null ? this.formularioId.value() : null,
                            this.estadoUsoId != null ? this.estadoUsoId.value() : null,
                            this.periodoUso != null ? this.periodoUso.value() : null,
                            this.gestionUso != null ? this.gestionUso.value() : null,
                            this.impuestoUsoId != null ? this.impuestoUsoId.value() : null,
                            this.usuarioUltimaModificacion != null ? this.usuarioUltimaModificacion.value() : null,
                            this.fechaUltimaModificacion != null ? this.fechaUltimaModificacion.value() : null,
                            this.nombreFormularioUso != null ? this.nombreFormularioUso.value() : null,
                            this.importeBaseCf != null ? this.importeBaseCf.value() : null,
                            this.creditoFiscal != null ? this.creditoFiscal.value() : null,
                            this.importeTotalCompra != null ? this.importeTotalCompra.value() : null,
                            this.marcaEspecialId != null ? this.marcaEspecialId.value() : null,
                            this.modalidadId != null ? this.modalidadId.value() : null));
            this.gestionUso = pGestionUso;
            this.periodoUso = pPeriodoUso;
            this.nombreFormularioUso = pNombreFormularioUso;
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.ASOCIADO.value());
            this.formularioId = pFormularioId;
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
            calcularImpuesto(pTipoFormularioId);
        }

    }

    // Des asignar compra del formulario
    public void desAsignarAFormulario(CompraFormularioId formularioId,
                                      CompraUsuarioUltimaModificacion usuarioUltimaModificacion) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.ASOCIADO.value())) {
            this.record(
                    new CompraDesAsignadaDomainEvent(this.id.value(),
                            this.formularioId.value(),
                            this.estadoUsoId.value(),
                            this.periodoUso.value(),
                            this.gestionUso.value(),
                            this.impuestoUsoId.value(),
                            this.usuarioUltimaModificacion.value(),
                            this.fechaUltimaModificacion.value(),
                            this.nombreFormularioUso.value(),
                            this.importeBaseCf.value(),
                            this.creditoFiscal.value(),
                            this.importeTotalCompra.value(),
                            this.marcaEspecialId.value(),
                            this.modalidadId.value()));

            this.periodoUso = new CompraPeriodoUso(null);
            this.gestionUso = new CompraGestionUso(null);
            this.nombreFormularioUso = new CompraNombreFormularioUso(null);
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.REGISTRADO.value());
            this.formularioId = new CompraFormularioId(null);
            this.impuestoUsoId = new CompraImpuestoUsoId(null);
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());

        }

    }


    public void asociarALibro(CompraLibroId pLibrooId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                              CompraPeriodoUso pPeriodoUso, CompraGestionUso pGestionUso, CompraNombreFormularioUso pNombreLibroUso) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.REGISTRADO.value())) {
            String marcaEspecial = this.marcaEspecialId != null ? this.marcaEspecialId.value() : "";
            //TODO Arreglar el evento de dominio
            this.record(new CompraAsociadaLibroDomainEvent(this.id.value(),
                    this.libroId==null?null:this.libroId.value(),
                    this.usuarioUltimaModificacion.value(),
                    this.fechaUltimaModificacion.value(),
                    this.estadoUsoId.value(),
                    this.periodoUso ==null? null:this.periodoUso.value(),
                    this.gestionUso ==null? null:this.gestionUso.value(),
                    this.impuestoUsoId==null?null:this.impuestoUsoId.value(),
                    this.nombreFormularioUso==null?null:this.nombreFormularioUso.value(),
                    this.importeBaseCf.value(),
                    this.creditoFiscal.value(),
                    this.importeTotalCompra.value(), marcaEspecial,
                    this.modalidadId.value()));
            this.libroId = pLibrooId;
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.ASOCIADO.value());
            this.periodoUso = pPeriodoUso;
            this.gestionUso = pGestionUso;
            this.nombreFormularioUso = pNombreLibroUso;

            this.impuestoUsoId = new CompraImpuestoUsoId("IVA");
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        }
    }

    public void desAsociarLibro(CompraLibroId libroId, CompraUsuarioUltimaModificacion usuarioUltimaModificacion) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.ASOCIADO.value())) {
            this.libroId = new CompraLibroId(null);
            this.periodoUso = new CompraPeriodoUso(null);
            this.gestionUso = new CompraGestionUso(null);
            this.nombreFormularioUso = new CompraNombreFormularioUso(null);
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.REGISTRADO.value());
            this.impuestoUsoId = new CompraImpuestoUsoId(null);
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
            String marcaEspecial = this.marcaEspecialId != null ? this.marcaEspecialId.value() : "";
            this.record(new CompraDesAsociadaLibroDomainEvent(this.id.value(), libroId.value(),
                    this.usuarioUltimaModificacion.value(), this.fechaUltimaModificacion.value(),
                    this.estadoUsoId.value(), this.periodoUso.value(), this.gestionUso.value(),
                    this.impuestoUsoId.value(), this.nombreFormularioUso.value(), this.importeBaseCf.value(),
                    this.creditoFiscal.value(), this.importeTotalCompra.value(), marcaEspecial,
                    this.modalidadId.value()));
        }
    }

    public void propiarCompra() {
        if (this.estadoUsoId.value().equals(EstadoUsoId.REGISTRADO.value())) {
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.APROPIADO.value());
        }
    }

    public void declararCompra(CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.ASOCIADO.value())) {
            this.record(new CompraDeclaradaDomainEvent(this.id().value(),
                    this.estadoUsoId().value(),
                    this.usuarioUltimaModificacion().value(),
                    this.fechaUltimaModificacion().value(),
                    this.formularioId().value()));
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.DECLARADO.value());
        }
    }

    public void cancelarDeclaracionCompra(CompraUsuarioUltimaModificacion pCompraUsuarioUltimaModificacion) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.DECLARADO.value())) {
            this.record(new CompraDeclaracionCanceladaDomainEvent(
                    this.id().value(),
                    this.estadoUsoId().value(),
                    this.usuarioUltimaModificacion().value(),
                    this.fechaUltimaModificacion().value()));
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.ASOCIADO.value());
            this.usuarioUltimaModificacion = pCompraUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        }
    }

    public void consolidarCompra(CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.DECLARADO.value())) {
            this.record(new CompraConsolidadaDomainEvent(
                    this.id().value(),
                    this.estadoUsoId().value(),
                    this.usuarioUltimaModificacion().value(),
                    this.fechaUltimaModificacion().value()));
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.CONSOLIDADO.value());
            this.usuarioUltimaModificacion =  pUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        }
    }

    public void rechazarCompra( CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.DECLARADO.value())) {
            this.record(new CompraRechazadaDomainEvent(
                    this.id().value(),
                    this.estadoUsoId().value(),
                    this.usuarioUltimaModificacion().value(),
                    this.fechaUltimaModificacion().value()));
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.ASOCIADO.value());
            this.usuarioUltimaModificacion =  pUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        }
    }

    public void desdeclararCompraPorRectificacion(CompraFormularioId pFormularioId) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.DECLARADO.value())) {
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.ASOCIADO.value());
            this.formularioId = new CompraFormularioId(pFormularioId.value());
        }
    }

    public void desdeclararCompraPorRectificacionLibro(CompraLibroId pLibroId) {
        if (this.estadoUsoId.value().equals(EstadoUsoId.DECLARADO.value())) {
            this.estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.ASOCIADO.value());
            this.libroId = new CompraLibroId(pLibroId.value());
        }
    }

    public void modificar(CompraFechaFactura pFechaFactura, CompraNitProveedor pNitProveedor,
                          CompraIfcProveedorNb pIfcProveedorNb, CompraRazonSocialProveedor pRazonSocialProveedor,
                          CompraNumeroFactura pNumeroFactura, CompraCodigoAutorizacion pCodigoAutorizacion,
                          CompraImporteTotalCompra pImporteTotalCompra, CompraImporteBaseCf pImporteBaseCf,
                          CompraCodigoControl pCodigoControl, CompraOrigenId pOrigenId,
                          CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion, CompraModalidadId pModalidadId, CompraCreditoFiscal pCreditoFiscal, CompraMarcaEspecialId pMarcaEspecialId) {
        this.record(CompraModificadaDomainEvent.CompraRegistradaDomainEvent().id(this.id().value())
                .ifcProveedorNb(this.ifcProveedorNb().value()).nitProveedor(this.nitProveedor().value())
                .razonSocialProveedor(this.razonSocialProveedor().value())
                .numeroFactura(this.numeroFactura().value())
                .codigoAutorizacion(this.codigoAutorizacion().value()).fechaFactura(this.fechaFactura().value())
                .importeTotalCompra(this.importeTotalCompra().value())
                .importeBaseCf(this.importeBaseCf().value())
                .creditoFiscal(this.creditoFiscal().value())
                .codigoControl(this.codigoControl() != null ? this.codigoControl().value() : null)
                .modalidadId(this.modalidadId().value())
                .origenId(this.origenId().value())
                .marcaEspecialId(this.marcaEspecialId().value())
                .usuarioUltimaModificacion(this.usuarioUltimaModificacion().value())
                .fechaUltimaModificacion(this.fechaUltimaModificacion().value()).estadoId(this.estadoId().value())
                .build());
        this.fechaFactura = pFechaFactura;
        this.nitProveedor = pNitProveedor;
        this.ifcProveedorNb = pIfcProveedorNb == null ? this.ifcProveedorNb : pIfcProveedorNb;
        this.razonSocialProveedor = pRazonSocialProveedor == null ? this.razonSocialProveedor : pRazonSocialProveedor;
        this.numeroFactura = pNumeroFactura;
        this.codigoAutorizacion = pCodigoAutorizacion;
        this.importeTotalCompra = pImporteTotalCompra;
        this.importeBaseCf = pImporteBaseCf;
        this.codigoControl = pCodigoControl;
        this.origenId = pOrigenId;
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        this.modalidadId = pModalidadId;
        this.creditoFiscal = pCreditoFiscal;
        this.marcaEspecialId = pMarcaEspecialId;
    }

    public void modificarLibro(CompraIfcProveedorNb pIfcProveedorNb,
                               CompraNitProveedor pNitProveedor,
                               CompraRazonSocialProveedor pRazonSocialProveedor,
                               CompraNumeroFactura pNumeroFactura,
                               CompraNumeroDui pNumeroDui,
                               CompraCodigoAutorizacion pCodigoAutorizacion,
                               CompraFechaFactura pFechaFactura,
                               CompraImporteTotalCompra pImporteTotalCompra,
                               CompraImporteNoSujetoCf pimporteNoSujetoCf,
                               CompraDescuento pDescuento,
                               CompraImporteBaseCf pImporteBaseCf,
                               CompraCreditoFiscal pCreditoFiscal,
                               CompraCodigoControl pCodigoControl,
                               CompraOrigenId pOrigenId,
                               CompraModalidadId pModalidad,
                               CompraMarcaEspecialId pMarcaEspecialId,
                               CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                               CompraTipoCompraId pTipoCompraId) {
        CompraSubtotal vSubtotal = CompraSubtotal.subTotal(pImporteTotalCompra.value(), pimporteNoSujetoCf.value());
        this.ifcProveedorNb = pIfcProveedorNb == null ? this.ifcProveedorNb : pIfcProveedorNb;
        this.nitProveedor = pNitProveedor;
        this.razonSocialProveedor = pRazonSocialProveedor == null ? this.razonSocialProveedor : pRazonSocialProveedor;
        this.numeroFactura = pNumeroFactura;
        this.numeroDui = pNumeroDui;
        this.codigoAutorizacion = pCodigoAutorizacion;
        this.fechaFactura = pFechaFactura;
        this.importeTotalCompra = pImporteTotalCompra;
        this.importeNoSujetoCf = pimporteNoSujetoCf;
        this.descuento = pDescuento;
        this.subtotal = vSubtotal;
        this.importeBaseCf = pImporteBaseCf;
        this.creditoFiscal = pCreditoFiscal;
        this.codigoControl = pCodigoControl;
        this.origenId = pOrigenId;
        this.modalidadId = pModalidad;
        this.marcaEspecialId = pMarcaEspecialId;
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        this.tipoCompraId = pTipoCompraId == null ? this.tipoCompraId : pTipoCompraId;
    }

    public void modificarTipoCompra(CompraTipoCompraId pTipoCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        this.tipoCompraId = pTipoCompra;
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());

    }

    public void eliminar(CompraUsuarioUltimaModificacion usuarioUltimaModificacion) {
        this.record(new CompraEliminadaDomainEvent(
                this.id.value(),
                this.estadoId.value(),
                this.usuarioUltimaModificacion.value(),
                this.fechaUltimaModificacion.value()

        ));
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.estadoId = new CompraEstadoId(ConstEstado.ESTADO_ANULADO);
        this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
    }


    // Marcar Compra con Nota de Credito Debito NCD
    public void marcarNCD(CompraUsuarioUltimaModificacion usuarioUltimaModificacion) {
        this.estadoCompraId = new CompraEstadoCompraId(EstadoCompraId.NOTA_CREDITO_DEBITO.value());
        this.tipoObservacionId = new CompraTipoObservacionId(TipoObservacionId.REGISTRADA_NCD.value());
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = new CompraFechaUltimaModificacion(LocalDateTime.now());
        this.record(new CompraMarcadaNCDDomainEvent(this.id.value(), this.estadoCompraId.value(), this.tipoObservacionId.value(),
                this.usuarioUltimaModificacion.value(), this.fechaUltimaModificacion.value()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Compra compra = (Compra) o;
        return Objects.equals(id.value(), compra.id.value())
                && Objects.equals(ifcProveedorNb.value(), compra.ifcProveedorNb.value())
                && Objects.equals(nitProveedor.value(), compra.nitProveedor.value())
                && Objects.equals(razonSocialProveedor.value(), compra.razonSocialProveedor.value())
                && Objects.equals(numeroFactura.value(), compra.numeroFactura.value())
                && Objects.equals(numeroDui.value(), compra.numeroDui.value())
                && Objects.equals(codigoAutorizacion.value(), compra.codigoAutorizacion.value())
                && Objects.equals(fechaFactura.value(), compra.fechaFactura.value())
                && Objects.equals(importeTotalCompra.value(), compra.importeTotalCompra.value())
                && Objects.equals(importeNoSujetoCf.value(), compra.importeNoSujetoCf.value())
                && Objects.equals(subtotal.value(), compra.subtotal.value())
                && Objects.equals(descuento.value(), compra.descuento.value())
                && Objects.equals(importeBaseCf.value(), compra.importeBaseCf.value())
                && Objects.equals(creditoFiscal.value(), compra.creditoFiscal.value())
                && Objects.equals(codigoControl.value(), compra.codigoControl.value())
                && Objects.equals(tipoDocumentoId.value(), compra.tipoDocumentoId.value())
                && Objects.equals(tipoSectorId.value(), compra.tipoSectorId.value())
                && Objects.equals(modalidadId.value(), compra.modalidadId.value())
                && Objects.equals(estadoCompraId.value(), compra.estadoCompraId.value())
                && Objects.equals(tipoDocumentoCliente.value(), compra.tipoDocumentoCliente.value())
                && Objects.equals(numeroDocumentoCliente.value(), compra.numeroDocumentoCliente.value())
                && Objects.equals(complementoDocumentoCliente.value(), compra.complementoDocumentoCliente.value())
                && Objects.equals(nombreCliente.value(), compra.nombreCliente.value())
                && Objects.equals(origenId.value(), compra.origenId.value())
                && Objects.equals(estadoUsoId.value(), compra.estadoUsoId.value())
                && Objects.equals(impuestoUsoId.value(), compra.impuestoUsoId.value())
                && Objects.equals(gestionUso.value(), compra.gestionUso.value())
                && Objects.equals(periodoUso.value(), compra.periodoUso.value())
                && Objects.equals(nombreFormularioUso.value(), compra.nombreFormularioUso.value())
                && Objects.equals(formularioId.value(), compra.formularioId.value())
                && Objects.equals(libroId.value(), compra.libroId.value())
                && Objects.equals(ventaId.value(), compra.ventaId.value())
                && Objects.equals(recepcionId.value(), compra.recepcionId.value())
                && Objects.equals(secuencia.value(), compra.secuencia.value())
                && Objects.equals(conDerechoCf.value(), compra.conDerechoCf.value())
                && Objects.equals(tipoCompraId.value(), compra.tipoCompraId.value())
                && Objects.equals(tipoObservacionId.value(), compra.tipoObservacionId.value())
                && Objects.equals(marcaEspecialId.value(), compra.marcaEspecialId.value())
                && Objects.equals(usuarioRegistro.value(), compra.usuarioRegistro.value()) &&
                // Objects.equals(fechaRegistro.value(), compra.fechaRegistro.value())&&
                Objects.equals(usuarioUltimaModificacion.value(), compra.usuarioUltimaModificacion.value())
                && Objects.equals(fechaUltimaModificacion.value(), compra.fechaUltimaModificacion.value())
                && Objects.equals(estadoId.value(), compra.estadoId.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ifcProveedorNb, nitProveedor, razonSocialProveedor, numeroFactura, numeroDui,
                codigoAutorizacion, fechaFactura, importeTotalCompra, importeNoSujetoCf, subtotal, descuento,
                importeBaseCf, creditoFiscal, codigoControl, tipoDocumentoId, tipoSectorId, modalidadId, estadoCompraId,
                tipoDocumentoCliente, numeroDocumentoCliente, complementoDocumentoCliente, nombreCliente, origenId,
                estadoUsoId, impuestoUsoId, gestionUso, periodoUso, nombreFormularioUso, formularioId, libroId, ventaId,
                recepcionId, secuencia, conDerechoCf, tipoCompraId, tipoDocumentoId, usuarioRegistro, marcaEspecialId,
                fechaRegistro, usuarioUltimaModificacion, fechaUltimaModificacion, estadoId);
    }

    public void modificarSeleccionado(CompraFechaFactura pFechaFactura,
                                      CompraImporteTotalCompra pImporteTotalCompra,
                                      CompraImporteBaseCf pCompraImporteBaseCf,
                                      CompraCreditoFiscal pCompraCreditoFiscal,
                                      CompraCodigoControl pCodigoControl,
                                      CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                                      CompraOrigenId pOrigenId) {
        this.record(new CompraModificadoSeleccionadoDomainEvent(
                this.id.value(),
                this.fechaFactura.value(),
                this.importeTotalCompra.value(),
                this.importeBaseCf.value(),
                this.creditoFiscal.value(),
                this.codigoControl.value(),
                this.usuarioUltimaModificacion.value(),
                this.fechaUltimaModificacion.value(),
                this.origenId.value()
        ));
        this.fechaFactura = pFechaFactura;
        this.importeTotalCompra = pImporteTotalCompra;
        this.importeBaseCf = pCompraImporteBaseCf;
        this.creditoFiscal = pCompraCreditoFiscal;
        this.codigoControl = pCodigoControl;
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        this.origenId = pOrigenId;
    }

    public static final class Builder {
        private CompraId id;
        private CompraIfcProveedorNb ifcProveedorNb;
        private CompraNitProveedor nitProveedor;
        private CompraRazonSocialProveedor razonSocialProveedor;
        private CompraNumeroFactura numeroFactura;
        private CompraNumeroDui numeroDui;
        private CompraCodigoAutorizacion codigoAutorizacion;
        private CompraFechaFactura fechaFactura;
        private CompraImporteTotalCompra importeTotalCompra;
        private CompraImporteNoSujetoCf importeNoSujetoCf;
        private CompraSubtotal subtotal;
        private CompraDescuento descuento;
        private CompraImporteBaseCf importeBaseCf;
        private CompraCreditoFiscal creditoFiscal;
        private CompraCodigoControl codigoControl;
        private CompraTipoDocumentoId tipoDocumentoId;
        private CompraTipoSectorId tipoSectorId;

        private CompraModalidadId modalidadId;

        private CompraEstadoCompraId estadoCompraId;
        private CompraTipoDocumentoCliente tipoDocumentoCliente;
        private CompraNumeroDocumentoCliente numeroDocumentoCliente;
        private CompraComplementoDocumentoCliente complementoDocumentoCliente;
        private CompraNombreCliente nombreCliente;
        private CompraOrigenId origenId;
        private CompraEstadoUsoId estadoUsoId;
        private CompraImpuestoUsoId impuestoUsoId;
        private CompraGestionUso gestionUso;
        private CompraPeriodoUso periodoUso;
        private CompraNombreFormularioUso nombreFormularioUso;
        private CompraFormularioId formularioId;
        private CompraLibroId libroId;
        private CompraVentaId ventaId;
        private CompraRecepcionId recepcionId;
        private CompraSecuencia secuencia;

        private CompraConDerechoCf conDerechoCf;
        private CompraTipoCompraId tipoCompraId;
        private CompraTipoObservacionId tipoObservacionId;
        private CompraMarcaEspecialId marcaEspecialId;

        private CompraUsuarioRegistro usuarioRegistro;
        private CompraFechaRegistro fechaRegistro;
        private CompraUsuarioUltimaModificacion usuarioUltimaModificacion;
        private CompraFechaUltimaModificacion fechaUltimaModificacion;
        private CompraEstadoId estadoId;

        private Builder() {
        }

        public Compra build() {
            return new Compra(this);
        }

        public Builder id(CompraId id) {
            this.id = id;
            return this;
        }

        public Builder ifcProveedorNb(CompraIfcProveedorNb ifcProveedorNb) {
            this.ifcProveedorNb = ifcProveedorNb;
            return this;
        }

        public Builder nitProveedor(CompraNitProveedor nitProveedor) {
            this.nitProveedor = nitProveedor;
            return this;
        }

        public Builder razonSocialProveedor(CompraRazonSocialProveedor razonSocialProveedor) {
            this.razonSocialProveedor = razonSocialProveedor;
            return this;
        }

        public Builder recepcionId(CompraRecepcionId recepcionId) {
            this.recepcionId = recepcionId;
            return this;
        }

        public Builder secuencia(CompraSecuencia secuencia) {
            this.secuencia = secuencia;
            return this;
        }

        public Builder fechaFactura(CompraFechaFactura fechaFactura) {
            this.fechaFactura = fechaFactura;
            return this;
        }

        public Builder numeroFactura(CompraNumeroFactura numeroFactura) {
            this.numeroFactura = numeroFactura;
            return this;
        }

        public Builder numeroDui(CompraNumeroDui numeroDui) {
            this.numeroDui = numeroDui;
            return this;
        }

        public Builder codigoAutorizacion(CompraCodigoAutorizacion codigoAutorizacion) {
            this.codigoAutorizacion = codigoAutorizacion;
            return this;
        }

        public Builder importeTotalCompra(CompraImporteTotalCompra importeTotalCompra) {
            this.importeTotalCompra = importeTotalCompra;
            return this;
        }

        public Builder importeNoSujetoCf(CompraImporteNoSujetoCf importeNoSujetoCf) {
            this.importeNoSujetoCf = importeNoSujetoCf;
            return this;
        }

        public Builder subtotal(CompraSubtotal subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder descuento(CompraDescuento descuento) {
            this.descuento = descuento;
            return this;
        }

        public Builder importeBaseCf(CompraImporteBaseCf importeBaseCf) {
            this.importeBaseCf = importeBaseCf;
            return this;
        }

        public Builder creditoFiscal(CompraCreditoFiscal creditoFiscal) {
            this.creditoFiscal = creditoFiscal;
            return this;
        }

        public Builder codigoControl(CompraCodigoControl codigoControl) {
            this.codigoControl = codigoControl;
            return this;
        }

        public Builder tipoDocumentoId(CompraTipoDocumentoId tipoDocumentoId) {
            this.tipoDocumentoId = tipoDocumentoId;
            return this;
        }

        public Builder tipoSectorId(CompraTipoSectorId tipoSectorId) {
            this.tipoSectorId = tipoSectorId;
            return this;
        }

        public Builder estadoCompraId(CompraEstadoCompraId estadoCompraId) {
            this.estadoCompraId = estadoCompraId;
            return this;
        }

        public Builder tipoDocumentoCliente(CompraTipoDocumentoCliente tipoDocumentoCliente) {
            this.tipoDocumentoCliente = tipoDocumentoCliente;
            return this;
        }

        public Builder numeroDocumentoCliente(CompraNumeroDocumentoCliente numeroDocumentoCliente) {
            this.numeroDocumentoCliente = numeroDocumentoCliente;
            return this;
        }

        public Builder complementoDocumentoCliente(CompraComplementoDocumentoCliente complementoDocumentoCliente) {
            this.complementoDocumentoCliente = complementoDocumentoCliente;
            return this;
        }

        public Builder nombreCliente(CompraNombreCliente nombreCliente) {
            this.nombreCliente = nombreCliente;
            return this;
        }

        public Builder origenId(CompraOrigenId origenId) {
            this.origenId = origenId;
            return this;
        }

        public Builder estadoUsoId(CompraEstadoUsoId estadoUsoId) {
            this.estadoUsoId = estadoUsoId;
            return this;
        }

        public Builder impuestoUsoId(CompraImpuestoUsoId impuestoUsoId) {
            this.impuestoUsoId = impuestoUsoId;
            return this;
        }

        public Builder gestionUso(CompraGestionUso gestionUso) {
            this.gestionUso = gestionUso;
            return this;
        }

        public Builder periodoUso(CompraPeriodoUso periodoUso) {
            this.periodoUso = periodoUso;
            return this;
        }

        public Builder nombreFormularioUso(CompraNombreFormularioUso nombreFormularioUso) {
            this.nombreFormularioUso = nombreFormularioUso;
            return this;
        }

        public Builder formularioId(CompraFormularioId formularioId) {
            this.formularioId = formularioId;
            return this;
        }

        public Builder libroId(CompraLibroId libroId) {
            this.libroId = libroId;
            return this;
        }

        public Builder ventaId(CompraVentaId ventaId) {
            this.ventaId = ventaId;
            return this;
        }

        public Builder conDerechoCf(CompraConDerechoCf conDerechoCf) {
            this.conDerechoCf = conDerechoCf;
            return this;
        }

        public Builder tipoCompraId(CompraTipoCompraId tipoCompraId) {
            this.tipoCompraId = tipoCompraId;
            return this;
        }

        public Builder tipoObservacionId(CompraTipoObservacionId tipoObservacionId) {
            this.tipoObservacionId = tipoObservacionId;
            return this;
        }

        public Builder marcaEspecialId(CompraMarcaEspecialId marcaEspecialId) {
            this.marcaEspecialId = marcaEspecialId;
            return this;
        }

        public Builder usuarioRegistro(CompraUsuarioRegistro usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }

        public Builder fechaRegistro(CompraFechaRegistro fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Builder usuarioUltimaModificacion(CompraUsuarioUltimaModificacion usuarioUltimaModificacion) {
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            return this;
        }

        public Builder fechaUltimaModificacion(CompraFechaUltimaModificacion fechaUltimaModificacion) {
            this.fechaUltimaModificacion = fechaUltimaModificacion;
            return this;
        }

        public Builder estadoId(CompraEstadoId estadoId) {
            this.estadoId = estadoId;
            return this;
        }

        public Builder modalidadId(CompraModalidadId modalidadId) {
            this.modalidadId = modalidadId;
            return this;
        }
    }
}
